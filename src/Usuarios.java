public class Usuarios {
    private String nombre;
    private String correo;
    private String preferencias;
    private String lineaBaseDatos;
    public Usuarios(String nombre, String correo, String preferencias){
        this.nombre = nombre;
        this.correo = correo;
        this.preferencias = preferencias;
        this.lineaBaseDatos = nombre + "|" + correo + "|" + preferencias + "|";
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public String getLineaBaseDatos(){
        return lineaBaseDatos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
