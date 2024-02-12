/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Javier Sánchez González
 */
public class MetodosCuenta {

    /**
     * Metodo se le pasa el email y la contraseña para actualizarla en la pase
     * de datos
     *
     * @param email String
     * @param hashContraseña String
     */
    public boolean modificarContraseña(String email, String contrasena) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory(); Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            int rowCount = session.createQuery("UPDATE Usuarios SET contrasena = :contrasena WHERE email = :email")
                    .setParameter("contrasena", contrasena)
                    .setParameter("email", email)
                    .executeUpdate();

            transaction.commit();

            if (rowCount > 0) {
                System.out.println("Contraseña actualizada correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún usuario con el correo electrónico especificado.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al intentar modificar la contraseña: " + e.getMessage());
            return false;
        }
    }
}
