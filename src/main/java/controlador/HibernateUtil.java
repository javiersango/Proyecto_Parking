package controlador;

import java.util.List;
import modelo.Usuarios;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private SessionFactory sessionFactory;

    public HibernateUtil() {
        // Crea una instancia de la configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

        // Crea una instancia de la fábrica de sesiones de Hibernate
        sessionFactory = configuration.buildSessionFactory();
    }

    public void conectar() {
        try {
            // Si la fábrica de sesiones se crea sin errores, la conexión es exitosa
            System.out.println("La conexión a la base de datos ad_parking ha sido exitosa.");
        } catch (Exception e) {
            // Si se produce una excepción, la conexión ha fallado
            System.err.println("Error al conectar con la base de datos ad_parking: " + e.getMessage());
        }
    }

    public void desconectar() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("La conexión a la base de datos ad_parking se ha cerrado.");
        }
    }

    public void mostrarDatosUsuarios() {
        // Abrir una sesión de Hibernate
        Session sesion = sessionFactory.openSession();

        try {
            // Crear una consulta para seleccionar todos los usuarios
            Query<Usuarios> query = sesion.createQuery("FROM Usuarios", Usuarios.class);

            // Obtener una lista de todos los usuarios
            List<Usuarios> usuarios = query.list();

            // Iterar a través de la lista de usuarios y mostrar sus datos
            for (Usuarios usuario : usuarios) {
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Apellidos: " + usuario.getApellidos());
                System.out.println("Contraseña: " + usuario.getContrasena());
                System.out.println(); // Agregar una línea en blanco para separar los datos de los usuarios
            }

        } catch (ObjectNotFoundException e) {
            System.out.println("El usuario no existe");
        } finally {
            // Cerrar la sesión de Hibernate
            sesion.close();
        }
    }
}

