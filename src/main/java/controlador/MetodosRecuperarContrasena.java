/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.security.SecureRandom;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import org.hibernate.Transaction;

/**
 *
 * @author Javier
 */


public class MetodosRecuperarContrasena {
    
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?";
    private static final int LONGITUD_CONTRASENA = 12; // Cambia la longitud de la contraseña según tus necesidades

    /** Metodo hace una comprobacion antes de enviar el email para recuperar la contraseña   */
     public static boolean existeEmail(String email) {
            HibernateUtil conexion = new HibernateUtil();
            
            conexion.conectar();
            Session sesion = conexion.getSessionFactory().openSession();

            try {
                // Comprobar si el email ya existe en la base de datos
                Query query = sesion.createQuery("SELECT COUNT(*) FROM Usuarios WHERE email = :email");
                query.setParameter("email", email);
                long count = (long) query.uniqueResult();

                // Si el recuento es mayor que cero, el correo existe
                return count > 0;
            } catch (Exception e) {
                e.printStackTrace();
                return false; // Ha ocurrido un error al verificar el correo
            } finally {
                // Cerrar la sesión de Hibernate
                conexion.desconectar();
            }
        }

     /**Metodo genera una contraseña aleatoria temporal para recuperar contraseña  */
        public static String generarContrasenaAleatoria() {
            SecureRandom random = new SecureRandom();
            StringBuilder contrasena = new StringBuilder();

            for (int i = 0; i < LONGITUD_CONTRASENA; i++) {
                int indiceAleatorio = random.nextInt(CARACTERES.length());
                char caracterAleatorio = CARACTERES.charAt(indiceAleatorio);
                contrasena.append(caracterAleatorio);
            }

            return contrasena.toString();
        }

        public static void main(String[] args) {
            String contrasenaAleatoria = generarContrasenaAleatoria();
            JOptionPane.showMessageDialog(null, "Nueva contraseña generada.");
        }

        /**Metodo en el que se le pasa el correoelectronico y el hash para guardarlo en la base de datos usuarios */
    public static void guardarHashContraseña(String correoElectronico, String hash) {
       
        HibernateUtil conexion = new HibernateUtil();
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = sesion.beginTransaction();
            
            // Buscar al usuario por su correo 
            Usuarios usuario = (Usuarios) sesion.createQuery("FROM Usuarios WHERE email = :email")
                                                .setParameter("email", correoElectronico)
                                                .uniqueResult();

            if (usuario != null) {
                // Asignar el hash de la contraseña al usuario
                usuario.setContrasena(hash);

                // Actualizar el usuario en la base de datos
                sesion.update(usuario);

                tx.commit();
                 JOptionPane.showMessageDialog(null, "Nueva contraseña usuario guardada ", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }
}



