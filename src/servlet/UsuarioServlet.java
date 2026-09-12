package servlet;

import usuario.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    // Procesa las solicitudes POST para registrar usuarios o iniciar sesión.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Obtiene la acción enviada desde el formulario.
        String accion = request.getParameter("accion");

        // Obtiene los datos enviados por el usuario.
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();

        // Registro de un nuevo usuario.
        if ("registrar".equals(accion)) {

            try {

                dao.registrarUsuario(nombre, correo, password);

                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println(
                    "<h2>Usuario registrado correctamente.</h2>"
                );

            } catch (Exception e) {

                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println(
                    "<h2>Error al registrar usuario.</h2>"
                );
            }

        // Inicio de sesión y autenticación del usuario.
        } else if ("login".equals(accion)) {

            boolean autenticado = dao.autenticarUsuario(correo, password);

            response.setContentType("text/html;charset=UTF-8");

            if (autenticado) {

                response.getWriter().println(
                    "<h2>Autenticación satisfactoria.</h2>"
                );

            } else {

                response.getWriter().println(
                    "<h2>Error en la autenticación.</h2>"
                );
            }

        } else {

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(
                "<h2>Acción no válida.</h2>"
            );
        }
    }
}