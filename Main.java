import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/LRBoutiqueCeleste";
        String usuario = "root";
        String password = "";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);

            String sql = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio) VALUES (?, ?, ?, ?)";

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, 1);
            sentencia.setInt(2, 1);
            sentencia.setInt(3, 2);
            sentencia.setDouble(4, 35000);

            sentencia.executeUpdate();

            System.out.println("Detalle del pedido registrado correctamente.");

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}