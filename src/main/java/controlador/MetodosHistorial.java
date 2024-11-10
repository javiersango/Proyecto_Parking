/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modelo.Historial;
import modelo.Usuarios;
import modelo.Vehiculos;

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

        System.out.println(" Consulta  listado historial    " + idUsuario);
        HibernateUtil conexion = new HibernateUtil();  // Instanciación de la conexión con la base de datos
        conexion.conectar();

        try (Session sesion = conexion.getSessionFactory().openSession() // Asegurarse de cerrar la sesión
                // Generamos una conexión o sesión
                ) {
            // Crear la consulta HQL para obtener el historial filtrado por el ID del usuario
            Query<Historial> query = sesion.createQuery(
                    "FROM Historial  WHERE usuario.id = :idUsuario", Historial.class
            );
            query.setParameter("idUsuario", idUsuario);  // Establece el parámetro con el ID del usuario

            // Ejecutar la consulta y obtener la lista de historiales
            List<Historial> historiales = query.list();

            return historiales;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado el historial o ha fallado", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    public static String buscarMatricula(int idUsuarioHistorial) {

        System.out.println(" Consulta matricula del usuario    " + idUsuarioHistorial);

        HibernateUtil conexion = new HibernateUtil();  // Instancia la conexión con la base de datos
        conexion.conectar(); // Conectar a la base de datos
        Session sesion = conexion.getSessionFactory().openSession();  // Abre la sesión de Hibernate

        String matricula = null;

        try {
            // Crear la consulta HQL para obtener la matrícula del vehículo asociado al usuario
            Query query = sesion.createQuery("FROM Historial h WHERE h.usuario.id = :idUsuario");
            query.setParameter("idUsuario", idUsuarioHistorial);  // Establecer el parámetro del ID del usuario

            // Obtener el primer resultado de la consulta
            matricula = (String) query.uniqueResult();  // Obtener la matrícula

            // Si no se encuentra ningún vehículo, matricula será null
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();  // Cerrar la conexión
        }

        return matricula;  // Retornar la matrícula del vehículo
    }

}
