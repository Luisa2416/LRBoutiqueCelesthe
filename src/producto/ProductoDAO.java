package producto;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public boolean insertar(Producto producto) {

        String sql = "INSERT INTO producto "
                   + "(nombre, descripcion, precio, stock) "
                   + "VALUES (?, ?, ?, ?)";

        Connection conexion = null;

        try {

            conexion = Conexion.conectar();

            if (conexion == null) {
                throw new RuntimeException(
                    "No se pudo conectar a la base de datos lrboutiquecelesthe."
                );
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {

                ps.setString(1, producto.getNombre());
                ps.setString(2, producto.getDescripcion());
                ps.setDouble(3, producto.getPrecio());
                ps.setInt(4, producto.getStock());

                int resultado = ps.executeUpdate();

                System.out.println("Filas insertadas: " + resultado);

                return resultado > 0;
            }

        } catch (Exception e) {

            throw new RuntimeException(
                "Error al insertar producto: " + e.getMessage(), e
            );

        } finally {

            if (conexion != null) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    System.out.println(
                        "Error al cerrar conexión: " + e.getMessage()
                    );
                }
            }
        }
    }

    public List<Producto> listar() {

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT * FROM producto";

        try (Connection conexion = Conexion.conectar()) {

            if (conexion == null) {
                throw new RuntimeException(
                    "No se pudo conectar a la base de datos lrboutiquecelesthe."
                );
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                    );

                    productos.add(producto);
                }
            }

        } catch (Exception e) {

            throw new RuntimeException(
                "Error al consultar productos: " + e.getMessage(), e
            );
        }

        return productos;
    }
}