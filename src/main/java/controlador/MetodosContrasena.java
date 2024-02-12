/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

/**
 *
 * @author Javier Sánchez González
 */
public class MetodosContrasena {

    /**
     * Metodo verifica si una direccion de correo electronico es valida
     * @param correo    se pasa el corrego electronico
     * @return 
     */
    public static boolean esCorreoElectronicoValido(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+).(es|com)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    /**
     * Metodos comprueba que la contraseña y repetircontraseña sea la misma,
     * genera el hash de la contraseña introducida
     * @param contrasena    String 
     * @param repetircontrasena  String 
     * @return 
     */
    public static String crearHashContrasena(String contrasena, String repetircontrasena) {
        // Verificar si las contraseñas coinciden
        if (!contrasena.equals(repetircontrasena)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Contraseñas Incorrectas", JOptionPane.ERROR_MESSAGE);
            return null; // Devuelve null en caso de que las contraseñas no coincidan
        } else {

            // Validar la contraseña ingresada
            PasswordValidator validator = new PasswordValidator(
                    new LengthRule(8, 30), // Longitud mínima y máxima de la contraseña
                    new CharacterRule(EnglishCharacterData.UpperCase, 1), // Al menos una letra mayúscula
                    new CharacterRule(EnglishCharacterData.LowerCase, 1), // Al menos una letra minúscula
                    new CharacterRule(EnglishCharacterData.Digit, 1), // Al menos un dígito
                    new CharacterRule(EnglishCharacterData.Special, 1), // Al menos un carácter especial
                    new WhitespaceRule() // No permite espacios en blanco
            );

            RuleResult result = validator.validate(new PasswordData(contrasena));

            if (!result.isValid()) {
                StringBuilder errorMessage = new StringBuilder("Errores de validación de contraseña:\n");
                for (String message : validator.getMessages(result)) {
                    errorMessage.append(message).append("\n");
                }
                JOptionPane.showMessageDialog(null, errorMessage.toString(), "Error de validación", JOptionPane.ERROR_MESSAGE);
                return null; // Devuelve null en caso de error de validación
            }

            // Si la validación de contraseña es exitosa, procedemos a generar el hash
            String hashedPassword = BCrypt.hashpw(contrasena, BCrypt.gensalt());
            JOptionPane.showMessageDialog(null, "Generado hash correctamente", "Correcto", JOptionPane.QUESTION_MESSAGE);

            return hashedPassword; // Devuelve el hash generado
        }
    }

   /**
    * Metodo que valida contraseña segun lo parametros permitidos
    * @param contrasena
    * @return 
    */
    public static boolean validarContrasena(String contrasena) {
        // Validar la contraseña introcducida
        PasswordValidator validator = new PasswordValidator(
                new LengthRule(8, 12), // Longitud mínima y máxima de la contraseña
                new CharacterRule(EnglishCharacterData.UpperCase, 1), // Al menos una letra mayúscula
                new CharacterRule(EnglishCharacterData.LowerCase, 1), // Al menos una letra minúscula
                new CharacterRule(EnglishCharacterData.Digit, 1), // Al menos un dígito
                new CharacterRule(EnglishCharacterData.Special, 1), // Al menos un carácter especial
                new WhitespaceRule() // No permite espacios en blanco
        );

        RuleResult result = validator.validate(new PasswordData(contrasena));

        return result.isValid(); // si es valida devuelve true, si no false
    }

  /**
   * Metodo se le pasa la contraseña y el hash guardado comprueba que la
     encriptacion sea correcta
   * @param contrasena
   * @param hashGuardado
   * @return 
   */
    public static boolean comprobarContrasena(String contrasena, String hashGuardado) {
        return BCrypt.checkpw(contrasena, hashGuardado);
    }

}
