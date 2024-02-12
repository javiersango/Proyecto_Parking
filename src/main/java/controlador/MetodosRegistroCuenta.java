/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Vehiculos;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Javier
 */
public class MetodosRegistroCuenta {

    /**
     * Metodo se le le pasan los datos de vehiculo y uuario para registra la
     * cuenta en la base de datos parking
     */
    public static boolean guardarCuentaUsuario(String nombre, String apellidos, String email, String matricula, String contrasena, boolean esCoche) {
        // Comprobar si ya existe un usuario con el mismo nombre y contraseña
        if (usuarioExistente(nombre, email)) {
            JOptionPane.showMessageDialog(null, nombre + " ya existe " + email + " Introduca otro email ", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {

            // Configurar la conexión a la base de datos utilizando Hibernate
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

            // Crear una fábrica de sesiones de Hibernate
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Si la conexión es exitosa
            System.out.println("La conexión a la base de datos ad_parking ha sido exitosa.");

            // Abrir una sesión de Hibernate
            Session sesion = sessionFactory.openSession();
            Transaction transaction = null;

            try {
                // Comenzar una transacción
                transaction = sesion.beginTransaction();

                // Crear una instancia de Usuarios y configurar los datos
                Usuarios usuario = new Usuarios();
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setEmail(email);
                usuario.setContrasena(contrasena);

                // Guardar el usuario en la base de datos
                sesion.save(usuario);

                // Crear una instancia de Vehiculos y configurar los datos
                Vehiculos vehiculo = new Vehiculos();
                vehiculo.setUsuarios(usuario); // Establecer la relación con el usuario
                vehiculo.setMatricula(matricula);
                vehiculo.setEsCoche(esCoche);

                // Guardar el vehiculo en la base de datos
                sesion.save(vehiculo);

                // Confirmar la transacción
                transaction.commit();

                return true; // El registro se ha guardado correctamente
            } catch (Exception e) {
                if (transaction != null) {  // El registro no se ha guardado porque el email ya existe.
                    transaction.rollback();
                    JOptionPane.showMessageDialog(null, "Error, el correo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                e.printStackTrace();
                return false;
            } finally {
                // Cerrar la sesion de Hibernate
                sesion.close();
            }
        }
    }

    /**
     * Metodo para comprobar si ya existe un usuario con el mismo nombre,
     * matricula y contraseña
     */
    public static boolean usuarioExistente(String nombre, String email) {
        // Configurar la conexión a la base de datos utilizando Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            // Comenzar una transacción
            transaction = session.beginTransaction();

            // Consulta Hibernate para buscar un usuario con los mismos datos
            String hql = "FROM Usuarios WHERE  email = :email";
            Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);

            Usuarios usuario = query.uniqueResult();

            // Commit de la transacción
            transaction.commit();

            return usuario != null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public static boolean modificarDatosVehiculo(String email, String nuevaMatricula, boolean nuevoEsCoche) {
        // Configurar la conexión a la base de datos utilizando Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            // Comenzar una transacción
            transaction = session.beginTransaction();

            // Consultar Hibernate para buscar un usuario con el antiguo correo electrónico
            String hql = "FROM Usuarios WHERE email = :email";
            Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);
            Usuarios usuario = query.uniqueResult();

            // Verificar si se encontró el usuario
            if (usuario != null) {
                // Obtener el ID del usuario
                int userId = usuario.getId();

                // Consultar los vehículos asociados al usuario por su ID
                String vehiculosHql = "FROM Vehiculos WHERE usuarios.id = :userId";
                Query<Vehiculos> vehiculosQuery = session.createQuery(vehiculosHql, Vehiculos.class);
                vehiculosQuery.setParameter("userId", userId);
                List<Vehiculos> vehiculos = vehiculosQuery.getResultList();

                // Actualizar cada vehículo asociado al usuario
                for (Vehiculos vehiculo : vehiculos) {
                    vehiculo.setMatricula(nuevaMatricula);
                    vehiculo.setEsCoche(nuevoEsCoche);
                    session.update(vehiculo);
                }
            }

            // Commit de la transacción
            transaction.commit();
            return true; // Los datos del vehículo se han actualizado correctamente
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar la sesión de Hibernate
            session.close();
        }
    }

    public static boolean eliminarUsuario(String email) {

        // Configurar la conexión a la base de datos utilizando Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            // Comenzar una transacción
            transaction = session.beginTransaction();

            // Consulta Hibernate para buscar un usuario con el mismo correo electrónico
            String hql = "FROM Usuarios WHERE email = :email";
            Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);

            Usuarios usuario = query.uniqueResult();

            // Eliminar el usuario
            session.delete(usuario);

            // Commit de la transacción
            transaction.commit();

            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo para manejar la visualización de los campos de texto
     */
    public void comportamientoCampos(JTextField textField, String placeholder) {
        if (textField.getText().equals(placeholder)) {
            textField.setText("");
            textField.setForeground(Color.black);
        } else if (textField.getText().isEmpty()) {
            textField.setText(placeholder);
            textField.setForeground(Color.gray);
        }
    }

    /**
     * Metodo para validar si una matricula
     */
    public static boolean validarMatricula(String matricula) {
        String regex = "^[0-9]{4}[A-Z]{3}$";
        return Pattern.matches(regex, matricula);
    }
}
