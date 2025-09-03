package modelo;

import java.util.*;
import java.sql.*;
import javax.swing.*;

public class GestorDependencia {
    private static Connection conn;
    public GestorDependencia(){
        recurso.Conexion conexion =new recurso.Conexion();
        conn=conexion.getConexion();
    }
    
    public void registrarDependencia(Dependencia dependencia){
        try{
            PreparedStatement s=conn.prepareStatement("INSERT INTO dependencias values (?,null)");
            s.setString(1, dependencia.getNomDependencia());
            s.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dependencia registrada!");
        }catch (SQLException e ){
            JOptionPane.showMessageDialog(null, "error: "+e.getMessage());
        }
    }
    public void eliminarDependencia(Dependencia dependencia){
        try{
            String sql="delete from dependencias where IdDependencia='"+dependencia.getIdDependencia()+"'";
            Statement st=conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dependencia eliminada!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public void modificarDependencia(Dependencia dependencia){
        try{
        String sql="update dependencias set Dependencia='"+dependencia.getNomDependencia()+"' where IdDependencia="+dependencia.getIdDependencia();
        Statement st=conn.createStatement();
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Dependencia modificada!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public LinkedList<Dependencia> consultarDependencia(String sql){
        LinkedList<Dependencia> list=new LinkedList<Dependencia>();
        try{
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            while (rs.next()) {
                int val=rs.getInt("IdDependencia");
                String valo=rs.getString("Dependencia");
                list.add(new Dependencia(valo,val ));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }finally{
            return list;
        }
        
    }
}