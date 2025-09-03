package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class ModificarDependenciaControl implements ActionListener{
    vista.ModiDependenciaInternalFrame modificarVista;
    modelo.GestorDependencia dependenciaModelo;
    modelo.Dependencia dep;
    
    public ModificarDependenciaControl(vista.ModiDependenciaInternalFrame modificarVista){
        this.modificarVista=modificarVista;
        dependenciaModelo=new modelo.GestorDependencia();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(modificarVista.modificar)) {
            String valor=modificarVista.valor.getText();
            int id=Integer.parseInt(modificarVista.idDependencia.getText());
            dep=new modelo.Dependencia(valor, id);
            dependenciaModelo.modificarDependencia(dep);
        }
    }
}