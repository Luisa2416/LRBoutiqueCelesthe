import usuario.UsuarioDAO;

public class PruebaUsuario {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // INSERTAR
        usuarioDAO.registrarUsuario(
            "Carlos",
            "carlos@gmail.com",
            "123456"
        );

        // CONSULTAR
        System.out.println("\n--- USUARIOS ---");
        usuarioDAO.consultarUsuarios();

        // ACTUALIZAR
        usuarioDAO.actualizarUsuario(
            1,
            "Carlos actualizado",
            "carlosnuevo@gmail.com"
        );

        // ELIMINAR
        // No eliminamos todavía para conservar el usuario de prueba.
    }
}