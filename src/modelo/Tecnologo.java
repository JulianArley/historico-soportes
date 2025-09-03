package modelo;
public class Tecnologo {
    private String identificacion;
    private String nombres;
    private String apellidos;

    public Tecnologo(String id, String nom, String ape) {
        this.identificacion = id;
        this.nombres = nom;
        this.apellidos = ape;
        
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
}
