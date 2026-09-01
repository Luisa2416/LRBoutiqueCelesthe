import producto.ProductoDAO;

public class PruebaProducto {

    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAO();

        // INSERTAR
        productoDAO.insertarProducto(
            "Pantalon negro",
            "Pantalon de mezclilla",
            80000,
            15
        );

        // CONSULTAR
        System.out.println("\n--- PRODUCTOS ---");
        productoDAO.consultarProductos();

        // ACTUALIZAR
        productoDAO.actualizarProducto(1, 85000, 12);

        // ELIMINAR
        productoDAO.eliminarProducto(2);
    }
}