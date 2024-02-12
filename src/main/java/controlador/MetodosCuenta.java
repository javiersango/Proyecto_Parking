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
     * @param nuevaContrasena String
     */
    public void modificarContraseña(String email, String nuevaContrasena) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Crear y ejecutar la consulta HQL para actualizar la contraseña del usuario
            int rowCount = session.createQuery("UPDATE Usuarios SET contrasena = :nuevaContrasena WHERE email = :email")
                    .setParameter("nuevaContrasena", nuevaContrasena)
                    .setParameter("email", email)
                    .executeUpdate();

            if (rowCount > 0) {
                transaction.commit();
                System.out.println("Contraseña actualizada correctamente.");
            } else {
                System.out.println("No se encontró ningún usuario con el correo electrónico especificado.");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
