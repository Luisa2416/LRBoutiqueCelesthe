package servlet;

import producto.Producto;
import producto.ProductoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            ProductoDAO dao = new ProductoDAO();

            List<Producto> productos = dao.listar();

            request.setAttribute("productos", productos);

            request.getRequestDispatcher("/jsp/productos.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    "ERROR AL CONSULTAR PRODUCTOS: " + e.getMessage()
            );

            request.getRequestDispatcher("/jsp/productos.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String precioTexto = request.getParameter("precio");
        String cantidadTexto = request.getParameter("cantidad");

        try {

            double precio = Double.parseDouble(precioTexto);
            int cantidad = Integer.parseInt(cantidadTexto);

            Producto producto = new Producto(
                    0,
                    nombre,
                    "",
                    precio,
                    cantidad
            );

            ProductoDAO dao = new ProductoDAO();

            boolean registrado = dao.insertar(producto);

            if (registrado) {

                request.setAttribute(
                        "nombreProducto",
                        nombre
                );

                request.setAttribute(
                        "precioProducto",
                        precioTexto
                );

                request.setAttribute(
                        "cantidadProducto",
                        cantidadTexto
                );

                request.setAttribute(
                        "mensaje",
                        "Producto registrado correctamente."
                );

            } else {

                request.setAttribute(
                        "error",
                        "El producto NO fue registrado en la base de datos."
                );
            }

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    "ERROR REAL: " + e.getMessage()
            );
        }

        request.getRequestDispatcher("/jsp/productos.jsp")
                .forward(request, response);
    }
}