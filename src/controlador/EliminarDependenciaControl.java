package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EliminarDependenciaControl implements ActionListener{
    vista.ElimDependenciaInternalFrame eliminarVista;
    modelo.GestorDependencia dependenciaModelo;
    modelo.Dependencia dep;
    
    public EliminarDependenciaControl(vista.ElimDependenciaInternalFrame eliminarVista){
        this.eliminarVista=eliminarVista;
        dependenciaModelo=new modelo.GestorDependencia();
        dep=new modelo.Dependencia();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int id=Integer.parseInt(eliminarVista.idDependencia.getText());
        dep.setIdDependencia(id);
        dep.setNomDependencia(null);
        dependenciaModelo.eliminarDependencia(dep);
    }
}
