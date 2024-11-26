/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import modelo.Vehiculos;
import modelo.Reservas;

/**
 *
 * @author Javier Sánchez Gonzalez
 */
public class MetodosPago {
    /**
     * 
     * @param idVehiculo
     * @param num
     * @param fechaReservada
     * @param horas
     * @param precioPorHora
     * @param precioTotal
     * @return  Devuelve verdadro / false pasandole los paramentros
     */
    public static boolean realizarPagoReserva(int idVehiculo, int num, Date fechaReservada, int horas, double precioPorHora, double precioTotal) {

        // Configurar la conexión a la base de datos utilizando Hibernate
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Iniciar una sesión de Hibernate
        Session session = null;
        Transaction transaction = null;

        try {
            // Iniciar la sesión y la transacción
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Buscar el vehículo asociado
            Vehiculos vehiculo = session.get(Vehiculos.class, idVehiculo);
            if (vehiculo == null) {
                System.out.println("No se encontró un vehículo con el ID proporcionado.");
                return false;
            }

            // Buscar la reserva existente
            String hql = "FROM Reservas r WHERE r.vehiculos = :vehiculos AND r.numeroPlaza = :num AND r.fechaReservada = :fechaReservada";
            Query<Reservas> query = session.createQuery(hql, Reservas.class);
            query.setParameter("vehiculos", vehiculo);
            query.setParameter("num", num);
            query.setParameter("fechaReservada", fechaReservada);

            Reservas reserva = query.uniqueResult();

            // Si la reserva existe, actualizamos los valores
            if (reserva != null) {
                reserva.setReservada(Boolean.TRUE);
                reserva.setHorasReserva(horas);
                reserva.setPrecioPorMinuto(precioPorHora);
                reserva.setPrecioTotal(precioTotal);

                session.update(reserva); // Guardar los cambios
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
            e.printStackTrace();
            return false;

        } finally {
            // Cerrar la sesión y la fábrica de sesiones
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
