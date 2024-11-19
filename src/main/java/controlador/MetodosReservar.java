/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculos;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modelo.Reservas;
import vista.Reserva;

/**
 *
 * @author Javier Sánchez González
 *
 */
public class MetodosReservar {

    public Vehiculos devuelveDatosVehiculo(String nombre, String contrasena) {
        HibernateUtil conexion = new HibernateUtil();  // instanciación de la conexión con la base de datos
        conexion.conectar();
        try (Session session = conexion.getSessionFactory().openSession()) {
            // Consulta para  obtener el vehículo asociado al usuario por nombre y contraseña
            String hql = "SELECT v FROM Vehiculos v WHERE v.usuarios.nombre = :nombre AND v.usuarios.contrasena = :contrasena";
            Query<Vehiculos> query = session.createQuery(hql, Vehiculos.class);
            query.setParameter("nombre", nombre);
            query.setParameter("contrasena", contrasena);
            // Obtenemos el vehículo correspondiente al usuario
            Vehiculos vehiculo = query.uniqueResult();
            // Si encontramos el vehículo, devolvemos sus datos
            if (vehiculo != null) {
                return vehiculo;
            } else {
                return null;
            }
        } catch (Exception e) {

            return null;
        }
    }
/*
    private List<Reserva> obtenerReservasPorFecha(String fecha) {
        // Este es un ejemplo simple, deberías ajustarlo a tu implementación
        List<Reserva> reservas = new ArrayList<>();

        // Imaginemos que tienes un listado de todas las reservas
        for (Reserva reserva : todasLasReservas) {
            if (reserva.getFecha().equals(fecha)) {
                reservas.add(reserva);
            }
        }

        return reservas;
    }
*/
}
