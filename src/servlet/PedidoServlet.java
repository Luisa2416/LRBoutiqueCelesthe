package servlet;

import pedido.Pedido;
import pedido.PedidoDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PedidoServlet extends HttpServlet {

    // Consultar todos los pedidos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PedidoDAO dao = new PedidoDAO();
            List<Pedido> pedidos = dao.listar();

            request.setAttribute("pedidos", pedidos);

            request.getRequestDispatcher("/jsp/pedidos.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            request.setAttribute(
                    "error",
                    "ERROR AL CONSULTAR PEDIDOS: " + e.getMessage()
            );

            request.getRequestDispatcher("/jsp/pedidos.jsp")
                    .forward(request, response);
        }
    }

    // Registrar un nuevo pedido
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String idUsuarioTexto = request.getParameter("idUsuario");

        try {
            int idUsuario = Integer.parseInt(idUsuarioTexto);

            Pedido pedido = new Pedido(
                    0,
                    idUsuario,
                    null,
                    "Pendiente"
            );

            PedidoDAO dao = new PedidoDAO();

            boolean registrado = dao.insertar(pedido);

            if (registrado) {
                request.setAttribute(
                        "mensaje",
                        "Pedido registrado correctamente."
                );
            } else {
                request.setAttribute(
                        "error",
                        "El pedido NO fue registrado en la base de datos."
                );
            }

        } catch (Exception e) {
            request.setAttribute(
                    "error",
                    "ERROR REAL: " + e.getMessage()
            );
        }

        request.getRequestDispatcher("/jsp/pedidos.jsp")
                .forward(request, response);
    }
}