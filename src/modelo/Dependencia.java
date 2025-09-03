package modelo;

import javax.swing.JOptionPane;

public class Dependencia {
    public String nomDependencia;
    public int idDependencia;
    
    public Dependencia(){
    
    }

    public Dependencia(String nomDependencia, int idDependencia) {
        this.nomDependencia = nomDependencia;
        this.idDependencia = idDependencia;
    }
    
    

    public String getNomDependencia() {
        return nomDependencia;
    }

    public void setNomDependencia(String nomDependencia) {
        this.nomDependencia = nomDependencia;
    }

    public int getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }
    
    
    
}
