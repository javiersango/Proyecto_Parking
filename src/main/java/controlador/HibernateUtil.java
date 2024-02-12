package controlador;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private final SessionFactory sessionFactory;
// Contructor conexion hibernate

    public HibernateUtil() {
        // Crea una instancia de la configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

        // Crea una instancia de la fábrica de sesiones de Hibernate
        sessionFactory = configuration.buildSessionFactory();
    }

    /**
     * Metodo inicia la sesion con la conesion a la base de datos
     */
    public void conectar() {
        try {
            // Si la fábrica de sesiones se crea sin errores, la conexión es exitosa
            System.out.println("La conexión a la base de datos ad_parking ha sido exitosa.");
        } catch (Exception e) {
            // Si se produce una excepción, la conexión ha fallado
            System.err.println("Error al conectar con la base de datos ad_parking: " + e.getMessage());
        }
    }

    /**
     * Metodo cierra la sesion de oonexion con la base de datos
     */
    public void desconectar() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("La conexión a la base de datos ad_parking se ha cerrado.");
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
