package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class EliminarTecnologoControl implements ActionListener{
    vista.ElimTecnologoInternalFrame eliminarVista;
    modelo.GestorTecnologo tecnologosModelo;
    public EliminarTecnologoControl(vista.ElimTecnologoInternalFrame eliminarVista){
        this.eliminarVista=eliminarVista;
        tecnologosModelo=new modelo.GestorTecnologo();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String valor=eliminarVista.ValorTxt.getText();
        int param=0;
        eliminarVista.getTableModel().setRowCount(0);
        eliminarVista.getTableModel().fireTableDataChanged();
        if (eliminarVista.IdentificacionOpt.isSelected()) {
            param=1;
        }
        if (eliminarVista.NombresOpt.isSelected()) {
            param=2;
        }
        if (eliminarVista.ApellidosOpt.isSelected()) {
            param=3;
        }
        LinkedList<modelo.Tecnologo>pacientes=tecnologosModelo.eliminarTecnologo(param, valor);
        String reg[]=new String[5];
        for(modelo.Tecnologo p:pacientes){
            reg[0]=p.getIdentificacion();
            reg[1]=p.getNombres();
            reg[2]=p.getApellidos();
            eliminarVista.getTableModel().addRow(reg);
            eliminarVista.getTableModel().fireTableDataChanged();
        }
    }
    
}
