package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MetodosBarra {

     public void actualizarReloj() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String horaActual = sdf.format(new Date());
       // relojLabel.setText(horaActual);
    }
 
}

    

