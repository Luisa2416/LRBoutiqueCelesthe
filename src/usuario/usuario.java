public class Usuario {

    private int idUsuario;
    private String nombre;
    private String correo;
    private String password;

    public Usuario(int idUsuario, String nombre, String correo, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }
}