package controlador;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorSoporteControl implements ActionListener {

    modelo.GestorSoporte soporteModelo;
    vista.ConsSoporteInternalFrame consultarSoporteVista;

    public GestorSoporteControl(vista.ConsSoporteInternalFrame consultarSoporteVista) {
        this.consultarSoporteVista = consultarSoporteVista;
        soporteModelo = new modelo.GestorSoporte();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        consultarSoporteVista.getTableModel().setRowCount(0);
        consultarSoporteVista.getTableModel().fireTableDataChanged();

        String param = "";
        String valor = "";

        if (consultarSoporteVista.usuarioOpt.isSelected()) {
            param = "d.Dependencia";
            valor = consultarSoporteVista.valor.getText();
            valor.toLowerCase();
            valor.toUpperCase().charAt(0);
        }
        if (consultarSoporteVista.tipoOpt.isSelected()) {
            param = "i.tipo";
            valor = consultarSoporteVista.valor.getText();
        }
        if (consultarSoporteVista.tecnologoOpt.isSelected()) {
            param = "i.tecnologoSoporteFK";
            valor = consultarSoporteVista.valor.getText();
        }
        if (consultarSoporteVista.fechaOpt.isSelected()) {
            param = "i.soporteFecha";
            valor = consultarSoporteVista.fechaOpt.getText();
            SimpleDateFormat mod = new SimpleDateFormat("yyyy/MM/dd");
            valor = mod.format(consultarSoporteVista.dateValor.getDate());
        }
        if (consultarSoporteVista.todoOpt.isSelected()) {
            param = "1";
            valor = "0";
        }
        String reg[] = new String[13];
        ArrayList<String> l = new ArrayList<String>();
        l = soporteModelo.getSoporte(param, valor);
        int tam = l.size();
        int aux = 0;
        for (int i = 0; i < (tam / 13); i++) {
            for (int j = 0; j < 1; j++) {
                reg[0] = l.get(aux) + "";
                aux++;
                reg[1] = l.get(aux) + "";
                aux++;
                reg[2] = l.get(aux) + "";
                aux++;
                reg[3] = l.get(aux) + "";
                aux++;
                reg[4] = l.get(aux) + "";
                aux++;
                reg[5] = l.get(aux) + "";
                aux++;
                reg[6] = l.get(aux) + "";
                aux++;
                reg[7] = l.get(aux) + "";
                aux++;
                reg[8] = l.get(aux) + "";
                aux++;
                reg[9] = l.get(aux) + "";
                aux++;
                reg[10] = l.get(aux) + "";
                aux++;
                reg[11] = l.get(aux) + "";
                aux++;
                reg[12] = l.get(aux) + "";
                aux++;
                consultarSoporteVista.getTableModel().addRow(reg);
                consultarSoporteVista.getTableModel().fireTableDataChanged();
            }
        }
    }
}
