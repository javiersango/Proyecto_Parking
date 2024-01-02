/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
public class MetodosRegistroCuenta {
    /** Metodo visualizacion seleccion de los campos cuando esta vacion, nombre o texto añadido*/
     public void handleTextFieldClick(JTextField textField, String placeholder) {
    if (textField.getText().equals(placeholder)) {
        textField.setText("");
        textField.setForeground(Color.black);
     
    } else if (textField.getText().isEmpty()) {
        textField.setText(placeholder.toUpperCase());
        textField.setForeground(Color.gray);
    }
  }
     public static boolean isMatriculaValida(String matricula) {
    String regex = "^[0-9]{4}[A-Z]{3}$";
    return matricula.matches(regex);
}

  
    
}
