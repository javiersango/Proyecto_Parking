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
import modelo.Vehiculos;





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


    /**
     * Creates new form RegistroCuenta
     */
    public Parking(Usuarios usuarios) {
        this.usuarios = usuarios;
        initComponents();

        // Poner jTexfield y jBotton el radio
        jbreservar.putClientProperty("FlatLaf.style", "arc: 15");
        jbcancelar.putClientProperty("FlatLaf.style", "arc: 15");
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
        jbcancelar = new javax.swing.JButton();
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

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelCuenta.setBackground(new java.awt.Color(249, 251, 255));
        panelCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        panelCuenta.setPreferredSize(new java.awt.Dimension(428, 800));
        panelCuenta.setRoundBottomLeft(30);
        panelCuenta.setRoundBottomRight(30);

        jlreservar.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jlreservar.setForeground(new java.awt.Color(39, 59, 244));
        jlreservar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlreservar.setText("RESERVAR PLAZA");
        jlreservar.setPreferredSize(new java.awt.Dimension(273, 30));

        jltitulo2.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(51, 51, 51));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo2.setText("Quiere reservar?.");
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));

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

        jltitulo3.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo3.setForeground(new java.awt.Color(25, 35, 66));
        jltitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo3.setText(" Seleccione una plaza ");
        jltitulo3.setPreferredSize(new java.awt.Dimension(273, 30));

        jbcancelar.setBackground(new java.awt.Color(255, 3, 3));
        jbcancelar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbcancelar.setText("Carcelar");
        jbcancelar.setToolTipText("Boton salimos de esta pantalla");
        jbcancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbcancelar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

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

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        jlentrada.setForeground(new java.awt.Color(0, 0, 0));
        jlentrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlentrada.setText("ENTRADA");

        jlsalida.setForeground(new java.awt.Color(0, 0, 0));
        jlsalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlsalida.setText("SALIDA");

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator18.setForeground(new java.awt.Color(0, 0, 0));

        buttonGroup.add(jCheckBoxP1);

        buttonGroup.add(jCheckBoxP2);
        jCheckBoxP2.setSelected(true);

        buttonGroup.add(jCheckBoxP3);

        buttonGroup.add(jCheckBoxP4);

        buttonGroup.add(jCheckBoxP5);

        buttonGroup.add(jCheckBoxP6);

        buttonGroup.add(jCheckBoxP7);

        buttonGroup.add(jCheckBoxP8);

        buttonGroup.add(jCheckBoxP9);

        buttonGroup.add(jCheckBoxP10);

        buttonGroup.add(jCheckBoxP11);

        buttonGroup.add(jCheckBoxP12);

        buttonGroup.add(jCheckBoxP13);

        buttonGroup.add(jCheckBoxP14);

        javax.swing.GroupLayout panelCuentaLayout = new javax.swing.GroupLayout(panelCuenta);
        panelCuenta.setLayout(panelCuentaLayout);
        panelCuentaLayout.setHorizontalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlreservar, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jltitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelRoundP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxP3)
                        .addGap(155, 155, 155)
                        .addComponent(jCheckBoxP10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRoundP10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelRoundP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxP4)
                        .addGap(155, 155, 155)
                        .addComponent(jCheckBoxP11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRoundP11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelRoundP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxP5)
                        .addGap(155, 155, 155)
                        .addComponent(jCheckBoxP12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRoundP12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelRoundP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxP6)
                        .addGap(155, 155, 155)
                        .addComponent(jCheckBoxP13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRoundP13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelRoundP7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxP7)
                        .addGap(155, 155, 155)
                        .addComponent(jCheckBoxP14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRoundP14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addComponent(panelRoundP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxP2)
                                    .addComponent(jCheckBoxP1)))
                            .addComponent(panelRoundP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addComponent(jCheckBoxP8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRoundP8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addComponent(jCheckBoxP9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRoundP9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jbreservar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        panelCuentaLayout.setVerticalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlreservar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuentaLayout.createSequentialGroup()
                        .addComponent(jltitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlentrada, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundP8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxP8)
                            .addComponent(jCheckBoxP1))))
                .addGap(12, 12, 12)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundP9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jCheckBoxP2))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxP9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jCheckBoxP3))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxP10))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundP10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundP11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jCheckBoxP4))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxP11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundP12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jCheckBoxP5))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxP12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundP13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxP13)
                            .addComponent(jCheckBoxP6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundP7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundP14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxP7)
                                    .addComponent(jCheckBoxP14))))
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuentaLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jbreservar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jlsalida)))
                .addGap(0, 56, Short.MAX_VALUE))
        );

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
     * Evento se le pasa el panel de IncioCuenta para mostralo.
     *
     * @param evt
     */
    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed

        // Crea una instancia de InicioCuenta
        InicioCuenta ic = new InicioCuenta(usuarios);
        // Muestra la ventana InicioCuenta
        mostrarPanel(ic);
    }//GEN-LAST:event_jbcancelarActionPerformed
    /**
     * Evento se le pasa el panel de Reserva para mostralo.
     *
     * @param evt
     */
    private void jbreservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbreservarActionPerformed

        Reserva reserva = new Reserva(usuarios);
        mostrarPanel2(reserva);
    }//GEN-LAST:event_jbreservarActionPerformed
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
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbreservar;
    private javax.swing.JLabel jlentrada;
    private javax.swing.JLabel jlreservar;
    private javax.swing.JLabel jlsalida;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JLabel jltitulo3;
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
