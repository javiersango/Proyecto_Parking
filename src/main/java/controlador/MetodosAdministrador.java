/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Javier Sánchez González
 */
public class MetodosAdministrador {

    /**
     *
     * @return
     */
    public static List<Usuarios> buscarUsuarios() {

        HibernateUtil conexion = new HibernateUtil();  // Instancia la conexión con la base de datos
        conexion.conectar(); // Conectar a la base de datos
        List<Usuarios> usuarios = new ArrayList<>();

        try (Session sesion = conexion.getSessionFactory().openSession()) {
            Query<Usuarios> query = sesion.createQuery("FROM Usuarios", Usuarios.class);
            usuarios = query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            conexion.desconectar(); // Asegúrate de cerrar la conexión
        }

        return usuarios;
    }

    // Método para eliminar el usuario de la base de datos
    public boolean eliminarUsuario(int idUsuario) {
        boolean eliminado = false;
        HibernateUtil conexion = new HibernateUtil();

        try (Session sesion = conexion.getSessionFactory().openSession()) {
            sesion.beginTransaction();

            // Obtener el usuario por ID y eliminarlo
            Usuarios usuario = sesion.get(Usuarios.class, idUsuario);
            if (usuario != null) {
                sesion.delete(usuario);
                sesion.getTransaction().commit();
                eliminado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
        return eliminado;
    }

}
