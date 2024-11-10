package controlador;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.ServiceException;

/**
 *
 * @author Javier Sánchez González
 */
public class HibernateUtil {

    private final SessionFactory sessionFactory;

    /**
     * Contructor conexion hibernate
     */
    public HibernateUtil() {
        SessionFactory tempSessionFactory = null;
        try {
            // Crea una instancia de la configuración de Hibernate
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

            // Crea una instancia de la fábrica de sesiones de Hibernate
            tempSessionFactory = configuration.buildSessionFactory();

        } catch (ServiceException e) {
            System.err.println("Error al conectar con la base de datos ad_parking: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos ad_parking: Verifique la configuración y el estado del servidor.",
                    "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("Error al inicializar Hibernate: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado al inicializar Hibernate.",
                    "Error de Inicialización", JOptionPane.ERROR_MESSAGE);
        }
        sessionFactory = tempSessionFactory;
    }

    /**
     * Metodo inicia la sesion con la conesion a la base de datos
     */
    public void conectar() {
        try {
            // Si la fábrica de sesiones se crea sin errores, la conexión es exitosa
            System.out.println("La conexión a la base de datos ad_parking ha sido exitosa.");

        } catch (ServiceException e) {
            // Manejo específico para error de conexión
            System.err.println("Error al conectar con la base de datos ad_parking: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos ad_parking: Verifique la configuración y el estado del servidor.",
                    "Error de Conexión", JOptionPane.ERROR_MESSAGE);
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
