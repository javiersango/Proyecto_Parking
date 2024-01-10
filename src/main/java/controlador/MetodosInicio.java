/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.HibernateUtil;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Javier
 */
public class MetodosInicio {
    
public static boolean comprobarInicioUsuario(String nombre, String contrasena) {
    HibernateUtil conexion = new HibernateUtil();
    conexion.conectar();
    Session sesion = conexion.getSessionFactory().openSession();

    try {
        // Comprobar si existe un usuario con el nombre proporcionado
        Query query = sesion.createQuery("FROM Usuarios WHERE nombre = :nombre");
        query.setParameter("nombre", nombre);
        Usuarios usuario = (Usuarios) query.uniqueResult();
         System.out.println("nombre : " + nombre);
        if (usuario != null) {
            // Si el usuario existe, comprobar si la contraseña coincide (asumiendo que la contraseña se almacena como texto plano en la base de datos)
            if (contrasena.equals(usuario.getContrasena())) {
                 System.out.println(" contraseña enviada : " + contrasena);
                  System.out.println(" contraseña guardada: " + contrasena);
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true; // La contraseña coincide
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                return false; // La contraseña no coincide
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // El usuario no existe
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        return false; // Ha ocurrido un error
    } finally {
        // Cerrar la sesión de Hibernate
        conexion.desconectar();
    }
}


    
    
    
}
