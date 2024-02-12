package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Javier Sánchez González
 */
public class MetodosBarra {
/**
 * Metodo se le pasa el formato del reloj y la hora que actual 
 */
     public void actualizarReloj() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String horaActual = sdf.format(new Date());
       // relojLabel.setText(horaActual);
    }
 
}

    

