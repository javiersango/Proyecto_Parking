/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import vista.RecuperarContrasena;

/**
 *
 * @author Alumno
 */
public class EmailUtil {
    
    /** Metodo se utiliza para enviar un correo electronico utilizando seision JavaMail toma la direcciondel 
     * correo electronico que lo envia , el asunto del correo y el cuerpo del correo  */
    public static void sendEmail(Session session, String toEmail, String subject, String body) {
   
        try {
      
        MimeMessage msg = new MimeMessage(session);
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        msg.setFrom(new InternetAddress("reservarparking@gmail.com", "NoReply-JD"));
        msg.setReplyTo(InternetAddress.parse("reservarparking@gmail.com", false));
        msg.setSubject(body, "UTF-8");
        msg.setText(body, "UTF-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        System.out.println("Mensaje enviado: "
                + "Recuperacion de contraseña Parking, Se recomienda volver a cambiar la contraseña. ");
        Transport.send(msg);
        System.out.println("Email enviado correctamente!!");
     
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    /** Metodo envia correo electronico con la nueva contraseña al correo electronico introducido */
    public static void enviarCorreoRecuperacionContrasena(String correoElectronico, String nuevaContraseña) {
        final String fromEmail = "reservarparking@gmail.com";
        final String password = "unlwlfrrsfmcnumu";
        final String toEmail = correoElectronico;

        System.out.println("Iniciando correo SSL");
        Properties props = new Properties();
        /*
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.user", fromEmail);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols","TLSv1.2");
        

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Sesión creada");

        // Utiliza EmailUtil para enviar el correo electrónico
        sendEmail(session, toEmail, "Parking", "Mensaje de recuperación de "
                + "contraseña: ¡¡¡Recuerde!!! volver a cambiar la contraseña en la cuenta "
                + "de usuario. NUEVA CONTRASEÑA " + nuevaContraseña);

     
    }
}
