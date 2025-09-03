package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ModificarCorreo implements ActionListener{
    vista.ModiCorreoInternalFrame modificar;
    modelo.GestorDatos datos;
    public ModificarCorreo(vista.ModiCorreoInternalFrame modi){
    
    this.modificar=modi;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(modificar.modificar)) {
            datos=new modelo.GestorDatos();
            String cor=modificar.correo.getText();
            String con=modificar.contraseña.getText();
            datos.CambiarCorreo(cor,con);
        }
    }
}
