package usuario;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public void registrarUsuario(String nombre, String correo, String password) {
        String sql = "INSERT INTO usuario (nombre, correo, password) VALUES (?, ?, ?)";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, nombre);
            sentencia.setString(2, correo);
            sentencia.setString(3, password);

            sentencia.executeUpdate();

            System.out.println("Usuario registrado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    public void consultarUsuarios() {
        String sql = "SELECT * FROM usuario";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                System.out.println(
                    "ID: " + resultado.getInt("id_usuario") +
                    " | Nombre: " + resultado.getString("nombre") +
                    " | Correo: " + resultado.getString("correo")
                );
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al consultar usuarios: " + e.getMessage());
        }
    }

    public void actualizarUsuario(int idUsuario, String nombre, String correo) {
        String sql = "UPDATE usuario SET nombre = ?, correo = ? WHERE id_usuario = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, nombre);
            sentencia.setString(2, correo);
            sentencia.setInt(3, idUsuario);

            sentencia.executeUpdate();

            System.out.println("Usuario actualizado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, idUsuario);

            sentencia.executeUpdate();

            System.out.println("Usuario eliminado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}