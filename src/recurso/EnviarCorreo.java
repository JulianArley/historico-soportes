package recurso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnviarCorreo {

    public void enviarCorreo(String text, String[] co, String sub) throws ClassNotFoundException {

        String db = "soportesdb";
        String url = "jdbc:mysql://localhost/" + db;

        String cor = "";
        String con = "";
        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM correoEnvio");
            while (rs.next()) {
                cor = rs.getString("correo");
                con = rs.getString("contraseña");
            }

            //JOptionPane.showMessageDialog(null, cor + "-----" + con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

//        props.setProperty("mail.transport.protocol", "smtp");
//        props.setProperty("mail.host", "smtp.gmail.com");
//        props.put("mail.smtp.starttls.enable", "true");
//        //props.put("mail.smtp.auth", "true");
//        //props.put("mail.smtp.port", 587); 
//        //props.put("mail.smtp.starttls.enable", "true");
//        //props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.socketFactory.fallback", "false");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.put("mail.smtp.socketFactory.fallback", "false");
        String c = cor;
        String cn = con;
        Session ses = Session.getInstance(props,new Authenticator(){
            @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(c, cn);
            }
        });
        ses.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(ses);

            message.setFrom(new InternetAddress(c));

            if (sub == "en seguimiento") {
                //message.addRecipient(Message.RecipientType.TO, new InternetAddress("juan.diaz@polloandino.com"));
                //message.addRecipient(Message.RecipientType.TO, new InternetAddress("tatiana.bonilla@polloandino.com"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(c));

            } else {
                for (int i = 0; i < co.length; i++) {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(co[i]));
                }
            }

            sub = "Soporte " + sub;

            message.setSubject(sub);

            message.setText(text);

            Transport.send(message);

            JOptionPane.showMessageDialog(null, "Correo enviado correctamente");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
