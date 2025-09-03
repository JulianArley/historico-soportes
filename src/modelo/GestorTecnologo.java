package modelo;

import java.util.*;
import java.sql.*;
import javax.swing.*;

public class GestorTecnologo {

    private static Connection conn;

    public GestorTecnologo() {
        recurso.Conexion conexion = new recurso.Conexion();
        conn = conexion.getConexion();
    }

    public void registrarTecnologo(Tecnologo tecnologo) {
        try {
            PreparedStatement s = conn.prepareStatement("insert into tecnicos values (?,?,?)");
            //s.executeUpdate("insert into pacientes values('"+paciente.getIdentificacion()+"','"+paciente.getNombres()+"','"+paciente.getApellidos()+"','"+paciente.getFechaNacimiento()+"','"+paciente.getSexo()+"')");
            s.setString(1, tecnologo.getIdentificacion());
            s.setString(2, tecnologo.getNombres());
            s.setString(3, tecnologo.getApellidos());
            s.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Tecnico Registrado!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public LinkedList<Tecnologo> getTecnologo(int param, String val) {
        LinkedList<Tecnologo> res = new LinkedList<Tecnologo>();
        String sql = "";
        
        switch (param) {
            case 1:
                sql = "select * from tecnicos where TecIdentificacion='" + val + "'";
                
                break;
            case 2:
                sql = "select * from tecnicos where TecNombres='" + val + "'";
                break;
            case 3:
                sql = "select * from tecnicos where TecApellidos='" + val + "'";
                break;
            case 4:
                sql="SELECT * FROM tecnicos";
                break;
            
        }
        try {
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                res.add(new Tecnologo(rs.getString("TecIdentificacion"), rs.getString("TecNombres"),
                        rs.getString("TecApellidos")));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return res;
        }

    }

    public LinkedList eliminarTecnologo(int param, String val) {
        LinkedList<Tecnologo> res = new LinkedList<Tecnologo>();
        String sql = "";
        String sql2 = "select * from tecnicos";
        switch (param) {
            case 1:
                sql = "delete from tecnicos where TecIdentificacion='" + val + "'";
                break;
            case 2:
                sql = "delete from tecnicos where TecNombres='" + val + "'";
                break;
            case 3:
                sql = "delete from tecnicos where TecApellidos='" + val + "'";
                break;
            
                
        }
        
        try {
            Statement st = conn.createStatement();
            
            st.executeUpdate(sql);
            ResultSet rs = st.executeQuery(sql2);
            while (rs.next()) {
                res.add(new Tecnologo(rs.getString("TecIdentificacion"), rs.getString("TecNombres"),
                        rs.getString("TecApellidos")));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        finally {
            return res;
        }
    }
    public LinkedList modificarTecnologo(int param,String valor, String val2){
        LinkedList<Tecnologo> res=new LinkedList<Tecnologo> ();
        String sql="";
        switch (param) {
            case 1:
                sql = "update tecnicos set TecIdentificacion='" + valor + "' where TecIdentificacion='"+val2+"'";
                break;
            case 2:
                sql = "update tecnicos set TecNombres='" + valor + "' where TecIdentificacion='"+val2+"'";
                break;
            case 3:
                sql = "update tecnicos set TecApellidos='" + valor + "' where TecIdentificacion='"+val2+"'";
                break;
            
        }
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            
            st.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        finally{
            return res;
        }
    }
}
