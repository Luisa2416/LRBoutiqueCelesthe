package pedido;

public class Pedido {

    private int idPedido;
    private int idUsuario;
    private String fecha;
    private String estado;

    // Constructor
    public Pedido(int idPedido, int idUsuario, String fecha, String estado) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Obtener ID del pedido
    public int getIdPedido() {
        return idPedido;
    }

    // Obtener ID del usuario
    public int getIdUsuario() {
        return idUsuario;
    }

    // Obtener fecha
    public String getFecha() {
        return fecha;
    }

    // Obtener estado
    public String getEstado() {
        return estado;
    }
}