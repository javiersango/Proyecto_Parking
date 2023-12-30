/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Javier
 */

import modelo.Usuarios;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
    import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnectionChecker {

    public  void checkDatabaseConnection() {
        // Crea una instancia de la configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Reemplaza con la ubicación de tu archivo de configuración

        // Crea una instancia de la fábrica de sesiones de Hibernate
        try {
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            
            // Si la fábrica de sesiones se crea sin errores, la conexión es exitosa
            System.out.println("La conexión a la base de datos ad_parking ha sido exitosa.");
            
               // Crear una fábrica de sesiones de Hibernate
   // SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Abrir una sesión de Hibernate
    Session sesion = sessionFactory.openSession();

    try {
        // Cargar un usuario por su ID (en este caso, ID 5)
        Usuarios usuario = sesion.load(Usuarios.class, 1);

        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellidos: " + usuario.getApellidos());
        System.out.println("Contraseña: " + usuario.getContrasena());

    } catch (ObjectNotFoundException e) {
        System.out.println("El usuario no existe");
    } finally {
        // Cerrar la sesión de Hibernate
        sesion.close();
    }

            // Cierra la fábrica de sesiones
            sessionFactory.close();
            System.out.println("La conexión a la base de datos ad_parking se ha cerrado.");
        } catch (Exception e) {
            // Si se produce una excepción, la conexión ha fallado
            System.err.println("Error al conectar con la base de datos ad_parking: " + e.getMessage());
        }
    }


    
}
