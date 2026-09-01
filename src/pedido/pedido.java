public class Pedido {

    private int idPedido;
    private int idUsuario;
    private String fecha;
    private String estado;

    public Pedido(int idPedido, int idUsuario, String fecha, String estado) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }
}