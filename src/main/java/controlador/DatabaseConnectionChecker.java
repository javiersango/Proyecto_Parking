/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Javier
 */

    import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnectionChecker {

    public  void checkDatabaseConnection() {
        // Crea una instancia de la configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("configuracion/hibernate.cfg.xml"); // Reemplaza con la ubicación de tu archivo de configuración

        // Crea una instancia de la fábrica de sesiones de Hibernate
        try {
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            
            // Si la fábrica de sesiones se crea sin errores, la conexión es exitosa
            System.out.println("La conexión a la base de datos ad_parking ha sido exitosa.");

            // Cierra la fábrica de sesiones
            sessionFactory.close();
        } catch (Exception e) {
            // Si se produce una excepción, la conexión ha fallado
            System.err.println("Error al conectar con la base de datos ad_parking: " + e.getMessage());
        }
    }


    
}
