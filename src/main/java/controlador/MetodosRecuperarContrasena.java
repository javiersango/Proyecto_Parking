/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import org.hibernate.cfg.Configuration;

import javax.swing.JTextField;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Javier
 */
public class MetodosRecuperarContrasena {
    
 

public static String existeEmail(String email) {
    // Configurar la conexión a la base de datos utilizando Hibernate
    Configuration configuracion = new Configuration();
    configuracion.configure("hibernate.cfg.xml"); // Ubicación de la configuración

    // Crear una sesión de Hibernate
    SessionFactory sessionFactory = configuracion.buildSessionFactory();
    
    // Abrir una sesión de Hibernate
    Session sesion = sessionFactory.openSession();
    
    try {
        // Comprobar si el email ya existe en la base de datos
        Query query = sesion.createQuery("FROM Usuarios WHERE email = :email");
        query.setParameter("email", email);
        Usuarios usuario = (Usuarios) query.uniqueResult();

        if (usuario != null) {
            // Si el correo existe en la base de datos, devolver la contraseña
            return usuario.getContrasena();
        } else {
            // Si el correo no existe en la base de datos, devolver null
            return null;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null; // Ha ocurrido un error al verificar el correo
    } finally {
        // Cerrar la sesión de Hibernate
        sesion.close();
    }
}

}
