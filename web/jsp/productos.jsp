<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="producto.Producto" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos - LR Boutique Celesthe</title>
</head>

<body>

    <h1>LR Boutique Celesthe</h1>

    <h2>Módulo de Productos</h2>

    <%
        String mensaje = (String) request.getAttribute("mensaje");
        String error = (String) request.getAttribute("error");

        if (mensaje != null) {
    %>

        <h3><%= mensaje %></h3>

    <%
        }

        if (error != null) {
    %>

        <h3><%= error %></h3>

    <%
        }

        List<Producto> productos =
                (List<Producto>) request.getAttribute("productos");
    %>

    <h2>Productos registrados</h2>

    <%
        if (productos != null && !productos.isEmpty()) {
    %>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Stock</th>
            </tr>

            <%
                for (Producto producto : productos) {
            %>

                <tr>
                    <td><%= producto.getIdProducto() %></td>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getDescripcion() %></td>
                    <td>$<%= producto.getPrecio() %></td>
                    <td><%= producto.getStock() %></td>
                </tr>

            <%
                }
            %>

        </table>

    <%
        } else {
    %>

        <p>No hay productos registrados.</p>

    <%
        }
    %>

    <br>

    <a href="<%= request.getContextPath() %>/index.html">
        Registrar otro producto
    </a>

</body>
</html>