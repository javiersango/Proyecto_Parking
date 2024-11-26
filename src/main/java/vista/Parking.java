/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import modelo.Usuarios;
import modelo.Reservas;
import modelo.Vehiculos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JPanel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Javier Sánchez González
 */
public final class Parking extends javax.swing.JPanel {

    // Inicializacion variables
    private final Usuarios usuarios;
    private final Vehiculos vehiculos;
    private final Reservas reservas;
    private final int idVehiculo;

    private final Map<String, JTextField> plazasTextFields = new HashMap<>();
    private final Map<String, JCheckBox> plazasCheckBoxes = new HashMap<>();
    private final Map<String, Boolean> estadoPlazas = new HashMap<>();

    /**
     * Creates new form RegistroCuenta
     *
     * @param usuarios
     * @param vehiculos
     * @param reservas
     */
    public Parking(Usuarios usuarios, Vehiculos vehiculos, Reservas reservas) {

        initComponents();

        this.usuarios = usuarios;
        this.vehiculos = vehiculos;
        this.reservas = reservas;

        inicializarPlazas();
        inicializarListeners();

        // Poner jTexfield y jBotton el radio
        jbreservar.putClientProperty("FlatLaf.style", "arc: 15");
        jbCancelar.putClientProperty("FlatLaf.style", "arc: 15");
        panelRoundP1.putClientProperty("FlatLaf.style", "arc: 15");

        // jlreservar.putClientProperty("FlatLaf.styleClass", "h1");
        jltitulo2.putClientProperty("FlatLaf.styleClass", "h3");
        jltitulo3.putClientProperty("FlatLaf.styleClass", "h1");

        jlNombre.setText(usuarios.getNombre());

        idVehiculo = vehiculos.getId();
        System.out.println("id vehiculo " + idVehiculo);

    }

    public void actualizarPlazasDesdeBD() {
        // Configurar la conexión a la base de datos utilizando Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

        // Crea sesion 
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Iniciar una sesión
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Reservas> reservas = session.createQuery("FROM Reserva WHERE fechaReservada = CURRENT_DATE", Reservas.class).list();
            for (Reservas reser : reservas) {
                String plaza = "P" + String.format("%02d", reser.getNumeroPlaza());
                boolean reservada = reser.getReservada();
                estadoPlazas.put(plaza, reservada);
                actualizarEstadoPlaza(plaza);
            }
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    public void inicializarPlazas() {
        // Añadir JTextField y JCheckBox al mapa
        plazasTextFields.put("P01", P01);
        plazasTextFields.put("P02", P02);
        plazasTextFields.put("P03", P03);
        plazasTextFields.put("P04", P04);
        plazasTextFields.put("P05", P05);
        plazasTextFields.put("P06", P06);
        plazasTextFields.put("P07", P07);
        plazasTextFields.put("P08", P08);
        plazasTextFields.put("P09", P09);
        plazasTextFields.put("P010", P10);
        plazasTextFields.put("P011", P11);
        plazasTextFields.put("P012", P12);
        plazasTextFields.put("P013", P13);
        plazasTextFields.put("P014", P14);

        plazasCheckBoxes.put("P01", jCheckBoxP1);
        plazasCheckBoxes.put("P02", jCheckBoxP2);
        plazasCheckBoxes.put("P03", jCheckBoxP3);
        plazasCheckBoxes.put("P04", jCheckBoxP4);
        plazasCheckBoxes.put("P05", jCheckBoxP5);
        plazasCheckBoxes.put("P06", jCheckBoxP6);
        plazasCheckBoxes.put("P07", jCheckBoxP7);
        plazasCheckBoxes.put("P08", jCheckBoxP8);
        plazasCheckBoxes.put("P09", jCheckBoxP9);
        plazasCheckBoxes.put("P010", jCheckBoxP10);
        plazasCheckBoxes.put("P011", jCheckBoxP11);
        plazasCheckBoxes.put("P012", jCheckBoxP12);
        plazasCheckBoxes.put("P013", jCheckBoxP13);
        plazasCheckBoxes.put("P014", jCheckBoxP14);

        // Inicializar estados de las plazas como "Disponible"
        for (String plaza : plazasTextFields.keySet()) {
            estadoPlazas.put(plaza, false); // Disponible por defecto
            actualizarEstadoPlaza(plaza);
        }
    }

    /**
     * Configura los listeners para los JCheckBox de cada plaza.
     */
    public void inicializarListeners() {
        for (String plaza : plazasTextFields.keySet()) {
            JCheckBox checkBox = plazasCheckBoxes.get(plaza);

            if (checkBox != null) {
                checkBox.addItemListener(e -> {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        // Actualizar plaza seleccionada
                        String plazaSeleccionada = obtenerPlazaSeleccionada();
                        System.out.println("Plaza seleccionada: " + plazaSeleccionada);

                        // Cambiar colores y deseleccionar otras plazas
                        actualizarPlazaSeleccionada(plazaSeleccionada);
                    }
                });
            }
        }
    }

    /**
     * Actualiza el estado visual de una plaza en función de su disponibilidad.
     *
     * @param plaza Código de la plaza (ejemplo: "P01").
     */
    private void actualizarEstadoPlaza(String plaza) {
        // Obtener los componentes
        JCheckBox checkBox = plazasCheckBoxes.get(plaza);
        JTextField plazaTextField = plazasTextFields.get(plaza);

        // Verificar si la plaza existe 
        if (checkBox != null && plazaTextField != null) {
            boolean estaReservada = estadoPlazas.getOrDefault(plaza, false);
            if (estaReservada) {
                // Si la plaza está reservada
                plazaTextField.setText("Reservada");
                plazaTextField.setEditable(false);
                plazaTextField.setBackground(Color.RED); // Color rojo para reservado
                plazaTextField.setForeground(Color.BLACK);
                checkBox.setSelected(true); // Marca el checkbox
                checkBox.setEnabled(false); // Deshabilita el checkbox
            } else {
                // Si la plaza está disponible
                plazaTextField.setText("Disponible");
                plazaTextField.setEditable(true);
                plazaTextField.setBackground(Color.GREEN); // Color verde para disponible
                plazaTextField.setForeground(Color.BLACK);
                checkBox.setSelected(false); // Desmarca el checkbox
                checkBox.setEnabled(true); // Habilita el checkbox
            }

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
        panelParking = new vista.PanelRound();
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
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
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
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jlNombre = new javax.swing.JLabel();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelParking.setBackground(new java.awt.Color(249, 251, 255));
        panelParking.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        panelParking.setPreferredSize(new java.awt.Dimension(428, 800));
        panelParking.setRoundBottomLeft(30);
        panelParking.setRoundBottomRight(30);
        panelParking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlreservar.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jlreservar.setForeground(new java.awt.Color(39, 59, 244));
        jlreservar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlreservar.setText("RESERVAR PLAZA");
        jlreservar.setPreferredSize(new java.awt.Dimension(273, 30));
        panelParking.add(jlreservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 220, 34));

        jltitulo2.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(51, 51, 51));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo2.setText("Que dia?");
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));
        panelParking.add(jltitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 130, 19));

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
        panelParking.add(jbreservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));

        jltitulo3.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo3.setForeground(new java.awt.Color(25, 35, 66));
        jltitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo3.setText(" Seleccione una plaza ");
        jltitulo3.setPreferredSize(new java.awt.Dimension(273, 30));
        panelParking.add(jltitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 665, 193, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 384, 10));

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

        panelParking.add(panelRoundP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 163, -1, -1));

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

        panelParking.add(panelRoundP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 237, -1, -1));

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

        panelParking.add(panelRoundP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 311, -1, -1));

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

        panelParking.add(panelRoundP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 385, -1, -1));

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

        panelParking.add(panelRoundP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 459, -1, -1));

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

        panelParking.add(panelRoundP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 533, -1, -1));

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

        panelParking.add(panelRoundP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 607, -1, -1));

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

        panelParking.add(panelRoundP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 163, -1, -1));

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

        panelParking.add(panelRoundP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 237, -1, -1));

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

        panelParking.add(panelRoundP10, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 311, -1, -1));

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

        panelParking.add(panelRoundP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 385, -1, -1));

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

        panelParking.add(panelRoundP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 459, -1, -1));

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

        panelParking.add(panelRoundP13, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 533, -1, -1));

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

        panelParking.add(panelRoundP14, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 607, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 670, 171, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 150, 171, 10));

        jlentrada.setForeground(new java.awt.Color(0, 0, 0));
        jlentrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlentrada.setText("ENTRADA");
        panelParking.add(jlentrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 144, 76, -1));

        jlsalida.setForeground(new java.awt.Color(0, 0, 0));
        jlsalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlsalida.setText("SALIDA");
        panelParking.add(jlsalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 659, 76, -1));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 517, 124, 10));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 369, 124, 10));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 295, 124, 10));

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 221, 124, 10));

        buttonGroup.add(jCheckBoxP1);
        panelParking.add(jCheckBoxP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 178, -1, -1));

        buttonGroup.add(jCheckBoxP2);
        jCheckBoxP2.setSelected(true);
        panelParking.add(jCheckBoxP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 252, -1, -1));

        buttonGroup.add(jCheckBoxP3);
        panelParking.add(jCheckBoxP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 321, -1, -1));

        buttonGroup.add(jCheckBoxP4);
        panelParking.add(jCheckBoxP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 396, -1, -1));

        buttonGroup.add(jCheckBoxP5);
        panelParking.add(jCheckBoxP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 475, -1, -1));

        buttonGroup.add(jCheckBoxP6);
        panelParking.add(jCheckBoxP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 545, -1, -1));

        buttonGroup.add(jCheckBoxP7);
        panelParking.add(jCheckBoxP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 618, -1, -1));

        buttonGroup.add(jCheckBoxP8);
        panelParking.add(jCheckBoxP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 178, -1, -1));

        buttonGroup.add(jCheckBoxP9);
        panelParking.add(jCheckBoxP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 249, -1, -1));

        buttonGroup.add(jCheckBoxP10);
        panelParking.add(jCheckBoxP10, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 323, -1, -1));

        buttonGroup.add(jCheckBoxP11);
        panelParking.add(jCheckBoxP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 397, -1, -1));

        buttonGroup.add(jCheckBoxP12);
        panelParking.add(jCheckBoxP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 471, -1, -1));

        buttonGroup.add(jCheckBoxP13);
        panelParking.add(jCheckBoxP13, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 545, -1, -1));

        buttonGroup.add(jCheckBoxP14);
        panelParking.add(jCheckBoxP14, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 618, -1, -1));

        jBCalendario.setBackground(new java.awt.Color(249, 251, 255));
        jBCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/calendario.png"))); // NOI18N
        jBCalendario.setBorderPainted(false);
        jBCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalendarioActionPerformed(evt);
            }
        });
        panelParking.add(jBCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, 40));

        jtFecha.setBackground(new java.awt.Color(249, 251, 255));
        jtFecha.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jtFecha.setForeground(new java.awt.Color(39, 59, 244));
        jtFecha.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtFecha.setBorder(null);
        panelParking.add(jtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 150, -1));

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
        panelParking.add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 690, -1, -1));

        jSeparator19.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 668, 171, 20));

        jSeparator20.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 591, 124, 10));

        jSeparator21.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 590, 124, 10));

        jSeparator23.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 124, 10));

        jSeparator22.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 443, 124, 10));

        jSeparator25.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 447, 124, -1));

        jSeparator26.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 124, 10));

        jSeparator24.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 124, 10));

        jSeparator27.setForeground(new java.awt.Color(0, 0, 0));
        panelParking.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 124, 10));

        jlNombre.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(39, 59, 244));
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlNombre.setToolTipText("");
        jlNombre.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelParking.add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelParking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelParking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento se le pasa el panel de Reserva para mostralo.
     *
     * @param evt
     */
    private void jbreservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbreservarActionPerformed

        // Obtener la plaza seleccionada
    String plazaSeleccionada = obtenerPlazaSeleccionada();

    if (plazaSeleccionada == null || plazaSeleccionada.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una plaza antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar fecha
    String fechaTexto = jtFecha.getText();
    if (fechaTexto == null || fechaTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese una fecha antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        restaurarEstadoPlazas();
        return;
    }

    Date fecha;
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.parse(fechaTexto);
        if (fecha.before(new Date())) {
            JOptionPane.showMessageDialog(this, "La fecha no puede ser anterior al día actual.", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use 'yyyy-MM-dd'.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Comprobar disponibilidad de la plaza
    boolean plazaOcupada = estadoPlazas.getOrDefault(plazaSeleccionada, false);

    if (plazaOcupada) {
        JOptionPane.showMessageDialog(this, "La plaza seleccionada ya está reservada para este día, elija otro día.", "Plaza Ocupada", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Reservar plaza en la base de datos
    try {
        guardarOActualizarReservaEnBD(fecha, idVehiculo, plazaSeleccionada);
        estadoPlazas.put(plazaSeleccionada, true); // Actualizar estado
        actualizarEstadoPlaza(plazaSeleccionada);
        JOptionPane.showMessageDialog(this, "Reserva realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        Reserva reserva = new Reserva(usuarios, vehiculos, reservas, plazaSeleccionada, fecha);
        mostrarPanel(reserva);
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al realizar la reserva. Inténtelo nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_jbreservarActionPerformed

    
    private void restaurarEstadoPlazas() {
    for (String plaza : plazasCheckBoxes.keySet()) {
        plazasCheckBoxes.get(plaza).setSelected(false);
        plazasTextFields.get(plaza).setBackground(Color.GREEN);
    }
}

    private void jBCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalendarioActionPerformed
        // Crear un JDateChooser para seleccionar la fecha
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(new Date()); // Fecha actual

        // Mostrar el diálogo para seleccionar una fecha
        int opcion = JOptionPane.showConfirmDialog(this, dateChooser, "Selecciona una fecha",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario hace clic en OK
        if (opcion == JOptionPane.OK_OPTION) {
            Date fecha = dateChooser.getDate();

            if (fecha != null) {
                // Validar que la fecha 
                if (fecha.before(new Date())) {
                    JOptionPane.showMessageDialog(this, "La fecha seleccionada no puede anterior a la fecha Actual.",
                            "Fecha no válida", JOptionPane.WARNING_MESSAGE);
                    return;  // Salir sin hacer nada si la fecha es futura
                }

                // Mostrar la fecha seleccionada en el campo de texto
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                jtFecha.setText(formato.format(fecha));

                // Limpiar el estado de las plazas antes de actualizarlo con la nueva fecha
                inicializarPlazas();

                // Llamar al método que actualiza el estado de las plazas basado en la fecha seleccionada
                try {
                    actualizarPlazasPorFecha(fecha);
                } catch (Exception e) {
                    System.out.println("Error al actualizar las plazas: " + e.getMessage());
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Hubo un error al actualizar las plazas. Inténtalo de nuevo.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha válida.",
                        "Fecha no válida", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBCalendarioActionPerformed

    private String obtenerPlazaSeleccionada() {
        for (String plaza : plazasTextFields.keySet()) {
            JTextField plazaTextField = plazasTextFields.get(plaza);
            JCheckBox plazaCheckBox = plazasCheckBoxes.get(plaza);

            // Verificar si el campo está disponible para selección
            if (plazaCheckBox != null && plazaTextField != null) {
                if (plazaCheckBox.isSelected()) {
                    return plaza; // Retorna la primera plaza seleccionada
                }
            }
        }

        return null; // Si no hay selección, retorna null
    }

    private void actualizarPlazaSeleccionada(String plazaSeleccionada) {
    for (String plaza : plazasTextFields.keySet()) {
        JTextField plazaTextField = plazasTextFields.get(plaza);
        JCheckBox checkBox = plazasCheckBoxes.get(plaza);

        if (plazaTextField != null && checkBox != null) {
            if (plaza.equals(plazaSeleccionada)) {
                // Mantener la plaza seleccionada en rojo (ocupada)
                plazaTextField.setBackground(Color.RED);
                checkBox.setSelected(true);
            } else {
                // Restaurar el color dependiendo del estado de la plaza
                if (estadoPlazas.getOrDefault(plaza, false)) {
                    // Si está ocupada, marcar como roja
                    plazaTextField.setBackground(Color.RED);
                } else {
                    // Si está disponible, restaurar como verde
                    plazaTextField.setBackground(Color.GREEN);
                }
                checkBox.setSelected(false);
            }
        }
    }
}


    private void actualizarPlazasPorFecha(Date fecha) {
        // Configurar la conexión a la base de datos utilizando Hibernate
        try {
            // Crear la sesión de Hibernate
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml"); // Ubicación de la configuración

            // Crear la sesión factory
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Iniciar una sesión
            try (Session sesion = sessionFactory.openSession()) {
                Transaction transaction = sesion.beginTransaction();

                // Crear la consulta para obtener las reservas para la fecha seleccionada
                String hql = "FROM Reservas WHERE fechaReservada = :fecha";
                Query<Reservas> query = sesion.createQuery(hql, Reservas.class);
                query.setParameter("fecha", fecha); // Establecer la fecha seleccionada en la consulta

                List<Reservas> reservas = query.list();
                for (Reservas reser : reservas) {
                    String plaza = "P" + String.format("%02d", reser.getNumeroPlaza());
                    boolean reservada = reser.getReservada();
                    estadoPlazas.put(plaza, reservada);
                    actualizarEstadoPlaza(plaza);
                }

                // Confirmar la transacción
                transaction.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void guardarOActualizarReservaEnBD( Date fecha, int idVehiculo, String plazaSeleccionada) {
        SessionFactory sessionFactory = null;
        System.out.println("numero plaza seleccionada " + plazaSeleccionada);
        // Crear la configuración y la sesión de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Archivo de configuración de Hibernate
        sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            Transaction transaction = session.beginTransaction();

            try {
                // Convertir el número de plaza (Ejemplo: "P01" -> 1)
                int numeroPlaza = Integer.parseInt(plazaSeleccionada.substring(1));
                System.out.println("numero plaza seleccionada " + numeroPlaza);

                // Comprobar si ya existe una reserva para la plaza y el vehículo
                String hql = "FROM Reservas r WHERE r.numeroPlaza = :numeroPlaza AND r.vehiculos.id = :idVehiculo";
                Query<Reservas> checkQuery = session.createQuery(hql, Reservas.class);
                checkQuery.setParameter("numeroPlaza", numeroPlaza);
                checkQuery.setParameter("idVehiculo", idVehiculo);

                List<Reservas> reservasExistentes = checkQuery.list();

                if (!reservasExistentes.isEmpty()) {
                    // Actualizar reserva existente
                    Reservas reservaExistente = reservasExistentes.get(0);
                    reservaExistente.setReservada(true);
                    reservaExistente.setFechaReservada(new java.sql.Date(fecha.getTime()));
                    session.update(reservaExistente);
                    System.out.println("Reserva de la plaza " + plazaSeleccionada + " actualizada con éxito.");
                } else {
                    // Crear nueva reserva
                    Reservas nuevaReserva = new Reservas();
                    nuevaReserva.setNumeroPlaza(numeroPlaza);
                    nuevaReserva.setReservada(true);
                    nuevaReserva.setFechaReservada(new java.sql.Date(fecha.getTime()));

                    // Vincular el vehículo existente
                    Vehiculos vehiculo = session.get(Vehiculos.class, idVehiculo);
                    if (vehiculo == null) {
                        throw new IllegalArgumentException("El vehículo con ID " + idVehiculo + " no existe.");
                    }
                    nuevaReserva.setVehiculos(vehiculo);
                    session.save(nuevaReserva);
                    System.out.println("Reserva de la plaza " + plazaSeleccionada + " creada con éxito.");
                }

                // Confirmar la transacción
                transaction.commit();
            } catch (IllegalArgumentException e) {
                // En caso de error, revertir la transacción
                if (transaction != null) {
                    transaction.rollback();
                }
                throw e; // Relanzar la excepción para manejarla externamente
            }
        } catch (NumberFormatException e) {
            System.out.println("Error de formato en el número de plaza: " + plazaSeleccionada);
            e.printStackTrace();
        } catch (HibernateException e) {
            System.out.println("Error con Hibernate: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean existeReserva(String numeroPlaza, Date fecha) {

        SessionFactory sessionFactory = null;

        // Crear la configuración y la sesión de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Archivo de configuración de Hibernate
        sessionFactory = configuration.buildSessionFactory();

        // Abrir sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar la transacción

            try {
                String hql = "SELECT COUNT(r) FROM Reserva r WHERE r.numeroPlaza = :numeroPlaza AND r.fecha = :fecha";
                Query query = session.createQuery(hql);
                query.setParameter("numeroPlaza", numeroPlaza);
                query.setParameter("fecha", fecha);
                Long count = (Long) query.uniqueResult();
                return count > 0; // Retorna true si ya existe un registro
            } finally {
                session.close();
            }
        }

    }

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // Crea una instancia de InicioCuenta
        InicioCuenta ic = new InicioCuenta(usuarios, vehiculos);
        // Muestra la ventana InicioCuenta
        mostrarPanel(ic);

    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Metodo elimna el panel actual y muestra el que se le pasa
     *
     * @param panel
     */
    public void mostrarPanel(JPanel panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);

        panelParking.removeAll();
        panelParking.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelParking.revalidate();
        panelParking.repaint();
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
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbreservar;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlentrada;
    private javax.swing.JLabel jlreservar;
    private javax.swing.JLabel jlsalida;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JLabel jltitulo3;
    private javax.swing.JTextField jtFecha;
    private vista.PanelRound panelParking;
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
