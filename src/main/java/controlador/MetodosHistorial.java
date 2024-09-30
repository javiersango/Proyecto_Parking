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
   
    public static List<Historial> buscarMatricula() {

        HibernateUtil conexion = new HibernateUtil();  // Instanciación de la conexion con la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // Generamos una conexionn o sesion

        try {
            Query<Historial> query = sesion.createQuery("FROM Historial ", Historial.class);
            List<Historial> historiales = query.list();
            return historiales;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado la matricula o ha fallado", "Error", JOptionPane.ERROR);
            e.printStackTrace();
            return null;
        } finally {
            sesion.close();
        }
    }

   

    public static int obtenerUsuarioId(String nombre, String contrasena) {
         int usuarioId = 0;

    // Iniciar la conexión con la base de datos
    HibernateUtil conexion = new HibernateUtil();
    conexion.conectar();
    Session sesion = conexion.getSessionFactory().openSession();  // Generamos una sesión

    try {
        // Consulta HQL para obtener el ID del usuario por nombre y contraseña
        String hql = "SELECT u.id FROM Usuarios u WHERE u.nombre = :nombre AND u.contrasena = :contrasena";
        Query<Integer> query = sesion.createQuery(hql, Integer.class);
        query.setParameter("nombre", nombre);
        query.setParameter("contrasena", contrasena);

        // Obtener el ID del usuario (debe ser único)
        usuarioId = query.uniqueResult(); 
       
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el ID del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        sesion.close();  // Asegurarse de cerrar la sesión
    }
        return usuarioId;
    }

    public static List<Historial> buscarPorUsuario(int usuarioId) {
       
        HibernateUtil conexion = new HibernateUtil();  // Instanciación de la conexión con la base de datos
    conexion.conectar();
    Session sesion = conexion.getSessionFactory().openSession();  // Generamos una conexión o sesión

    try {
        // Consulta HQL para obtener los historiales del usuario específico
        Query<Historial> query = sesion.createQuery("FROM Historial WHERE usuario.id = :usuarioId", Historial.class);
        query.setParameter("usuarioId", usuarioId);

        // Listar los resultados
        List<Historial> historiales = query.list();
        return historiales;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el historial del usuario", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        return null;
    } finally {
        sesion.close();  // Asegurarse de cerrar la sesión
    }
}
}
