package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/lrboutiquecelesthe?useSSL=false&serverTimezone=UTC";

    private static final String USUARIO = "root";

    private static final String CONTRASENA = "";

    public static Connection conectar() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    CONTRASENA
            );

            System.out.println(
                    "CONEXION EXITOSA A: " + conexion.getCatalog()
            );

            return conexion;

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(
                    "NO SE ENCONTRO EL DRIVER MYSQL: " + e.getMessage(), e
            );

        } catch (SQLException e) {

            throw new RuntimeException(
                    "ERROR MYSQL: " + e.getMessage(), e
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "ERROR GENERAL DE CONEXION: " + e.getMessage(), e
            );
        }
    }
}