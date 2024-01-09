/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.util.regex.Matcher;
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

   /** Metodo se le le pasan los datos de vehiculo y uuario para registra la cuenta en la base de datos parking*/
  public static boolean guardarCuentaUsuario(String nombre, String apellidos, String email, String matricula, String contrasena, boolean esCoche) {
        // Comprobar si ya existe un usuario con el mismo nombre y contraseña
         if (usuarioExistente(nombre, email)) {
            JOptionPane.showMessageDialog(null, "El usuario " + nombre + " ya existe. Introduca otro email ", "Error", JOptionPane.ERROR_MESSAGE);
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

            // Guardar el vehículo en la base de datos
            sesion.save(vehiculo);

            // Confirmar la transacción
            transaction.commit();

            return true; // El registro se ha guardado correctamente
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false; // Ha ocurrido un error al guardar el registro
        } finally {
            // Cerrar la sesión de Hibernate
            sesion.close();
        }
         }
    }
  
   /** Método para comprobar si ya existe un usuario con el mismo nombre, matrícula y contraseña*/
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
        String hql = "FROM Usuarios WHERE nombre = :nombre AND email = :email";
        Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
        query.setParameter("nombre", nombre);
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

    /** Método para manejar la visualización de los campos de texto*/
    public void comportamientoCampos(JTextField textField, String placeholder) {
        if (textField.getText().equals(placeholder)) {
            textField.setText("");
            textField.setForeground(Color.black);
        } else if (textField.getText().isEmpty()) {
            textField.setText(placeholder);
            textField.setForeground(Color.gray);
        }
    }

    /** Método para validar si una matrícula es válida*/
    public static boolean validarMatricula(String matricula) {
        String regex = "^[0-9]{4}[A-Z]{3}$";
        return Pattern.matches(regex, matricula);
    }
}
