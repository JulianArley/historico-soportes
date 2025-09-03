package modelo;

import static java.lang.Integer.parseInt;
import java.util.*;
import java.sql.*;
import javax.swing.*;

public class GestorSoporte {

    private static Connection conn;
    recurso.EnviarCorreo correo;
    public GestorSoporte() {
        recurso.Conexion conexion = new recurso.Conexion();
        conn = conexion.getConexion();
        correo=new recurso.EnviarCorreo();
    }

    public void registrarSoporte(Soporte soporte,String info,String[] co,String sub) {
        String alerta = "Esta seguro de crear el soporte con los datos:\nDescripcion del soporte: " + soporte.getDescSoporte() + "\nNombre de usuario: " + soporte.getNomUsuario() + ""
                + "\nFecha del soporte: " + soporte.getFechaSop() + "\nHora del soporte: " + soporte.getHora() + "\nTipo de soporte: " + soporte.getTipo() + "\nDependenciaa del soporte: " + soporte.getDependencia() + ""
                + "\nTecnologo del soporte: " + soporte.getTecnologo();

        int i = JOptionPane.showConfirmDialog(null, alerta);
        if (i == 0) {
            try {
                PreparedStatement s = conn.prepareStatement("insert into soportes values(null,?,?,?,?,?,?,?,?)");
                String a = soporte.getDependencia();
                String[] a1 = a.split("-");
                String b = soporte.getTecnologo();
                String[] b2;
                b2 = b.split("-");
                int tec = parseInt(b2[0]);

                int dep = parseInt(a1[0]);
                s.setString(1, soporte.getDescSoporte());
                s.setString(2, soporte.getNomUsuario());
                s.setString(3, soporte.getFechaSop());
                s.setString(4, soporte.getHora());
                s.setString(5, soporte.getTipo());
                s.setInt(6, dep);
                s.setInt(7, tec);
                s.setString(8,soporte.getEstado());
                s.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "¡Soporte Registrado!");
                correo.enviarCorreo(info, co, sub);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                
            }catch(Exception x){
                x.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usted ha cancelado el registro del soporte");
        }

    }

    public LinkedList eliminarSoporte(int id) {
        LinkedList<Soporte> res = new LinkedList<Soporte>();
        GestorDatos gd = new GestorDatos();
        ResultSet r;
        r = gd.getSoporte(id);
        Soporte s = new Soporte();
        int i = 50;
        i = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el soporte?");

        if (i == 0) {
            try {
                String sql = "DELETE FROM soportes WHERE idSoporte ='" + id + "'";
                Statement st = conn.createStatement();

                st.executeUpdate(sql);
                ResultSet rs = st.executeQuery("SELECT * FROM soportes");

                while (rs.next()) {
                    res.add(new Soporte(rs.getInt("idSoporte"), rs.getString("descripcionSoporte"), rs.getString("nombreUsuario"), rs.getString("soporteFecha")));
                }

                st.close();
                JOptionPane.showMessageDialog(null, "Soporte eliminado correctamente!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Accion cancelada!");
        }

        return res;
    }

    public LinkedList<Soporte> getSoportes() {
        LinkedList<Soporte> res = new LinkedList<Soporte>();
        String sql = "SELECT * FROM soportes";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM soportes");

            while (rs.next()) {
                res.add(new Soporte(rs.getInt("idSoporte"), rs.getString("descripcionSoporte"), rs.getString("nombreUsuario"), rs.getString("soporteFecha"), rs.getString("horaSoporte"), rs.getString("tipo"), rs.getString("dependenciaSoporteFK"), rs.getString("tecnologoSoporteFK"),rs.getString("estado")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return res;
    }

    public ArrayList<String> getSoporte(String param, String valor) {
        LinkedList<Soporte> res = new LinkedList<Soporte>();

        //String sql="select i.idSoporte,i.descripcionSoporte,i.nombreUsuario,d.Dependencia,i.tipo,i.soporteFecha,i.horaSoporte,t.PacIdentificacion,t.PacNombres,t.PacApellidos from dbo.soportes i inner join dbo.dependencias d on i.dependenciaSoporteFK=d.IdDependencia inner join dbo.pacientes t on t.PacIdentificacion=i.tecnologoSoporteFK where "+param+" = '"+valor+"'";
        //String sql="select i.idSoporte,i.descripcionSoporte,i.nombreUsuario,d.Dependencia,i.tipo,i.soporteFecha,i.horaSoporte,t.PacIdentificacion,t.PacNombres,t.PacApellidos,i.dependenciaSoporteFK, i.tecnologoSoporteFK from dbo.soportes i inner join dbo.dependencias d on d.IdDependencia=i.dependenciaSoporteFK inner join dbo.pacientes t on i.tecnologoSoporteFK=t.PacIdentificacion where i.tecnologoSoporteFK='80'";
        ArrayList<String> l = new ArrayList<String>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = null;
            if (param == "1") {
                rs = st.executeQuery("select i.idSoporte,i.descripcionSoporte,i.nombreUsuario,d.Dependencia,i.tipo,i.soporteFecha,i.horaSoporte,t.TecIdentificacion,t.TecNombres,t.TecApellidos,i.dependenciaSoporteFK, i.tecnologoSoporteFK, i.estado from soportes i inner join dependencias d on d.IdDependencia=i.dependenciaSoporteFK inner join tecnicos t on i.tecnologoSoporteFK=t.TecIdentificacion ORDER BY i.idSoporte ASC");
            } else {
                rs = st.executeQuery("select i.idSoporte,i.descripcionSoporte,i.nombreUsuario,d.Dependencia,i.tipo,i.soporteFecha,i.horaSoporte,t.TecIdentificacion,t.TecNombres,t.TecApellidos,i.dependenciaSoporteFK, i.tecnologoSoporteFK, i.estado from soportes i inner join dependencias d on d.IdDependencia=i.dependenciaSoporteFK inner join tecnicos t on i.tecnologoSoporteFK=t.TecIdentificacion where " + param + "='" + valor + "'  ORDER BY i.idSoporte ASC");
            }

            int aux = 0;
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

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return l;
    }
    
    public void modificarSoporte(String param, String valor, int id){
        
        
        if (param=="dependenciaSoporteFK") {
            String [] a=valor.split("-");
            valor=a[0];
            
        }
        if (param=="tecnologoSoporteFK") {
            String [] a=valor.split("-");
            valor=a[0];
        }
        
        String sql="UPDATE soportes set "+param+" = '"+valor+"' where idSoporte= "+id;
        try{
            Statement st=conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Soporte modificado correctamente");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    

}
