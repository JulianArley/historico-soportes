package controlador;

import java.awt.event.*;

public class DependenciaControl implements ActionListener{
    vista.RegDependenciaInternalFrame dependenciaVista;
    modelo.Dependencia dependenciaModelo;
    modelo.GestorDependencia gestorDependenciaModelo;
    
    public DependenciaControl(vista.RegDependenciaInternalFrame dependenciaVista){
        this.dependenciaVista=dependenciaVista;
        gestorDependenciaModelo = new modelo.GestorDependencia();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(dependenciaVista.regDependencia)) {
            String valor = dependenciaVista.dependencia.getText();
            dependenciaModelo=new modelo.Dependencia(valor,0);
            gestorDependenciaModelo.registrarDependencia(dependenciaModelo);
        }
    }
}
