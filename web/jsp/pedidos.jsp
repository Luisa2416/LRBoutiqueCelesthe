<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="pedido.Pedido" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Pedidos - LR Boutique Celesthe</title>
</head>

<body>

    <h1>LR Boutique Celesthe</h1>

    <h2>Módulo de Pedidos</h2>

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

        List<Pedido> pedidos =
                (List<Pedido>) request.getAttribute("pedidos");
    %>

    <h2>Pedidos registrados</h2>

    <%
        if (pedidos != null && !pedidos.isEmpty()) {
    %>

        <table border="1">

            <tr>
                <th>ID Pedido</th>
                <th>ID Usuario</th>
                <th>Fecha</th>
                <th>Estado</th>
            </tr>

            <%
                for (Pedido pedido : pedidos) {
            %>

                <tr>
                    <td><%= pedido.getIdPedido() %></td>
                    <td><%= pedido.getIdUsuario() %></td>
                    <td><%= pedido.getFecha() %></td>
                    <td><%= pedido.getEstado() %></td>
                </tr>

            <%
                }
            %>

        </table>

    <%
        } else {
    %>

        <p>No hay pedidos registrados.</p>

    <%
        }
    %>

    <br>

    <a href="<%= request.getContextPath() %>/index.html">
        Volver al inicio
    </a>

</body>

</html>