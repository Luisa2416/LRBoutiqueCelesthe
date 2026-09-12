package usuario;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    // Registra un nuevo usuario en la base de datos.
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

    // Consulta todos los usuarios registrados.
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

    // Actualiza los datos básicos de un usuario.
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

    // Elimina un usuario mediante su identificador.
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

    // Verifica si existe un usuario con el correo y contraseña recibidos.
    // Retorna true si la autenticación es correcta y false si no coincide.
    public boolean autenticarUsuario(String correo, String password) {

        String sql = "SELECT * FROM usuario WHERE correo = ? AND password = ?";

        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, correo);
            sentencia.setString(2, password);

            ResultSet resultado = sentencia.executeQuery();

            boolean autenticado = resultado.next();

            resultado.close();
            sentencia.close();
            conexion.close();

            return autenticado;

        } catch (Exception e) {
            System.out.println("Error al autenticar usuario: " + e.getMessage());
            return false;
        }
    }
}