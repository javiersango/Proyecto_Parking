/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import vista.RecuperarContrasena;

/**
 *
 * @author Alumno
 */
public class EmailUtil {
    public static void sendEmail(Session session, String toEmail, String subject, String body) {
   
        try {
      
        MimeMessage msg = new MimeMessage(session);
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        msg.setFrom(new InternetAddress("javier.sangon.14@educa.jcyl.es", "NoReply-JD"));
        msg.setReplyTo(InternetAddress.parse("javier.sangon.14@educa.jcyl.es", false));
        msg.setSubject(body, "UTF-8");
        msg.setText(body, "UTF-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        System.out.println("Mensaje enviado: "
                + "Recuperacion de contraseña Parking, Se recomienda volver a campiar la contraseña. ");
        Transport.send(msg);
        System.out.println("Email enviado correctamente!!");
     
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
