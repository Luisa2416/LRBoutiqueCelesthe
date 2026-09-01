import pedido.PedidoDAO;

public class PruebaPedido {

    public static void main(String[] args) {

        PedidoDAO pedidoDAO = new PedidoDAO();

        // INSERTAR
        pedidoDAO.insertarPedido(
            1,
            "2026-09-01",
            "Pendiente"
        );

        // CONSULTAR
        System.out.println("\n--- PEDIDOS ---");
        pedidoDAO.consultarPedidos();

        // ACTUALIZAR
        pedidoDAO.actualizarPedido(
            1,
            "En proceso"
        );
    }
}