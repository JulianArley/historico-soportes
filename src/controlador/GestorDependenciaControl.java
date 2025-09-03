package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GestorDependenciaControl implements ActionListener{
    
    vista.ConsDependenciaInternalFrame dependenciaVista;
    modelo.GestorDependencia dependenciaModelo;
    
    public GestorDependenciaControl(vista.ConsDependenciaInternalFrame dependenciaVista){
        this.dependenciaVista=dependenciaVista;
        dependenciaModelo=new modelo.GestorDependencia();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        dependenciaVista.getTableModel().setRowCount(0);
        dependenciaVista.getTableModel().fireTableDataChanged();
        
        String sql="";
        if (dependenciaVista.todoOpt.isSelected()) {
            sql="SELECT * FROM dependencias";
        }
        if (dependenciaVista.nombreOpt.isSelected()) {
            String valor=dependenciaVista.valor.getText();
            sql="SELECT * FROM dependencias where Dependencia='"+valor+"'";
        }
        LinkedList<modelo.Dependencia> list=dependenciaModelo.consultarDependencia(sql);
        String[] res=new String[2];
        for(modelo.Dependencia d:list){
            res[0]=d.getIdDependencia()+"";
            res[1]=d.getNomDependencia();
            dependenciaVista.getTableModel().addRow(res);
            dependenciaVista.getTableModel().fireTableDataChanged();
        }
    }
    
}