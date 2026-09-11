package pedido;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    // Registrar un pedido
    public boolean insertar(Pedido pedido) {

        String sql = "INSERT INTO lrboutiquecelesthe.pedido "
                   + "(id_usuario, fecha, estado) "
                   + "VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, pedido.getIdUsuario());
            ps.setString(2, pedido.getFecha());
            ps.setString(3, pedido.getEstado());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(
                "Error al registrar el pedido: " + e.getMessage(), e
            );
        }
    }

    // Consultar todos los pedidos
    public List<Pedido> listar() {

        List<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT id_pedido, id_usuario, fecha, estado "
                   + "FROM lrboutiquecelesthe.pedido";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Pedido pedido = new Pedido(
                    rs.getInt("id_pedido"),
                    rs.getInt("id_usuario"),
                    rs.getString("fecha"),
                    rs.getString("estado")
                );

                pedidos.add(pedido);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                "Error al consultar los pedidos: " + e.getMessage(), e
            );
        }

        return pedidos;
    }
}