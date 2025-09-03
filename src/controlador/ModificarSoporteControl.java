package controlador;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ModificarSoporteControl implements ActionListener {

    modelo.GestorSoporte soporteModelo;
    vista.ModiSoporteInternalFrame modificarSoporteVista;

    public ModificarSoporteControl(vista.ModiSoporteInternalFrame modificarSoporteVista) {
        this.modificarSoporteVista = modificarSoporteVista;
        soporteModelo = new modelo.GestorSoporte();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String param = "";
        String valor = "";

        if (modificarSoporteVista.dependenciaOpt.isSelected()) {
            param = "dependenciaSoporteFK";
            valor = modificarSoporteVista.dependencia.getSelectedItem().toString();
        }
        if (modificarSoporteVista.tecnologoOpt.isSelected()) {
            param = "tecnologoSoporteFK";
            valor = modificarSoporteVista.tecnologo.getSelectedItem().toString();
        }
        if (modificarSoporteVista.tipoOpt.isSelected()) {
            param = "tipo";
            valor = modificarSoporteVista.tipo.getSelectedItem().toString();
        }
        if (modificarSoporteVista.fechaOpt.isSelected()) {
            param = "soporteFecha";
            SimpleDateFormat mod = new SimpleDateFormat("yyyy/MM/dd");
            valor = mod.format(modificarSoporteVista.fecha.getDate());
        }
        if (modificarSoporteVista.usuarioOpt.isSelected()) {
            param = "nombreUsuario";
            valor = modificarSoporteVista.usuario.getText();
        }
        if (modificarSoporteVista.estadoOpt.isSelected()) {
            param = "estado";
            valor = modificarSoporteVista.estado.getSelectedItem().toString();
        }

        int v = Integer.parseInt(modificarSoporteVista.idSoporte.getText());

        soporteModelo.modificarSoporte(param, valor, v);

    }
}
