/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.HibernateUtil;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.query.Query;
import static controlador.MetodosContrasena.comprobarContrasena;
import javax.swing.ImageIcon;
import modelo.Vehiculos;

/**
 *
 * @author Javier Sánchez González
 */
public class MetodosInicio {

    /**
     * Metodo se le pasa el nombre y la contraseña , que hara las comprobaciones
     * necesarias para que inicie sesion en la aplicacion
     *
     * @param nombre String
     * @param contrasena String
     * @return
     */
    public static boolean comprobarInicioUsuario(String nombre, String contrasena) {
        HibernateUtil conexion = new HibernateUtil();  // instaciacion a la conexion con la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // generamos una conexion o sesison

        try {
            // Comprobar si existe un usuario con el nombre proporcionado
            Query query = sesion.createQuery("FROM Usuarios WHERE nombre = :nombre");
            query.setParameter("nombre", nombre);
            Usuarios usuario = (Usuarios) query.uniqueResult();

            if (usuario != null) {
                // Si el usuario existe, comprobar si la contraseña coincide
                if (comprobarContrasena(contrasena, usuario.getContrasena())) {
                    System.out.println("Inicio de sesión exitoso para: " + nombre);
                    ImageIcon icono = new ImageIcon("img/P.png");
                    JOptionPane.showMessageDialog(null,  nombre.toUpperCase(), "Bienvenido/a a ParkArea", JOptionPane.INFORMATION_MESSAGE, icono);
                    return true; // La contraseña coincide
                } else {
                    // Si la contraseña no coincide, buscar otro usuario con el mismo nombre
                    query = sesion.createQuery("FROM Usuarios WHERE nombre = :nombre AND id != :id");
                    query.setParameter("nombre", nombre);
                    query.setParameter("id", usuario.getId());
                    Usuarios otroUsuario = (Usuarios) query.uniqueResult();

                    if (otroUsuario != null && comprobarContrasena(contrasena, otroUsuario.getContrasena())) {
                        System.out.println("Inicio de sesión exitoso para otro usuario con el mismo nombre: " + nombre);
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso para otro usuario con el mismo nombre", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        return true; // La contraseña coincide para otro usuario con el mismo nombre
                    } else {
                        System.out.println("Contraseña incorrecta para: " + nombre);
                        System.out.println("Contraseña incorrecta para: " + usuario.getContrasena());
                        System.out.println("Contraseña incorrecta para: " + contrasena);
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        return false; // La contraseña no coincide
                    }
                }
            } else {
                System.out.println("El usuario no existe: " + nombre);
                JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return false; // El usuario no existe
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Ha ocurrido un error
        } finally {
            // Cerrar la sesión de Hibernate
            conexion.desconectar();
        }
    }

    public static int devuelveIdUsuario(String nombre, String contrasena) {
        HibernateUtil conexion = new HibernateUtil();  // Instancia la conexión a la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // Abre la sesión de Hibernate

        int usuarioId = -1;  // Variable para almacenar el ID del usuario

        try {
            // Comprobar si existe un usuario con el nombre proporcionado
            Query query = sesion.createQuery("FROM Usuarios WHERE nombre = :nombre");
            query.setParameter("nombre", nombre);
            Usuarios usuario = (Usuarios) query.uniqueResult();

            if (usuario != null) {
                // Si el usuario existe, comprobar si la contraseña coincide
                if (comprobarContrasena(contrasena, usuario.getContrasena())) {
                    // Si la contraseña es correcta, devolver el ID del usuario
                    usuarioId = usuario.getId();
                    System.out.println("Inicio de sesión exitoso para: " + nombre);
                } else {
                    // Si la contraseña no coincide, mostrar mensaje de error
                    System.out.println("Contraseña incorrecta para: " + nombre);
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Si el usuario no existe
                System.out.println("El usuario no existe: " + nombre);
                JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar la sesión de Hibernate
            conexion.desconectar();
        }

        return usuarioId;  // Devolver el ID del usuario (o -1 si no se encuentra o hay error)
    }

    public void iniciarSesion(String nombre, String contrasena) {
        if (comprobarInicioUsuario(nombre, contrasena)) {
            // Si el inicio de sesión es exitoso
            System.out.println("Inicio de sesión exitoso.");
            // Aquí puedes continuar con la lógica para manejar el usuario
        } else {
            // Si el inicio de sesión falla
            System.out.println("Error en el inicio de sesión.");
        }
    }

    public static Usuarios obtenerUsuario(int idUsuario) {
        HibernateUtil conexion = new HibernateUtil();  // Instancia la conexión a la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // Abre la sesión de Hibernate
        Usuarios usuario = null;

        try {
            // Método para cargar el usuario desde la base de datos utilizando el idUsuario
            String hql = "FROM Usuarios u WHERE u.id = :idUsuario";
            Query query = sesion.createQuery(hql);
            query.setParameter("idUsuario", idUsuario);
            usuario = (Usuarios) query.uniqueResult();
        } finally {
            if (sesion != null) {
                sesion.close();  // Cierra la sesión de Hibernate para liberar recursos
            }
        }

        return usuario;
    }

    public static Vehiculos obtenerVehiculoPorUsuarioId(Integer usuarioId) {
        HibernateUtil conexion = new HibernateUtil();  // Instancia la conexión a la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // Abre la sesión de Hibernate
        Vehiculos vehiculo = null;
        try {
            String hql = "FROM Vehiculos v WHERE v.usuarios.id = :usuarioId";
            Query query = sesion.createQuery(hql);
            query.setParameter("usuarioId", usuarioId);
            vehiculo = (Vehiculos) query.uniqueResult();
        } finally {
            sesion.close();
        }
        return vehiculo;
    }

}
