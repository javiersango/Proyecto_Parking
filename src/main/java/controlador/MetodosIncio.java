/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Javier
 */
public class MetodosIncio {
    
    
   public static boolean comprobarInicioUsuario(String nombre, String hash) {
        HibernateUtil conexion = new HibernateUtil();
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();

        try {
            // Comprobar si existe un usuario con el nombre proporcionado
            Query query = sesion.createQuery("SELECT COUNT(*) FROM Usuarios WHERE nombre = :nombre");
            query.setParameter("nombre", nombre);
            long count = (long) query.uniqueResult();

            if (count > 0) {
                // Si el nombre de usuario existe, comprobar si la contraseña coincide
                query = sesion.createQuery("SELECT contrasena FROM Usuarios WHERE nombre = :nombre");
                query.setParameter("nombre", nombre);
                String contrasenaHash = (String) query.uniqueResult();

                // Comprobar si la contraseña proporcionada coincide con la contraseña almacenada (usando BCrypt)
                if (hash.equals(contrasenaHash)) {
                    // La contraseña coincide, devolver true
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña no coincide", "Error", JOptionPane.ERROR);// La contraseña no coincide, devolver false
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", JOptionPane.ERROR);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR);
            return false; 
        } finally {
            // Cerrar la sesión de Hibernate
            conexion.desconectar();
        }
    }
    
    
    
}
