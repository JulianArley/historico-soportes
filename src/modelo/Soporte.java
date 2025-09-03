package modelo;
public class Soporte {
    public int idSoporte;
    public String descSoporte;
    public String nomUsuario;
    public String fechaSop;
    public String hora;
    public String tipo;
    public String dependencia;
    public String tecnologo;
    public int idTecnologo;
    public String estado;
    
    
    public Soporte(){
        
    }

    public Soporte(int idSoporte, String descSoporte, String nomUsuario, String fechaSop) {
        this.idSoporte = idSoporte;
        this.descSoporte = descSoporte;
        this.nomUsuario = nomUsuario;
        this.fechaSop = fechaSop;
    }
    

    public Soporte(int idSoporte, String descSoporte, String nomUsuario, String fechaSop, String hora, String tipo, String dependencia, String tecnologo,String est) {
        this.idSoporte = idSoporte;
        this.descSoporte = descSoporte;
        this.nomUsuario = nomUsuario;
        this.fechaSop = fechaSop;
        this.hora = hora;
        this.tipo = tipo;
        this.dependencia = dependencia;
        this.tecnologo = tecnologo;
        this.estado=est;
    }

    public int getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(int idSoporte) {
        this.idSoporte = idSoporte;
    }


    public String getDescSoporte() {
        return descSoporte;
    }

    public void setDescSoporte(String descSoporte) {
        this.descSoporte = descSoporte;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getFechaSop() {
        return fechaSop;
    }

    public void setFechaSop(String fechaSop) {
        this.fechaSop = fechaSop;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getTecnologo() {
        return tecnologo;
    }

    public void setTecnologo(String tecnologo) {
        this.tecnologo = tecnologo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}