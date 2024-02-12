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
     * @param matricula  String  se pasa la matricula del vehiculo
     * @return un listado con los datos fecha, duracion, precio del aparcamiento
     */
    public static List<Historial> buscarMatricula(String matricula) {
        HibernateUtil conexion = new HibernateUtil();  // Instanciación de la conexion con la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // Generamos una conexionn o sesion

        try {
            Query<Historial> query = sesion.createQuery("FROM Historial WHERE matricula = :matri", Historial.class);
            query.setParameter("matri", matricula);
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

}
