package recurso;
import java.sql.*;
import javax.swing.*;
public class Conexion {
    private String driver,url,db,usr,pass;
    private Connection conexion;

    public Conexion() {
        driver="com.mysql.cj.jdbc.Driver";
        db="soportesdb";
        usr="";
        pass="";
        url="jdbc:mysql://localhost/"+db;
        
        try{
            Class.forName(driver);
            conexion=DriverManager.getConnection(url,"root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    public Connection getConexion(){
        return conexion;
    }
    public Connection closeConexion()throws SQLException{
        conexion.close();
        conexion=null;
        return conexion;
    }
}
