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
import modelo.Vehiculos;
import modelo.Historial;
import modelo.Usuarios;
import org.hibernate.Transaction;

/**
 *
 * @author Javier Sánchez González
 */
public class MetodosHistorial {

    private Usuarios usuarios;
    private Historial historial;

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

    /**
     *
     * @param idUsuario
     * @return  devuelve el historial de la matricula del usuario
     */
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

    /**
     *
     * @param idUsuario
     * @return  devuelve la matricula del vehiculo
     */
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

    /**
     *
     * @param idUsuario
     * @param matricula
     * @param dia
     * @param tiempoReservado
     * @param precio
     * @return   devuelve si ha guardado en historial la nueva reserva
     */
    public boolean guardarEnHistorial(int idUsuario, String matricula, Date dia, int tiempoReservado, double precio) {
        HibernateUtil conexion = new HibernateUtil(); // Instancia la conexión con la base de datos
        conexion.conectar(); // Conectar a la base de datos
        Session sesion = conexion.getSessionFactory().openSession(); // Abre la sesión de Hibernate
        Transaction transaction = null;
        try {
            transaction = sesion.beginTransaction();
            Usuarios usuario = sesion.get(Usuarios.class, idUsuario);
            if (usuario == null) {
                return false;
            }

            // Convertir la fecha de java.util.Date a java.sql.Date si es necesario
            java.sql.Date sqlDate = new java.sql.Date(dia.getTime());

            Historial historial = new Historial();
            historial.setUsuarios(usuario);
            historial.setMatricula(matricula);
            historial.setDia(sqlDate);  // Asignar la fecha correctamente
            historial.setTiempoReservado(tiempoReservado);
            historial.setPrecio(precio);

            System.out.println("Guardando historial: " + historial);  // Verificar antes de guardar

            sesion.save(historial);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
}
