package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.LinkedList;
import modelo.GestorSoporte;
import vista.ElimSoporteInternalFrame;


public class EliminarSoporteControl implements ActionListener{
    vista.ElimSoporteInternalFrame eliminarVista;
    modelo.GestorSoporte soportesModelo;

    public EliminarSoporteControl(vista.ElimSoporteInternalFrame eliminarVista) {
        this.eliminarVista = eliminarVista;
        soportesModelo=new modelo.GestorSoporte();
        
        /*eliminarVista.getTableModel().setRowCount(0);
        eliminarVista.getTableModel().fireTableDataChanged();
        
        LinkedList<modelo.Soporte>sop=soportesModelo.getSoportes();
        String reg[]=new String[4];
        for (modelo.Soporte s: sop) {
            reg[0]=Integer.toString(s.getIdSoporte());
            reg[1]=s.getDescSoporte();
            reg[2]=s.getNomUsuario();
            reg[3]=s.getFechaSop();
            eliminarVista.getTableModel().addRow(reg);
            eliminarVista.getTableModel().fireTableDataChanged();
        }*/
        
  }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int valor=parseInt(eliminarVista.id.getText());
        eliminarVista.getTableModel().setRowCount(0);
        eliminarVista.getTableModel().fireTableDataChanged();
        
        
        
        LinkedList<modelo.Soporte>sop=soportesModelo.eliminarSoporte(valor);
        String reg[]=new String[4];
        for (modelo.Soporte s: sop) {
            reg[0]=Integer.toString(s.getIdSoporte());
            reg[1]=s.getDescSoporte();
            reg[2]=s.getNomUsuario();
            reg[3]=s.getFechaSop();
            eliminarVista.getTableModel().addRow(reg);
            eliminarVista.getTableModel().fireTableDataChanged();
        }
    }
}
