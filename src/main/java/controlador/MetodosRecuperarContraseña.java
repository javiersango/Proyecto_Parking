/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Javier
 */
/** Metodo verifica si una direccion de correo electronico es válida*/
public class MetodosRecuperarContraseña {
    
     public static boolean esCorreoElectronicoValido(String correo) {
         String regex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+).(es|com)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
    
}
