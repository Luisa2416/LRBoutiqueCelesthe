package pedido;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidoDAO {

    public void insertarPedido(int idUsuario, String fecha, String estado) {
        String sql = "INSERT INTO pedido (id_usuario, fecha, estado) VALUES (?, ?, ?)";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, idUsuario);
            sentencia.setString(2, fecha);
            sentencia.setString(3, estado);

            sentencia.executeUpdate();

            System.out.println("Pedido insertado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al insertar pedido: " + e.getMessage());
        }
    }

    public void consultarPedidos() {
        String sql = "SELECT * FROM pedido";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                System.out.println(
                    "ID: " + resultado.getInt("id_pedido") +
                    " | Usuario: " + resultado.getInt("id_usuario") +
                    " | Fecha: " + resultado.getString("fecha") +
                    " | Estado: " + resultado.getString("estado")
                );
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al consultar pedidos: " + e.getMessage());
        }
    }

    public void actualizarPedido(int idPedido, String estado) {
        String sql = "UPDATE pedido SET estado = ? WHERE id_pedido = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, estado);
            sentencia.setInt(2, idPedido);

            sentencia.executeUpdate();

            System.out.println("Pedido actualizado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar pedido: " + e.getMessage());
        }
    }

    public void eliminarPedido(int idPedido) {
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, idPedido);

            sentencia.executeUpdate();

            System.out.println("Pedido eliminado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
        }
    }
}