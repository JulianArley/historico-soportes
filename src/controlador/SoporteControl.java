package controlador;

import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.text.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.RegSoporteInternalFrame;

public class SoporteControl implements ActionListener {

    vista.RegSoporteInternalFrame soporteVista;
    modelo.Soporte soporteModelo;
    modelo.GestorSoporte gestorSoporteModelo;
    recurso.EnviarCorreo correo;

    public SoporteControl(vista.RegSoporteInternalFrame soporteVista) {
        this.soporteVista = soporteVista;
        gestorSoporteModelo = new modelo.GestorSoporte();
        correo=new recurso.EnviarCorreo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(soporteVista.regSoporte)) {
            int id = 0;
            SimpleDateFormat mod = new SimpleDateFormat("yyyy/MM/dd");
            String desc = soporteVista.descSoporte.getText();
            String nom = soporteVista.nomUsuario.getText();
            String fec = mod.format(soporteVista.fecha.getDate());
            String h = soporteVista.shora.getValue().toString();
            String m = soporteVista.smin.getValue().toString();
            String hora = h + ":" + m;
            String modo = null;
            String sub="completado";
            if (soporteVista.presencial.isSelected()) {
                modo = "Presencial";
            } else {
                modo = "Virtual";
            }
            String dependencia = soporteVista.dependencia.getSelectedItem().toString();
            String tecnologo = soporteVista.tecnologo.getSelectedItem().toString();

           
           
           String info="Descripcion del soporte: "+desc+"\n\nNombre de usuario soportado: "+nom+"\n\nFecha del soporte: "+fec+"\n\nHora del soporte: "+hora+"\n\nModo del soporte: "+modo+"\n\nDependencia a la cual se realizo el soporte: "+dependencia+"\n\nTecnico que realizo el soporte: "+tecnologo;

           String a=soporteVista.correosText.getText();
           
           String []co=a.split(";");
           
           if (soporteVista.estadoOpt.isSelected()) {
               sub="en seguimiento";
           }

           soporteModelo = new modelo.Soporte(id, desc, nom, fec, hora, modo, dependencia, tecnologo,sub);

           
           gestorSoporteModelo.registrarSoporte(soporteModelo,info,co,sub);
       }
       if (e.getSource().equals(soporteVista.clearBtn)) {
           soporteVista.nomUsuario.setText(null);
           soporteVista.descSoporte.setText(null);
           soporteVista.fecha.setDate(null);
           soporteVista.shora.setValue(0);
           soporteVista.smin.setValue(0);
           soporteVista.buttonGroup1.clearSelection();
           soporteVista.dependencia.setSelectedItem(null);
           soporteVista.tecnologo.setSelectedItem(null);
           soporteVista.correosTable.setText(null);
           soporteVista.correosText.setText(null);
       }
       if (e.getSource().equals(soporteVista.agregarCor)) {
           
            soporteVista.correosText.setText(soporteVista.correosTable.getText());
            soporteVista.jInternalFrame1.dispose();
        }
        if (e.getSource().equals(soporteVista.cancelarCor)) {
            soporteVista.correosTable.setText("");
            soporteVista.correosText.setText("");
            soporteVista.jInternalFrame1.dispose();
        }
    }
}