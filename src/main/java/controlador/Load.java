/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author Javier Sánchez González
 */
public class Load {

    /**
     * Clase Inico de Proyecto con una pantalla en la que simala que se carga la aplicacion
     * @param args 
     */
    public static void main(String[] args) {
        // Inicio de la vista de la pantalla, y vista de incio de sesion
        vista.Loading l = new vista.Loading();
        l.setVisible(true);
        FlatDarkLaf.setup();
        vista.InicioSesion p = new vista.InicioSesion();
        p.setVisible(false);

        try {
            for (int x = 0; x <= 100; x++) {
                Thread.sleep(110);
                l.jLPorciento.setText(Integer.toString(x) + "%");

                l.jPBarraProgreso.setValue(x);

                if (x == 100) {

                    // una vez que acaba la barra de progreso, establece las vista
                    p.setVisible(true);
                    FlatDarkLaf.setup();
                    l.setVisible(false);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
