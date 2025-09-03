package controlador;

import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ModificarTecnologoControl implements ActionListener {

    modelo.GestorTecnologo tecnologosModelo;
    vista.ModiTecnologoInternalFrame modificarTecnologoVista;

    public ModificarTecnologoControl(vista.ModiTecnologoInternalFrame modificarTecnologoVista) {
        this.modificarTecnologoVista = modificarTecnologoVista;
        tecnologosModelo = new modelo.GestorTecnologo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(modificarTecnologoVista.modificarBtn)) {
            
            String valor = modificarTecnologoVista.valorTxt.getText();
            String valor2 = modificarTecnologoVista.antiguoTxt.getText();
            int param = 0;

            if (modificarTecnologoVista.identificacionOpt.isSelected()) {
                param = 1;
            }
            if (modificarTecnologoVista.nombresOpt.isSelected()) {
                param = 2;
            }
            if (modificarTecnologoVista.apellidosOpt.isSelected()) {
                param = 3;
            }

            LinkedList<modelo.Tecnologo> pacientes = tecnologosModelo.modificarTecnologo(param, valor, valor2);
            String reg[] = new String[5];
            for (modelo.Tecnologo p : pacientes) {
                reg[0] = p.getIdentificacion();
                reg[1] = p.getNombres();
                reg[2] = p.getApellidos();
            }
        }
    }
}
