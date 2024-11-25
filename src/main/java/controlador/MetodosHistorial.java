/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modelo.Historial;
import modelo.Vehiculos;
import modelo.Usuarios;
import modelo.Reservas;
import modelo.Usuarios;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Javier Sánchez González
 */
public class MetodosHistorial {

    /**
     * Metodo busca la matricula en la base de datos
     *
     * @return un listado con los datos fecha, duracion, precio del aparcamiento
     */
    public static List<Historial> mostrarHistorial() {
        HibernateUtil conexion = new HibernateUtil();  // Instanciación de la conexion con la base de datos
        conexion.conectar();

        try (Session sesion = conexion.getSessionFactory().openSession() // Generamos una conexionn o sesion
                ) {
            Query<Historial> query = sesion.createQuery("FROM Historial ", Historial.class);
            List<Historial> historiales = query.list();
            return historiales;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado la matricula o ha fallado", "Error", JOptionPane.ERROR);
            e.printStackTrace();
            return null;
        }
    }

    public static List<Historial> buscarMatriculaUsuario(int idUsuario) {

        System.out.println("Consulta de historial para el usuario con ID: " + idUsuario);

        HibernateUtil conexion = new HibernateUtil();  // Instancia de la conexión con la base de datos
        conexion.conectar();

        try (Session sesion = conexion.getSessionFactory().openSession()) { // Asegurarse de cerrar la sesión automáticamente
            // Crear la consulta HQL para obtener el historial filtrado por el ID del usuario
            Query query = sesion.createQuery("FROM Historial h WHERE h.usuarios.id = :idUsuario");
            query.setParameter("idUsuario", idUsuario);
            List<Historial> historiales = query.list();

            // Ejecutar la consulta y obtener la lista de historiales
            return historiales;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado el historial o ha fallado", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return new ArrayList<>(); // Retornar una lista vacía si ocurre un error
        } finally {
            conexion.desconectar();  // Cerrar la conexión
        }

    }

    public static String buscarMatricula(int idUsuario) {

        System.out.println("Consulta buscar matricula usuario con id usuario " + idUsuario);

        HibernateUtil conexion = new HibernateUtil(); // Instancia la conexión con la base de datos
        conexion.conectar(); // Conectar a la base de datos
        Session sesion = conexion.getSessionFactory().openSession(); // Abre la sesión de Hibernate

        String matricula = null;

        try {
            // Crear la consulta HQL para obtener el vehículo asociado al usuario
            Query query = sesion.createQuery("FROM Vehiculos v WHERE v.usuarios.id = :idUsuario");
            query.setParameter("idUsuario", idUsuario); // Establecer el parámetro del ID del usuario

            // Obtener el primer resultado de la consulta como objeto Vehiculos
            Vehiculos vehiculo = (Vehiculos) query.uniqueResult();

            // Si se encuentra un vehículo, obtener su matrícula
            if (vehiculo != null) {
                matricula = vehiculo.getMatricula(); // Extraer la matrícula
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sesion.close(); // Cerrar la sesión
            conexion.desconectar(); // Cerrar la conexión
        }

        return matricula; // Retornar la matrícula del vehículo
    }

 /*   public static boolean guardarEnHistorial(int idUsuario, String matricula, Date dia, int tiempoReservado, double precio) {

        // Configurar la conexión a la base de datos utilizando Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

        // Crear una SessionFactory a partir de la configuración
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Iniciar una sesión de Hibernate
        Session session = null;
        Transaction transaction = null;

        try {
            // Iniciar la sesión y la transacción
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Crear un nuevo objeto Historial
            Historial historial = new Historial();
            historial.setUsuarios(idUsuario);
            historial.setMatricula(matricula);
            historial.setDia(dia);
            historial.setTiempoReservado(tiempoReservado);
            historial.setPrecio(precio);

            // Guardar el historial en la base de datos
            session.save(historial);

            // Commit de la transacción
            transaction.commit();
            System.out.println("Historial guardado con éxito.");
            return true;

        } catch (Exception e) {
            // En caso de error, hacer rollback
            if (transaction != null) {
                transaction.rollback();
            }
            // Imprimir detalles del error
            e.printStackTrace();
            return false;

        } finally {
            // Cerrar la sesión de Hibernate
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close(); // Cerrar la sesión de la fábrica de sesiones
            }
        }
    }
*/
}
