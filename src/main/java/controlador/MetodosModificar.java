/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Javier
 */
public class MetodosModificar {

    // Método que obtiene el usuario por su ID
    public List<Usuarios> MetodosModificar(int idUsuario) {
        // Configurar la conexión a la base de datos utilizando Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

        // Crear la fábrica de sesiones
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Iniciar la sesión de Hibernate
        Session session = sessionFactory.openSession();
        List<Usuarios> usuariosList = null;

        try {
            // Iniciar la transacción
            session.beginTransaction();

            // Consulta HQL para obtener el usuario por su ID
            usuariosList = session.createQuery("FROM Usuarios u WHERE u.id = :id", Usuarios.class)
                    .setParameter("id", idUsuario)
                    .getResultList();

            // Commit de la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            // Cerrar la sesión
            session.close();
        }

        return usuariosList;
    }

}
