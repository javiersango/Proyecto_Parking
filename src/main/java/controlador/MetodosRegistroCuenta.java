/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
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
 * @author Javier Sánchez González
 */
public class MetodosRegistroCuenta {

    /**
     * Metodo se le le pasan los datos de vehiculo y uuario para registra la
     * cuenta en la base de datos parking
     *
     * @param nombre String
     * @param apellidos String
     * @param email String
     * @param matricula String
     * @param contrasena password
     * @param esCoche boolean
     * @return
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

            // Crea sesion 
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            // cimprobacion en terminal
            System.out.println("La conexión a la base de datos ad_parking ha sido exitosa.");

            Session sesion = sessionFactory.openSession();
            Transaction transaction = null;

            try {

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
                vehiculo.setUsuarios(usuario); // Establece la relacion con el usuario
                vehiculo.setMatricula(matricula);
                vehiculo.setEsCoche(esCoche);

                // Guardar el vehiculo en la base de datos
                sesion.save(vehiculo);

                // Confirmar la transacción
                transaction.commit();

                return true; // El registro se ha guardado correctamente
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    JOptionPane.showMessageDialog(null, "Error, el correo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                e.printStackTrace();
                return false;
            } finally {
                // Cerrar la sesion 
                sesion.close();
            }
        }
    }

    /**
     * Metodo para modifica los datos del vehiculo simpre que exsita el email,
     * se actualizara la matricula y si es coche o moto
     *
     * @param idUsuario
     * @param nombre
     * @param apellidos
     * @param email String
     * @param matricula
     * @param contrasena
     * @param esCoche
     * @param nuevoEsCoche String
     * @return devuelve true / false
     */
    public static boolean modificarCuentaUsuario(int idUsuario, String nombre, String apellidos, String email, String matricula, String contrasena, Boolean esCoche) {
        // Configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("Conexión a la base de datos exitosa para modificar usuario.");

        Session sesion = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = sesion.beginTransaction();
            System.out.println("Transacción iniciada.");

            // Recuperar el usuario existente por ID
            Usuarios usuario = sesion.get(Usuarios.class, idUsuario);

            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return false; // No continuar si no se encuentra el usuario
            }

            // Modificar los datos del usuario
            if (nombre != null && !nombre.isEmpty()) {
                usuario.setNombre(nombre);
                System.out.println("Nombre modificado: " + nombre);
            }
            if (apellidos != null && !apellidos.isEmpty()) {
                usuario.setApellidos(apellidos);
                System.out.println("Apellidos modificados: " + apellidos);
            }
            if (email != null && !email.equals(usuario.getEmail())) {
                usuario.setEmail(email);
                System.out.println("Email modificado: " + email);
            }
            if (contrasena != null && !contrasena.isEmpty()) {
                usuario.setContrasena(contrasena);
                System.out.println("Contraseña modificada.");
            }

            // Actualizar usuario
            sesion.update(usuario);
            System.out.println("Usuario actualizado.");

            // Recuperar y actualizar el vehículo
            String hql = "FROM Vehiculos WHERE usuarios.id = :idUsuario";
            Vehiculos vehiculo = sesion.createQuery(hql, Vehiculos.class)
                    .setParameter("idUsuario", idUsuario)
                    .uniqueResult();

            if (vehiculo != null) {
                if (matricula != null && !matricula.isEmpty()) {
                    vehiculo.setMatricula(matricula);
                    System.out.println("Matrícula del vehículo modificada: " + matricula);
                }
                if (esCoche != null) {
                    vehiculo.setEsCoche(esCoche);
                    System.out.println("Tipo de vehículo modificado: " + esCoche);
                }
                sesion.update(vehiculo);
                System.out.println("Vehículo actualizado.");
            }

            // Realizar un flush para asegurar que las modificaciones se escriban
            sesion.flush();
            System.out.println("Flush ejecutado.");

            // Confirmar la transacción
            transaction.commit();
            System.out.println("Transacción confirmada.");

            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transacción revertida.");
            }
            JOptionPane.showMessageDialog(null, "Error al modificar los datos. El programa se cerrará.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            sesion.close();
            System.out.println("Sesión cerrada.");
        }
    }

    /**
     * Metodo para comprobar si ya existe un usuario con el mismo nombre,
     * matricula y contraseña
     *
     * @param nombre String
     * @param email String
     * @return
     */
    public static boolean usuarioExistente(String nombre, String email) {
        // Configurar la conexión 
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Consulta para buscar un usuario con los mismos datos (excluyendo al usuario actual)
            String hql = "FROM Usuarios WHERE (email = :email OR nombre = :nombre) AND id != :idUsuario";
            Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);
            query.setParameter("nombre", nombre);

            // Obtener el usuario
            Usuarios usuario = query.uniqueResult();

            // Commit de la transacción
            transaction.commit();

            // Si el usuario existe, devuelve true (pero no es el mismo que está actualizando los datos)
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

    /**
     * Metodo se le pasa el correo electronico del usario, si existe se elimnara
     *
     * @param email String
     * @return devuelve true / false
     */
    public static boolean eliminarUsuario(String email) {

        // Configurar la conexión 
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            // Consulta para buscar un usuario con el mismo correo electronico
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
     * Metodo para manejar la visualización de los campos de texto al introducir
     * el texto o seleccinarlo
     *
     * @param textField
     * @param placeholder
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
     * Metodo para validar si la matricula introducida es valida
     *
     * @param matricula String
     * @return devuelve true / false
     */
    public static boolean validarMatricula(String matricula) {
        // Modificación para aceptar 4 dígitos seguidos de un espacio y 3 letras mayúsculas
        String regex = "^[0-9]{4} [A-Z]{3}$";
        return Pattern.matches(regex, matricula);
    }

}
