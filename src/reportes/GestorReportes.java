package reportes;

import java.io.File;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class GestorReportes {
    private String driver,url,db,usr,pass;

    private static Connection conexion;
    public GestorReportes(){
        driver="com.mysql.cj.jdbc.Driver";
        db="soportesdb";
        usr="";
        pass="";
        url="jdbc:mysql://localhost/"+db+"";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,"root","");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de conexion " + e.getMessage());
        }
    }
    
    public void ejecutarReporte(String archivo){
        try{
            String Reporte=System.getProperty("user.dir")+"/reportes/"+archivo;
            //JasperReport masterReport=(JasperReport) JRLoader.loadObject(Reporte);
            JOptionPane.showMessageDialog(null, Reporte);
            //Reporte=(JasperReport)JRLoader.loadObjectFromFile(Reporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(Reporte, null,conexion);
            
            JasperViewer jView=new JasperViewer(jasperPrint,false);
            
            jView.setVisible(true);
            
            /*InputStream reporteInputStream = GestorReportes.class.getResourceAsStream("/reportes/" + archivo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporteInputStream, null, conexion);
            JasperViewer jView = new JasperViewer(jasperPrint, false);
            jView.setVisible(true);*/
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}