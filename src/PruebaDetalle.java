import detalle.DetallePedidoDAO;

public class PruebaDetalle {

    public static void main(String[] args) {

        DetallePedidoDAO detalleDAO = new DetallePedidoDAO();

        detalleDAO.insertarDetalle(1, 1, 2, 35000);

        System.out.println("\n--- DETALLES DE PEDIDO ---");
        detalleDAO.consultarDetalles();

        detalleDAO.actualizarDetalle(1, 3, 35000);
    }
}