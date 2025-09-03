package controlador;

import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class GestorTecnologoControl implements ActionListener{
    
    modelo.GestorTecnologo tecnologoModelo;
    vista.ConsTecnologoInternalFrame consultarTecnologoVista;
    
    public GestorTecnologoControl(vista.ConsTecnologoInternalFrame consultarTecnologoVista){
        this.consultarTecnologoVista=consultarTecnologoVista;
        tecnologoModelo=new modelo.GestorTecnologo();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        String valor=consultarTecnologoVista.ValorTxt.getText();
        int param=0;
        consultarTecnologoVista.getTableModel().setRowCount(0);
        consultarTecnologoVista.getTableModel().fireTableDataChanged();
        if (consultarTecnologoVista.IdentificadorOpt.isSelected()) {
            param=1;
        }
        if (consultarTecnologoVista.NombresOpt.isSelected()) {
            param=2;
        }
        if (consultarTecnologoVista.ApellidosOpt.isSelected()) {
            param=3;
        }
        if (consultarTecnologoVista.todoOpt.isSelected()) {
            param=4;
        }
        
        LinkedList<modelo.Tecnologo> tecnologos=tecnologoModelo.getTecnologo(param, valor);
        String reg[]=new String[5];
        for(modelo.Tecnologo p:tecnologos){
            reg[0]=p.getIdentificacion();
            reg[1]=p.getNombres();
            reg[2]=p.getApellidos();
            consultarTecnologoVista.getTableModel().addRow(reg);
            consultarTecnologoVista.getTableModel().fireTableDataChanged();
        }
        
        
    }
}
