/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import modelo.Usuarios;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Javier Sánchez González
 */
public class Parking extends javax.swing.JPanel {

    // Inicializacion variables
    private Map<String, JTextField> plazasTextFields;
    private Map<String, JCheckBox> plazasCheckBoxes;
    private Map<String, Boolean> estadoPlazas;
    private String textoPlazaSeleccionada;
    private final Usuarios usuarios;
    private JDateChooser dateChooser;

    /**
     * Creates new form RegistroCuenta
     */
    public Parking(Usuarios usuarios) {
        this.usuarios = usuarios;
        initComponents();

        // Poner jTexfield y jBotton el radio
        jbreservar.putClientProperty("FlatLaf.style", "arc: 15");
        jbCancelar.putClientProperty("FlatLaf.style", "arc: 15");
        panelRoundP1.putClientProperty("FlatLaf.style", "arc: 15");

        // jlreservar.putClientProperty("FlatLaf.styleClass", "h1");
        jltitulo2.putClientProperty("FlatLaf.styleClass", "h3");
        jltitulo3.putClientProperty("FlatLaf.styleClass", "h0");

        // Inicializar mapas y estructuras de datos
        plazasTextFields = new HashMap<>();
        plazasTextFields.put("P01", P01);
        plazasTextFields.put("P02", P02);
        plazasTextFields.put("P03", P03);
        plazasTextFields.put("P04", P04);
        plazasTextFields.put("P05", P05);
        plazasTextFields.put("P06", P06);
        plazasTextFields.put("P07", P07);
        plazasTextFields.put("P08", P08);
        plazasTextFields.put("P09", P09);
        plazasTextFields.put("P10", P10);
        plazasTextFields.put("P11", P11);
        plazasTextFields.put("P12", P12);
        plazasTextFields.put("P13", P13);
        plazasTextFields.put("P14", P14);

        plazasCheckBoxes = new HashMap<>();
        plazasCheckBoxes.put("P01", jCheckBoxP1);
        plazasCheckBoxes.put("P02", jCheckBoxP2);
        plazasCheckBoxes.put("P03", jCheckBoxP3);
        plazasCheckBoxes.put("P04", jCheckBoxP4);
        plazasCheckBoxes.put("P05", jCheckBoxP5);
        plazasCheckBoxes.put("P06", jCheckBoxP6);
        plazasCheckBoxes.put("P07", jCheckBoxP7);
        plazasCheckBoxes.put("P08", jCheckBoxP8);
        plazasCheckBoxes.put("P09", jCheckBoxP9);
        plazasCheckBoxes.put("P10", jCheckBoxP10);
        plazasCheckBoxes.put("P11", jCheckBoxP11);
        plazasCheckBoxes.put("P12", jCheckBoxP12);
        plazasCheckBoxes.put("P13", jCheckBoxP13);
        plazasCheckBoxes.put("P14", jCheckBoxP14);

        // Inicializacion  de todas las plazas como inicialmente no ocupadas
        estadoPlazas = new HashMap<>();
        for (String plaza : plazasTextFields.keySet()) {
            estadoPlazas.put(plaza, false);
        }

        // Agregar ActionListener a cada checkbox
        for (Map.Entry<String, JCheckBox> entry : plazasCheckBoxes.entrySet()) {
            String numeroPlaza = entry.getKey();
            JCheckBox checkBox = entry.getValue();

            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Iterar sobre todos los JCheckBoxes
                    for (Map.Entry<String, JCheckBox> entry : plazasCheckBoxes.entrySet()) {
                        String plaza = entry.getKey();
                        JCheckBox cb = entry.getValue();
                        JTextField textField = plazasTextFields.get(plaza);

                        // Verificar si el checkBox seleccionado
                        if (cb == checkBox) {
                            // establece su texto como "Reservado"
                            textField.setText("Reservado");
                        } else {
                            // Si no es el seleccionado, deja la posición de la plaza 
                            textField.setText(plaza);
                            // Desmarcar el JCheckBox
                            cb.setSelected(false);
                        }
                    }

                    // Actualizar el estado de la plaza en la estructura de datos
                    estadoPlazas.put(numeroPlaza, checkBox.isSelected());
                    estadoPlazas.put(numeroPlaza, checkBox.isSelected());

                    // Obtener el texto de la plaza seleccionada Pasar el texto de la plaza seleccionada a la clase Reserva
                    textoPlazaSeleccionada = checkBox.isSelected() ? "Reservado" : numeroPlaza;

                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panelCuenta = new vista.PanelRound();
        jlreservar = new javax.swing.JLabel();
        jltitulo2 = new javax.swing.JLabel();
        jbreservar = new javax.swing.JButton();
        jltitulo3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        panelRoundP1 = new vista.PanelRound();
        P01 = new javax.swing.JTextField();
        panelRoundP2 = new vista.PanelRound();
        P02 = new javax.swing.JTextField();
        panelRoundP3 = new vista.PanelRound();
        P03 = new javax.swing.JTextField();
        panelRoundP4 = new vista.PanelRound();
        P04 = new javax.swing.JTextField();
        panelRoundP5 = new vista.PanelRound();
        P05 = new javax.swing.JTextField();
        panelRoundP6 = new vista.PanelRound();
        P06 = new javax.swing.JTextField();
        panelRoundP7 = new vista.PanelRound();
        P07 = new javax.swing.JTextField();
        panelRoundP8 = new vista.PanelRound();
        P08 = new javax.swing.JTextField();
        panelRoundP9 = new vista.PanelRound();
        P09 = new javax.swing.JTextField();
        panelRoundP10 = new vista.PanelRound();
        P10 = new javax.swing.JTextField();
        panelRoundP11 = new vista.PanelRound();
        P11 = new javax.swing.JTextField();
        panelRoundP12 = new vista.PanelRound();
        P12 = new javax.swing.JTextField();
        panelRoundP13 = new vista.PanelRound();
        P13 = new javax.swing.JTextField();
        panelRoundP14 = new vista.PanelRound();
        P14 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jlentrada = new javax.swing.JLabel();
        jlsalida = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jCheckBoxP1 = new javax.swing.JCheckBox();
        jCheckBoxP2 = new javax.swing.JCheckBox();
        jCheckBoxP3 = new javax.swing.JCheckBox();
        jCheckBoxP4 = new javax.swing.JCheckBox();
        jCheckBoxP5 = new javax.swing.JCheckBox();
        jCheckBoxP6 = new javax.swing.JCheckBox();
        jCheckBoxP7 = new javax.swing.JCheckBox();
        jCheckBoxP8 = new javax.swing.JCheckBox();
        jCheckBoxP9 = new javax.swing.JCheckBox();
        jCheckBoxP10 = new javax.swing.JCheckBox();
        jCheckBoxP11 = new javax.swing.JCheckBox();
        jCheckBoxP12 = new javax.swing.JCheckBox();
        jCheckBoxP13 = new javax.swing.JCheckBox();
        jCheckBoxP14 = new javax.swing.JCheckBox();
        jBCalendario = new javax.swing.JButton();
        jtFecha = new javax.swing.JTextField();
        jbCancelar = new javax.swing.JButton();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelCuenta.setBackground(new java.awt.Color(249, 251, 255));
        panelCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        panelCuenta.setPreferredSize(new java.awt.Dimension(428, 800));
        panelCuenta.setRoundBottomLeft(30);
        panelCuenta.setRoundBottomRight(30);
        panelCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlreservar.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jlreservar.setForeground(new java.awt.Color(39, 59, 244));
        jlreservar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlreservar.setText("RESERVAR PLAZA");
        jlreservar.setPreferredSize(new java.awt.Dimension(273, 30));
        panelCuenta.add(jlreservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 220, 34));

        jltitulo2.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(51, 51, 51));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo2.setText("Que dia?");
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));
        panelCuenta.add(jltitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, 19));

        jbreservar.setBackground(new java.awt.Color(43, 220, 61));
        jbreservar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbreservar.setForeground(new java.awt.Color(255, 255, 255));
        jbreservar.setText("Reservar");
        jbreservar.setToolTipText("Boton hace la reserva");
        jbreservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbreservar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbreservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbreservarActionPerformed(evt);
            }
        });
        panelCuenta.add(jbreservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));

        jltitulo3.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo3.setForeground(new java.awt.Color(25, 35, 66));
        jltitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo3.setText(" Seleccione una plaza ");
        jltitulo3.setPreferredSize(new java.awt.Dimension(273, 30));
        panelCuenta.add(jltitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 356, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 665, 193, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 384, 10));

        panelRoundP1.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP1.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP1.setRoundBottomLeft(20);
        panelRoundP1.setRoundTopLeft(20);

        P01.setBackground(new java.awt.Color(39, 59, 244));
        P01.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P01.setForeground(new java.awt.Color(255, 255, 255));
        P01.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P01.setText("P01");

        javax.swing.GroupLayout panelRoundP1Layout = new javax.swing.GroupLayout(panelRoundP1);
        panelRoundP1.setLayout(panelRoundP1Layout);
        panelRoundP1Layout.setHorizontalGroup(
            panelRoundP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP1Layout.setVerticalGroup(
            panelRoundP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P01, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 163, -1, -1));

        panelRoundP2.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP2.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP2.setRoundBottomLeft(20);
        panelRoundP2.setRoundTopLeft(20);

        P02.setBackground(new java.awt.Color(39, 59, 244));
        P02.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P02.setForeground(new java.awt.Color(255, 255, 255));
        P02.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P02.setText("P02");

        javax.swing.GroupLayout panelRoundP2Layout = new javax.swing.GroupLayout(panelRoundP2);
        panelRoundP2.setLayout(panelRoundP2Layout);
        panelRoundP2Layout.setHorizontalGroup(
            panelRoundP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P02, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP2Layout.setVerticalGroup(
            panelRoundP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P02, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 237, -1, -1));

        panelRoundP3.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP3.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP3.setRoundBottomLeft(20);
        panelRoundP3.setRoundTopLeft(20);

        P03.setBackground(new java.awt.Color(39, 59, 244));
        P03.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P03.setForeground(new java.awt.Color(255, 255, 255));
        P03.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P03.setText("P03");

        javax.swing.GroupLayout panelRoundP3Layout = new javax.swing.GroupLayout(panelRoundP3);
        panelRoundP3.setLayout(panelRoundP3Layout);
        panelRoundP3Layout.setHorizontalGroup(
            panelRoundP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P03, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP3Layout.setVerticalGroup(
            panelRoundP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P03, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 311, -1, -1));

        panelRoundP4.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP4.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP4.setRoundBottomLeft(20);
        panelRoundP4.setRoundTopLeft(20);

        P04.setBackground(new java.awt.Color(39, 59, 244));
        P04.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P04.setForeground(new java.awt.Color(255, 255, 255));
        P04.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P04.setText("P04");

        javax.swing.GroupLayout panelRoundP4Layout = new javax.swing.GroupLayout(panelRoundP4);
        panelRoundP4.setLayout(panelRoundP4Layout);
        panelRoundP4Layout.setHorizontalGroup(
            panelRoundP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P04, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP4Layout.setVerticalGroup(
            panelRoundP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P04, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 385, -1, -1));

        panelRoundP5.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP5.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP5.setRoundBottomLeft(20);
        panelRoundP5.setRoundTopLeft(20);

        P05.setBackground(new java.awt.Color(39, 59, 244));
        P05.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P05.setForeground(new java.awt.Color(255, 255, 255));
        P05.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P05.setText("P05");

        javax.swing.GroupLayout panelRoundP5Layout = new javax.swing.GroupLayout(panelRoundP5);
        panelRoundP5.setLayout(panelRoundP5Layout);
        panelRoundP5Layout.setHorizontalGroup(
            panelRoundP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P05, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP5Layout.setVerticalGroup(
            panelRoundP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P05, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 459, -1, -1));

        panelRoundP6.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP6.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP6.setRoundBottomLeft(20);
        panelRoundP6.setRoundTopLeft(20);

        P06.setBackground(new java.awt.Color(39, 59, 244));
        P06.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P06.setForeground(new java.awt.Color(255, 255, 255));
        P06.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P06.setText("P06");

        javax.swing.GroupLayout panelRoundP6Layout = new javax.swing.GroupLayout(panelRoundP6);
        panelRoundP6.setLayout(panelRoundP6Layout);
        panelRoundP6Layout.setHorizontalGroup(
            panelRoundP6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P06, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP6Layout.setVerticalGroup(
            panelRoundP6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P06, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 533, -1, -1));

        panelRoundP7.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP7.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP7.setRoundBottomLeft(20);
        panelRoundP7.setRoundTopLeft(20);

        P07.setBackground(new java.awt.Color(39, 59, 244));
        P07.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P07.setForeground(new java.awt.Color(255, 255, 255));
        P07.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P07.setText("P07");

        javax.swing.GroupLayout panelRoundP7Layout = new javax.swing.GroupLayout(panelRoundP7);
        panelRoundP7.setLayout(panelRoundP7Layout);
        panelRoundP7Layout.setHorizontalGroup(
            panelRoundP7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P07, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP7Layout.setVerticalGroup(
            panelRoundP7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P07, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 607, -1, -1));

        panelRoundP8.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP8.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP8.setRoundBottomRight(20);
        panelRoundP8.setRoundTopRight(20);

        P08.setBackground(new java.awt.Color(39, 59, 244));
        P08.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P08.setForeground(new java.awt.Color(255, 255, 255));
        P08.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P08.setText("P08");

        javax.swing.GroupLayout panelRoundP8Layout = new javax.swing.GroupLayout(panelRoundP8);
        panelRoundP8.setLayout(panelRoundP8Layout);
        panelRoundP8Layout.setHorizontalGroup(
            panelRoundP8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P08, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP8Layout.setVerticalGroup(
            panelRoundP8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P08, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 163, -1, -1));

        panelRoundP9.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP9.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP9.setRoundBottomRight(20);
        panelRoundP9.setRoundTopRight(20);

        P09.setBackground(new java.awt.Color(39, 59, 244));
        P09.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P09.setForeground(new java.awt.Color(255, 255, 255));
        P09.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P09.setText("P09");

        javax.swing.GroupLayout panelRoundP9Layout = new javax.swing.GroupLayout(panelRoundP9);
        panelRoundP9.setLayout(panelRoundP9Layout);
        panelRoundP9Layout.setHorizontalGroup(
            panelRoundP9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P09, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP9Layout.setVerticalGroup(
            panelRoundP9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P09, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 237, -1, -1));

        panelRoundP10.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP10.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP10.setRoundBottomRight(20);
        panelRoundP10.setRoundTopRight(20);

        P10.setBackground(new java.awt.Color(39, 59, 244));
        P10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P10.setForeground(new java.awt.Color(255, 255, 255));
        P10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P10.setText("P10");

        javax.swing.GroupLayout panelRoundP10Layout = new javax.swing.GroupLayout(panelRoundP10);
        panelRoundP10.setLayout(panelRoundP10Layout);
        panelRoundP10Layout.setHorizontalGroup(
            panelRoundP10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP10Layout.setVerticalGroup(
            panelRoundP10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P10, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP10, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 311, -1, -1));

        panelRoundP11.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP11.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP11.setRoundBottomRight(20);
        panelRoundP11.setRoundTopRight(20);

        P11.setBackground(new java.awt.Color(39, 59, 244));
        P11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P11.setForeground(new java.awt.Color(255, 255, 255));
        P11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P11.setText("P11");

        javax.swing.GroupLayout panelRoundP11Layout = new javax.swing.GroupLayout(panelRoundP11);
        panelRoundP11.setLayout(panelRoundP11Layout);
        panelRoundP11Layout.setHorizontalGroup(
            panelRoundP11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP11Layout.setVerticalGroup(
            panelRoundP11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P11, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 385, -1, -1));

        panelRoundP12.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP12.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP12.setRoundBottomRight(20);
        panelRoundP12.setRoundTopRight(20);

        P12.setBackground(new java.awt.Color(39, 59, 244));
        P12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P12.setForeground(new java.awt.Color(255, 255, 255));
        P12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P12.setText("P12");

        javax.swing.GroupLayout panelRoundP12Layout = new javax.swing.GroupLayout(panelRoundP12);
        panelRoundP12.setLayout(panelRoundP12Layout);
        panelRoundP12Layout.setHorizontalGroup(
            panelRoundP12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP12Layout.setVerticalGroup(
            panelRoundP12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P12, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 459, -1, -1));

        panelRoundP13.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP13.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP13.setRoundBottomRight(20);
        panelRoundP13.setRoundTopRight(20);

        P13.setBackground(new java.awt.Color(39, 59, 244));
        P13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P13.setForeground(new java.awt.Color(255, 255, 255));
        P13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P13.setText("P13");

        javax.swing.GroupLayout panelRoundP13Layout = new javax.swing.GroupLayout(panelRoundP13);
        panelRoundP13.setLayout(panelRoundP13Layout);
        panelRoundP13Layout.setHorizontalGroup(
            panelRoundP13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP13Layout.setVerticalGroup(
            panelRoundP13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P13, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP13, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 533, -1, -1));

        panelRoundP14.setBackground(new java.awt.Color(39, 59, 244));
        panelRoundP14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 7, 244), 1, true));
        panelRoundP14.setPreferredSize(new java.awt.Dimension(84, 46));
        panelRoundP14.setRoundBottomRight(20);
        panelRoundP14.setRoundTopRight(20);

        P14.setBackground(new java.awt.Color(39, 59, 244));
        P14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        P14.setForeground(new java.awt.Color(255, 255, 255));
        P14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        P14.setText("P14");

        javax.swing.GroupLayout panelRoundP14Layout = new javax.swing.GroupLayout(panelRoundP14);
        panelRoundP14.setLayout(panelRoundP14Layout);
        panelRoundP14Layout.setHorizontalGroup(
            panelRoundP14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );
        panelRoundP14Layout.setVerticalGroup(
            panelRoundP14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundP14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P14, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCuenta.add(panelRoundP14, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 607, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 668, 171, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 150, 171, 10));

        jlentrada.setForeground(new java.awt.Color(0, 0, 0));
        jlentrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlentrada.setText("ENTRADA");
        panelCuenta.add(jlentrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 144, 76, -1));

        jlsalida.setForeground(new java.awt.Color(0, 0, 0));
        jlsalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlsalida.setText("SALIDA");
        panelCuenta.add(jlsalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 659, 76, -1));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 591, 124, 10));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 517, 124, 10));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 443, 124, 10));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 369, 124, 10));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 295, 124, 10));

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 221, 124, 10));

        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 221, 124, 10));

        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 295, 124, 10));

        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 369, 124, 10));

        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 443, 124, 10));

        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 517, 124, 10));

        jSeparator18.setForeground(new java.awt.Color(0, 0, 0));
        panelCuenta.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 591, 124, 10));

        buttonGroup.add(jCheckBoxP1);
        panelCuenta.add(jCheckBoxP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 178, -1, -1));

        buttonGroup.add(jCheckBoxP2);
        jCheckBoxP2.setSelected(true);
        panelCuenta.add(jCheckBoxP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 252, -1, -1));

        buttonGroup.add(jCheckBoxP3);
        panelCuenta.add(jCheckBoxP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 321, -1, -1));

        buttonGroup.add(jCheckBoxP4);
        panelCuenta.add(jCheckBoxP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 396, -1, -1));

        buttonGroup.add(jCheckBoxP5);
        panelCuenta.add(jCheckBoxP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 475, -1, -1));

        buttonGroup.add(jCheckBoxP6);
        panelCuenta.add(jCheckBoxP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 545, -1, -1));

        buttonGroup.add(jCheckBoxP7);
        panelCuenta.add(jCheckBoxP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 618, -1, -1));

        buttonGroup.add(jCheckBoxP8);
        panelCuenta.add(jCheckBoxP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 178, -1, -1));

        buttonGroup.add(jCheckBoxP9);
        panelCuenta.add(jCheckBoxP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 249, -1, -1));

        buttonGroup.add(jCheckBoxP10);
        panelCuenta.add(jCheckBoxP10, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 323, -1, -1));

        buttonGroup.add(jCheckBoxP11);
        panelCuenta.add(jCheckBoxP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 397, -1, -1));

        buttonGroup.add(jCheckBoxP12);
        panelCuenta.add(jCheckBoxP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 471, -1, -1));

        buttonGroup.add(jCheckBoxP13);
        panelCuenta.add(jCheckBoxP13, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 545, -1, -1));

        buttonGroup.add(jCheckBoxP14);
        panelCuenta.add(jCheckBoxP14, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 618, -1, -1));

        jBCalendario.setBackground(new java.awt.Color(249, 251, 255));
        jBCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/calendario.png"))); // NOI18N
        jBCalendario.setBorderPainted(false);
        jBCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalendarioActionPerformed(evt);
            }
        });
        panelCuenta.add(jBCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, 40));

        jtFecha.setBackground(new java.awt.Color(249, 251, 255));
        jtFecha.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jtFecha.setForeground(new java.awt.Color(39, 59, 244));
        panelCuenta.add(jtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 150, -1));

        jbCancelar.setBackground(new java.awt.Color(255, 3, 3));
        jbCancelar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("Boton hace la reserva");
        jbCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCancelar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        panelCuenta.add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 690, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   /**
     * Evento se le pasa el panel de Reserva para mostralo.
     *
     * @param evt
     */
    private void jbreservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbreservarActionPerformed

        Reserva reserva = new Reserva(usuarios);
        mostrarPanel2(reserva);
    }//GEN-LAST:event_jbreservarActionPerformed

    private void jBCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalendarioActionPerformed
        // Crear un JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(new Date()); // Fecha inicial

        // Mostrar el calendario en un cuadro de diálogo
        int opcion = JOptionPane.showConfirmDialog(this, dateChooser, "Selecciona una fecha",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Procesar la fecha seleccionada
        if (opcion == JOptionPane.OK_OPTION) {
            Date fecha = dateChooser.getDate();
            if (fecha != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                jtFecha.setText(sdf.format(fecha));
            }
        }
    }//GEN-LAST:event_jBCalendarioActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // Crea una instancia de InicioCuenta
        InicioCuenta ic = new InicioCuenta(usuarios);
        // Muestra la ventana InicioCuenta
        mostrarPanel(ic);

    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Metodo elimna el panel actual y muestra el que se le pasa
     *
     * @param panel
     */
    private void mostrarPanel(InicioCuenta panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);

        panelCuenta.removeAll();
        panelCuenta.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelCuenta.revalidate();
        panelCuenta.repaint();

    }

    /**
     * Metodo elimna el panel actual y muestra el que se le pasa
     *
     * @param panel
     */
    private void mostrarPanel2(Reserva panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);

        panelCuenta.removeAll();
        panelCuenta.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelCuenta.revalidate();
        panelCuenta.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField P01;
    private javax.swing.JTextField P02;
    private javax.swing.JTextField P03;
    private javax.swing.JTextField P04;
    private javax.swing.JTextField P05;
    private javax.swing.JTextField P06;
    private javax.swing.JTextField P07;
    private javax.swing.JTextField P08;
    private javax.swing.JTextField P09;
    private javax.swing.JTextField P10;
    private javax.swing.JTextField P11;
    private javax.swing.JTextField P12;
    private javax.swing.JTextField P13;
    private javax.swing.JTextField P14;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jBCalendario;
    private javax.swing.JCheckBox jCheckBoxP1;
    private javax.swing.JCheckBox jCheckBoxP10;
    private javax.swing.JCheckBox jCheckBoxP11;
    private javax.swing.JCheckBox jCheckBoxP12;
    private javax.swing.JCheckBox jCheckBoxP13;
    private javax.swing.JCheckBox jCheckBoxP14;
    private javax.swing.JCheckBox jCheckBoxP2;
    private javax.swing.JCheckBox jCheckBoxP3;
    private javax.swing.JCheckBox jCheckBoxP4;
    private javax.swing.JCheckBox jCheckBoxP5;
    private javax.swing.JCheckBox jCheckBoxP6;
    private javax.swing.JCheckBox jCheckBoxP7;
    private javax.swing.JCheckBox jCheckBoxP8;
    private javax.swing.JCheckBox jCheckBoxP9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbreservar;
    private javax.swing.JLabel jlentrada;
    private javax.swing.JLabel jlreservar;
    private javax.swing.JLabel jlsalida;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JLabel jltitulo3;
    private javax.swing.JTextField jtFecha;
    private vista.PanelRound panelCuenta;
    private vista.PanelRound panelRoundP1;
    private vista.PanelRound panelRoundP10;
    private vista.PanelRound panelRoundP11;
    private vista.PanelRound panelRoundP12;
    private vista.PanelRound panelRoundP13;
    private vista.PanelRound panelRoundP14;
    private vista.PanelRound panelRoundP2;
    private vista.PanelRound panelRoundP3;
    private vista.PanelRound panelRoundP4;
    private vista.PanelRound panelRoundP5;
    private vista.PanelRound panelRoundP6;
    private vista.PanelRound panelRoundP7;
    private vista.PanelRound panelRoundP8;
    private vista.PanelRound panelRoundP9;
    // End of variables declaration//GEN-END:variables

}
