package producto;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    public void insertarProducto(String nombre, String descripcion, double precio, int stock) {
        String sql = "INSERT INTO producto (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, nombre);
            sentencia.setString(2, descripcion);
            sentencia.setDouble(3, precio);
            sentencia.setInt(4, stock);

            sentencia.executeUpdate();

            System.out.println("Producto insertado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }
    }

    public void consultarProductos() {
        String sql = "SELECT * FROM producto";

        try {
            Connection conexion = Conexion.conectar();
            conexion.createStatement().execute("SET NAMES utf8mb4");
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                System.out.println(
                    "ID: " + resultado.getInt("id_producto") +
                    " | Nombre: " + resultado.getString("nombre") +
                    " | Descripcion: " + resultado.getString("descripcion") +
                    " | Precio: " + resultado.getDouble("precio") +
                    " | Stock: " + resultado.getInt("stock")
                );
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al consultar productos: " + e.getMessage());
        }
    }

    public void actualizarProducto(int idProducto, double precio, int stock) {
        String sql = "UPDATE producto SET precio = ?, stock = ? WHERE id_producto = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setDouble(1, precio);
            sentencia.setInt(2, stock);
            sentencia.setInt(3, idProducto);

            sentencia.executeUpdate();

            System.out.println("Producto actualizado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(int idProducto) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, idProducto);

            sentencia.executeUpdate();

            System.out.println("Producto eliminado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }
}