package detalle;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DetallePedidoDAO {

    public void insertarDetalle(int idPedido, int idProducto, int cantidad, double precio) {
        String sql = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio) VALUES (?, ?, ?, ?)";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, idPedido);
            sentencia.setInt(2, idProducto);
            sentencia.setInt(3, cantidad);
            sentencia.setDouble(4, precio);

            sentencia.executeUpdate();

            System.out.println("Detalle de pedido insertado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al insertar detalle: " + e.getMessage());
        }
    }

    public void consultarDetalles() {
        String sql = "SELECT * FROM detalle_pedido";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                System.out.println(
                    "ID: " + resultado.getInt("id_detalle") +
                    " | Pedido: " + resultado.getInt("id_pedido") +
                    " | Producto: " + resultado.getInt("id_producto") +
                    " | Cantidad: " + resultado.getInt("cantidad") +
                    " | Precio: " + resultado.getDouble("precio")
                );
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al consultar detalles: " + e.getMessage());
        }
    }

    public void actualizarDetalle(int idDetalle, int cantidad, double precio) {
        String sql = "UPDATE detalle_pedido SET cantidad = ?, precio = ? WHERE id_detalle = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, cantidad);
            sentencia.setDouble(2, precio);
            sentencia.setInt(3, idDetalle);

            sentencia.executeUpdate();

            System.out.println("Detalle de pedido actualizado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar detalle: " + e.getMessage());
        }
    }

    public void eliminarDetalle(int idDetalle) {
        String sql = "DELETE FROM detalle_pedido WHERE id_detalle = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, idDetalle);

            sentencia.executeUpdate();

            System.out.println("Detalle de pedido eliminado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar detalle: " + e.getMessage());
        }
    }
}