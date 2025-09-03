package controlador;
import java.awt.event.*;
import java.text.*;

public class TecnologoControl implements ActionListener{
    vista.RegTecnologoInternalFrame tecnologoVista;
    modelo.Tecnologo tecnologoModelo;
    modelo.GestorTecnologo gestorTecnologoModelo;
    
    public TecnologoControl (vista.RegTecnologoInternalFrame tecnologoVista){
        this.tecnologoVista=tecnologoVista;
        gestorTecnologoModelo=new modelo.GestorTecnologo();
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource().equals(tecnologoVista.RegistrarBtn)) {
            String identificacion=tecnologoVista.IdentificacionTxt.getText();
            String nombres=tecnologoVista.NombresTxt.getText();
            String apellidos=tecnologoVista.ApellidosTxt.getText();
            SimpleDateFormat form=new SimpleDateFormat("yyyy/MM/dd");
            tecnologoModelo=new modelo.Tecnologo(identificacion,nombres,apellidos);
            gestorTecnologoModelo.registrarTecnologo(tecnologoModelo);
            
        }
        if (e.getSource().equals(tecnologoVista.NuevoBtn)) {
            tecnologoVista.IdentificacionTxt.setText(null);
            tecnologoVista.NombresTxt.setText(null);
            tecnologoVista.ApellidosTxt.setText(null);
            tecnologoVista.buttonGroup1.clearSelection();
            tecnologoVista.IdentificacionTxt.requestFocus();
            
        }
    }

}
