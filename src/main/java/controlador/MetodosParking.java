/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.toedter.calendar.JCalendar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Javier Sánchez Gonzalez
 */
public class MetodosParking {

    // Mapa para almacenar el estado de las plazas
    private final Map<String, Boolean> estadoPlazas = new HashMap<>();

    // Método para mostrar el calendario
    private void mostrarCalendario() {
        // Crear un calendario
        JCalendar calendario = new JCalendar();

        // Mostrar el calendario en un cuadro de diálogo
        int opcion = JOptionPane.showConfirmDialog(
                null,
                calendario,
                "Selecciona una fecha",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            // Obtener la fecha seleccionada
            java.util.Date fechaSeleccionada = calendario.getDate();
            JOptionPane.showMessageDialog(null, "Fecha seleccionada: " + fechaSeleccionada);
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de MetodosParking
        MetodosParking metodosParking = new MetodosParking();

        // Ejecutar el método mostrarCalendario
        SwingUtilities.invokeLater(() -> metodosParking.mostrarCalendario());
    }

}
