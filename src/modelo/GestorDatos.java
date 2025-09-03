/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.*;
import java.sql.*;
import javax.swing.*;

public class GestorDatos {
    private static Connection conn;
    public GestorDatos() {
        recurso.Conexion conexion = new recurso.Conexion();
        conn=conexion.getConexion();
        

    }
    public void getTecnologos(JComboBox j){
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM tecnicos");
            while (rs.next()) {
                j.addItem(rs.getString("TecIdentificacion")+"-"+rs.getString("TecNombres")+" "+rs.getString("TecApellidos"));
            }
            j.setSelectedItem(null);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
    
    public void getDependencias(JComboBox j){
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM dependencias");
            while (rs.next()) {
                j.addItem(rs.getString("IdDependencia")+"-"+rs.getString("Dependencia"));
            }
            j.setSelectedItem(null);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public ResultSet getSoporte(int id){
        Soporte s=new Soporte();
        ResultSet rs=null;
        try{
            Statement st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM soportes WHERE idSoporte='"+id+"'");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
    
    public void getCorreos(JComboBox j){
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM correo");
            while (rs.next()) {
                j.addItem(rs.getString("correos"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<String> estadoSoportes(){
        ResultSet rs=null;
        ArrayList<String> l = new ArrayList<String>();
        
        
        try{
            Statement st=conn.createStatement();
            rs = st.executeQuery("select i.idSoporte,i.descripcionSoporte,i.nombreUsuario,d.Dependencia,i.tipo,i.soporteFecha,i.horaSoporte,t.TecIdentificacion,t.TecNombres,t.TecApellidos,i.dependenciaSoporteFK, i.tecnologoSoporteFK, i.estado from soportes i inner join dependencias d on d.IdDependencia=i.dependenciaSoporteFK inner join tecnicos t on i.tecnologoSoporteFK=t.TecIdentificacion where i.estado='en seguimiento'");
            while (rs.next()) {
                l.add(rs.getString("idSoporte"));
                l.add(rs.getString("descripcionSoporte"));
                l.add(rs.getString("nombreUsuario"));
                l.add(rs.getString("Dependencia"));
                l.add(rs.getString("tipo"));
                l.add(rs.getString("soporteFecha"));
                l.add(rs.getString("horaSoporte"));
                l.add(rs.getString("TecIdentificacion"));
                l.add(rs.getString("TecNombres"));
                l.add(rs.getString("TecApellidos"));
                l.add(rs.getString("dependenciaSoporteFK"));
                l.add(rs.getString("tecnologoSoporteFK"));
                l.add(rs.getString("estado"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return l;
    }
    
    public void CambiarCorreo(String cor,String contraseña){
        try{
            Statement st=conn.createStatement();
            
            st.executeUpdate("UPDATE correoEnvio SET correo='"+cor+"',contraseña='"+contraseña+"' where id=1");
            JOptionPane.showMessageDialog(null, "Correo actualizado exitosamente");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    public ArrayList<String> getEnvio(){

        ArrayList<String> l = new ArrayList<String>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery("select * from correoEnvio");

            while (rs.next()) {
                l.add(rs.getString("correo"));
                l.add(rs.getString("contraseña"));
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return l;
    }
}