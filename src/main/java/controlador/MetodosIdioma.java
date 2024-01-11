/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;



import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vista.InicioSesion;
import java.util.ResourceBundle;


/**
 *
 * @author Javier
 */
public class MetodosIdioma {
    
    InicioSesion is = new InicioSesion();
    

    public static void cambioIdiomaEnInicioSesion(JLabel jltitulo1, JLabel jltitulo2, JLabel jlnombre, JTextField jtnombre, JLabel jlcontrasena, JButton jbiniciar, JButton jbregistrarse, JButton jbrecuperar) {
        // Cambia por defecto a ingles
        Locale defaultLocale = new Locale("en");
        // Cargar el idioma ingles
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mensajes/messages_en", defaultLocale);
        
        // Obtener las cadenas de texto en ingles
        String titulo1 = resourceBundle.getString("buscasPlazasDeAparcamiento");
        String titulo2 = resourceBundle.getString("InicieSesionOregistrarse");
        String lNombre = resourceBundle.getString("nombre");
        String lContrasena = resourceBundle.getString("contrasena");
        
        String bInciar = resourceBundle.getString("iniciarSesion");
        String bRegistro = resourceBundle.getString("registrarse");
        String bRecuperar = resourceBundle.getString("recuperarContrasena");
        
        // Establecer el texto en los componentes
        jltitulo1.setText(titulo1);
        jltitulo2.setText(titulo2);
        jlnombre.setText(lNombre);
        jtnombre.setText(lNombre);
        jlcontrasena.setText(lContrasena);
        jbiniciar.setText(bInciar);
        jbregistrarse.setText(bRegistro);
        jbrecuperar.setText(bRecuperar);
    }
                                      

    public static void cambioIdiomaEsInicioSesion(JLabel jltitulo1, JLabel jltitulo2, JLabel jlnombre, JTextField jtnombre, JLabel jlcontrasena, JButton jbiniciar, JButton jbregistrarse, JButton jbrecuperar) {
        // Cambia por defecto a ingles
        Locale defaultLocale = new Locale("es");
        // Cargar el idioma ingles
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mensajes/messages_es", defaultLocale);
        // Obtener las traducciones en español de las cadenas de texto en ingles
        String titulo1 = resourceBundle.getString("AreYouLookingForParkingSpaces?");
        String titulo2 = resourceBundle.getString("LogInOrRegister");
        String lNombre = resourceBundle.getString("Name");
        String lContrasena = resourceBundle.getString("Password");
        String bInciar = resourceBundle.getString("LogIn");
        String bRegistro = resourceBundle.getString("Register");
        String bRecuperar = resourceBundle.getString("RecoverPassword");
        
        // Establecer el texto en los componentes
        jltitulo1.setText(titulo1);
        jltitulo2.setText(titulo2);
        jlnombre.setText(lNombre);
        jtnombre.setText(lNombre);
        jlcontrasena.setText(lContrasena);
        jbiniciar.setText(bInciar);
        jbregistrarse.setText(bRegistro);
        jbrecuperar.setText(bRecuperar);
    }
      
  }

        
    
    

    

