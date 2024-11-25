/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import modelo.Reservas;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Javier
 */
public class MetodosPago {

    public static boolean realizarPagoReserva(int idVehiculo, int num, Date fechaReservada, int horas, double precioPorHora, double precioTotal) {

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

            // Buscar la reserva existente por los parámetros idVehiculo, num y fechaReservada
            String hql = "FROM Reservas WHERE idVehiculo = :idVehiculo AND numeroPlaza = :num AND fechaReservada = :fechaReservada";
            Query<Reservas> query = session.createQuery(hql, Reservas.class);
            query.setParameter("idVehiculo", idVehiculo);
            query.setParameter("num", num);
            query.setParameter("fechaReservada", fechaReservada);

            // Obtener el resultado de la consulta
            Reservas reserva = query.uniqueResult(); // Devuelve una única reserva que coincida con los parámetros

            // Si la reserva existe, actualizamos los valores
            if (reserva != null) {
                // Actualizar los campos de la reserva
                reserva.setHorasReserva(horas);
                reserva.setPrecioPorMinuto(precioPorHora);
                reserva.setPrecioTotal(precioTotal);

                // Guardar los cambios (no es necesario un save porque ya existe una entidad gestionada)
                session.update(reserva);

                // Commit de la transacción
                transaction.commit();
                System.out.println("Reserva actualizada con éxito.");
                return true;
            } else {
                System.out.println("No se encontró la reserva para los parámetros proporcionados.");
                return false;
            }

        } catch (Exception e) {
            // En caso de error, hacer rollback
            if (transaction != null) {
                transaction.rollback();
            }
            // Agregar información detallada del error para facilitar la depuración
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
}
