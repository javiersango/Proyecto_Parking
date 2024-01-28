/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modelo.Historial;

/**
 *
 * @author Javier Sánchez González
 */




public class MetodosHistorial {

   public static List<Historial> buscarMatricula(String matricula) {
    HibernateUtil conexion = new HibernateUtil();  // Instanciación de la conexión con la base de datos
    conexion.conectar();
    Session sesion = conexion.getSessionFactory().openSession();  // Generamos una conexión o sesión

    try {
        Query<Historial> query = sesion.createQuery("FROM Historial WHERE matricula = :matri", Historial.class);
        query.setParameter("matri", matricula);
        List<Historial> historiales = query.list();
        return historiales;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        sesion.close();
    }
}

}
    
    
    
    

