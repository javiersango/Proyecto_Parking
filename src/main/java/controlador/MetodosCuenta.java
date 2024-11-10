/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Javier Sánchez González
 */
public class MetodosCuenta {

    /**
     * Método para modificar la contraseña de un usuario en la base de datos.
     *
     * @param email Correo electrónico del usuario.
     * @param contrasena Nueva contraseña del usuario.
     * @return boolean Indicador de éxito o fracaso.
     */
    public boolean modificarContraseña(String email, String contrasena) {
        
        HibernateUtil conexion = new HibernateUtil();  // instaciacion a la conexion con la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // generamos una conexion o sesison
        try  {
            // Iniciar la transacción
            Transaction transaction = sesion.beginTransaction();

            // Crear la consulta HQL para actualizar la contraseña
            int rowCount = sesion.createQuery("UPDATE Usuario SET contrasena = :contrasena WHERE email = :email")
                    .setParameter("contrasena", contrasena)
                    .setParameter("email", email)
                    .executeUpdate();

            // Confirmar la transacción
            transaction.commit();

            // Verificamos si se actualizó alguna fila
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

    /**
     * Método para eliminar una cuenta de usuario en la base de datos.
     *
     * @param nombre Nombre del usuario.
     * @param hashContrasena Contraseña en formato hash del usuario.
     * @return boolean Indicador de éxito o fracaso.
     */
    public boolean eliminarCuentaUsuario(String nombre, String email) {
        System.out.println("eliminar cuenta usuario " + nombre + " " + email);
        HibernateUtil conexion = new HibernateUtil();  // instaciacion a la conexion con la base de datos
        conexion.conectar();
        Session sesion = conexion.getSessionFactory().openSession();  // generamos una conexion o sesison

        try {
            // Iniciar la transacción
            Transaction transaction = sesion.beginTransaction();

            // Crear la consulta HQL para eliminar el usuario
            Query query = sesion.createQuery("DELETE FROM Usuarios WHERE nombre = :nombre AND email = :email");
            query.setParameter("nombre", nombre);
            query.setParameter("email", email);
            

            // Ejecutar la consulta de eliminación
            int lineas = query.executeUpdate();
            System.out.println("Lineas encontradas " + lineas);
            // Confirmar la transacción
            transaction.commit();

            // Si lineas es mayor que 0, significa que se eliminó al menos un registro
            return lineas > 0;
            
        } catch (Exception e) {
            // Imprimir error si ocurre una excepción
            System.err.println("Error al intentar eliminar el usuario: " + e.getMessage());
            return false;
        }
    }
}
