/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Usuarios;
import modelo.Vehiculos;
import modelo.Reservas;

/**
 *
 * @author Javier Sanchez Gonzalez
 */
public class Reserva extends javax.swing.JPanel {

    private final double precioPorHora = 0.25;
    private int horas;
    private int numPlaza;
    private final Date fecha;
    private final boolean coche;
    private double total = 0.0f;
    private final Usuarios usuarios;
    private final Vehiculos vehiculos;
    private final Reservas reservas;

    /**
     * Creates new form RegistroCuenta
     *
     * @param usuarios
     * @param vehiculos
     * @param plaza
     * @param fecha
     */
    public Reserva(Usuarios usuarios, Vehiculos vehiculos,Reservas reservas, String plaza, Date fecha) {
        this.usuarios = usuarios;
        this.vehiculos = vehiculos;
        this.reservas = null;

        this.fecha = fecha;

        initComponents();
        // Poner jTexfield y jBotton el radio
        jbPagar.putClientProperty("FlatLaf.style", "arc: 15");
        jbcancelar.putClientProperty("FlatLaf.style", "arc: 15");
        jPdatosReserva.putClientProperty("FlatLaf.style", "arc: 15");
        // añadir a los jTextField iconos
        jtcoche.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/apellidos.svg"));
        jtmatricula.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/apellidos.svg"));
        jtplaza.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/apellidos.svg"));
        coche = vehiculos.getEsCoche();
        if (coche) {
            jtcoche.setText("Coche");
        } else {
            jtcoche.setText("Moto");
        }
        jtmatricula.setText(vehiculos.getMatricula());
        numPlaza = reservas.getNumeroPlaza();
        jtplaza.setText("P" + plaza);
        //Obtener la fecha reservada
        Date fechaReserva = reservas.getFechaReservada();
        System.out.println("fecha " + fechaReserva.toString());
        SimpleDateFormat formateada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        String fechaFormateada = formateada.format(fechaReserva);
        jlFecha.setText(fechaFormateada);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTiket = new javax.swing.JPanel();
        jltituloReserva = new javax.swing.JLabel();
        jlTiempo = new javax.swing.JLabel();
        jSliderTiempo = new javax.swing.JSlider();
        jPdatosReserva = new javax.swing.JPanel();
        jtcoche = new javax.swing.JTextField();
        jtplaza = new javax.swing.JTextField();
        jtmatricula = new javax.swing.JTextField();
        jlnombre2 = new javax.swing.JLabel();
        jlnombre3 = new javax.swing.JLabel();
        jltiempo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jlnombre5 = new javax.swing.JLabel();
        jttotal = new javax.swing.JTextField();
        jTexthora = new javax.swing.JTextField();
        jlFecha = new javax.swing.JLabel();
        jlnombre7 = new javax.swing.JLabel();
        jbPagar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jltitulo4 = new javax.swing.JLabel();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        jPanelTiket.setBackground(new java.awt.Color(249, 251, 255));
        jPanelTiket.setMaximumSize(null);
        jPanelTiket.setPreferredSize(new java.awt.Dimension(430, 800));

        jltituloReserva.setBackground(new java.awt.Color(249, 251, 255));
        jltituloReserva.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jltituloReserva.setForeground(new java.awt.Color(39, 59, 244));
        jltituloReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltituloReserva.setText("DETALLE PLAZA RESERVADA");
        jltituloReserva.setPreferredSize(new java.awt.Dimension(273, 30));

        jlTiempo.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlTiempo.setForeground(new java.awt.Color(0, 0, 0));
        jlTiempo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlTiempo.setText("Tiempo duración");
        jlTiempo.setToolTipText("");
        jlTiempo.setPreferredSize(new java.awt.Dimension(51, 17));

        jSliderTiempo.setBackground(new java.awt.Color(39, 59, 244));
        jSliderTiempo.setForeground(new java.awt.Color(0, 0, 0));
        jSliderTiempo.setMaximum(24);
        jSliderTiempo.setMinorTickSpacing(1);
        jSliderTiempo.setPaintLabels(true);
        jSliderTiempo.setPaintTicks(true);
        jSliderTiempo.setSnapToTicks(true);
        jSliderTiempo.setToolTipText("Selecciona la horas que quieres reservar la plaza");
        jSliderTiempo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderTiempoStateChanged(evt);
            }
        });

        jPdatosReserva.setBackground(new java.awt.Color(198, 212, 255));
        jPdatosReserva.setForeground(new java.awt.Color(198, 212, 255));
        jPdatosReserva.setPreferredSize(new java.awt.Dimension(335, 82));

        jtcoche.setBackground(new java.awt.Color(198, 212, 255));
        jtcoche.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtcoche.setForeground(new java.awt.Color(0, 0, 0));
        jtcoche.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtcoche.setText("vehiculo");
        jtcoche.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtcoche.setPreferredSize(new java.awt.Dimension(335, 50));

        jtplaza.setBackground(new java.awt.Color(198, 212, 255));
        jtplaza.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtplaza.setForeground(new java.awt.Color(0, 0, 0));
        jtplaza.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtplaza.setText("plaza");
        jtplaza.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtplaza.setPreferredSize(new java.awt.Dimension(335, 50));

        jtmatricula.setBackground(new java.awt.Color(198, 212, 255));
        jtmatricula.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtmatricula.setForeground(new java.awt.Color(0, 0, 0));
        jtmatricula.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtmatricula.setText("matricula");
        jtmatricula.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtmatricula.setPreferredSize(new java.awt.Dimension(335, 50));

        jlnombre2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre2.setForeground(new java.awt.Color(0, 0, 0));
        jlnombre2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre2.setText("Matricula");
        jlnombre2.setToolTipText("");
        jlnombre2.setPreferredSize(new java.awt.Dimension(51, 17));

        jlnombre3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre3.setForeground(new java.awt.Color(0, 0, 0));
        jlnombre3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre3.setText("Tipo de vehiculo");
        jlnombre3.setToolTipText("");
        jlnombre3.setPreferredSize(new java.awt.Dimension(51, 17));

        jltiempo.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jltiempo.setForeground(new java.awt.Color(0, 0, 0));
        jltiempo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jltiempo.setText("Tiempo");
        jltiempo.setToolTipText("");
        jltiempo.setPreferredSize(new java.awt.Dimension(51, 17));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(39, 59, 244));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 9, 50));

        jlnombre5.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre5.setForeground(new java.awt.Color(0, 0, 0));
        jlnombre5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre5.setText("TOTAL");
        jlnombre5.setToolTipText("");
        jlnombre5.setPreferredSize(new java.awt.Dimension(51, 17));
        jPanel1.add(jlnombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jttotal.setBackground(new java.awt.Color(153, 204, 255));
        jttotal.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jttotal.setForeground(new java.awt.Color(0, 0, 0));
        jttotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jttotal.setText("00");
        jttotal.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jttotal.setPreferredSize(new java.awt.Dimension(335, 50));
        jPanel1.add(jttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 80, 40));

        jTexthora.setBackground(new java.awt.Color(198, 212, 255));
        jTexthora.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jTexthora.setForeground(new java.awt.Color(0, 0, 0));
        jTexthora.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTexthora.setText("0");

        jlFecha.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(0, 0, 0));
        jlFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlFecha.setToolTipText("");
        jlFecha.setPreferredSize(new java.awt.Dimension(51, 17));

        jlnombre7.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre7.setForeground(new java.awt.Color(0, 0, 0));
        jlnombre7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre7.setText("Plaza de aparcamiento");
        jlnombre7.setToolTipText("");
        jlnombre7.setPreferredSize(new java.awt.Dimension(51, 17));

        javax.swing.GroupLayout jPdatosReservaLayout = new javax.swing.GroupLayout(jPdatosReserva);
        jPdatosReserva.setLayout(jPdatosReservaLayout);
        jPdatosReservaLayout.setHorizontalGroup(
            jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPdatosReservaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPdatosReservaLayout.createSequentialGroup()
                        .addComponent(jlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPdatosReservaLayout.createSequentialGroup()
                        .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPdatosReservaLayout.createSequentialGroup()
                                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtcoche, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtplaza, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosReservaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosReservaLayout.createSequentialGroup()
                                    .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlnombre2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtmatricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosReservaLayout.createSequentialGroup()
                                    .addComponent(jTexthora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)))
                            .addComponent(jltiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPdatosReservaLayout.setVerticalGroup(
            jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPdatosReservaLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtcoche, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlnombre7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jltiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtplaza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexthora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbPagar.setBackground(new java.awt.Color(43, 220, 61));
        jbPagar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbPagar.setForeground(new java.awt.Color(255, 255, 255));
        jbPagar.setText(" Pagar");
        jbPagar.setToolTipText("Boton cofirmar el pago");
        jbPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbPagar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarActionPerformed(evt);
            }
        });

        jbcancelar.setBackground(new java.awt.Color(255, 3, 3));
        jbcancelar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbcancelar.setText("Cancelar");
        jbcancelar.setToolTipText("Boton cancela el pago y vuelve a la panta del parking");
        jbcancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbcancelar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        jltitulo4.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo4.setForeground(new java.awt.Color(51, 51, 51));
        jltitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo4.setText("Tiket reserva plaza");
        jltitulo4.setPreferredSize(new java.awt.Dimension(273, 30));

        javax.swing.GroupLayout jPanelTiketLayout = new javax.swing.GroupLayout(jPanelTiket);
        jPanelTiket.setLayout(jPanelTiketLayout);
        jPanelTiketLayout.setHorizontalGroup(
            jPanelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jltituloReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTiketLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jltitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanelTiketLayout.createSequentialGroup()
                .addGroup(jPanelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelTiketLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jPdatosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelTiketLayout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jlTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSliderTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelTiketLayout.setVerticalGroup(
            jPanelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTiketLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jltituloReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jltitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSliderTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPdatosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento se le pasa el metodo MostrarPanel eliminando el actual y mostrando
     * el que se le pasa calculo de el tiempo de estacionamiento
     *
     * @param evt
     */
    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        Parking parking = new Parking(usuarios, vehiculos, reservas);
        mostrarPanel(parking);
    }//GEN-LAST:event_jbcancelarActionPerformed
    /**
     * Evento comprobacion que los campos no este vacios para cofirmar y pagar
     *
     * @param evt
     */
    private void jbPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarActionPerformed

        // Crear un JComboBox con los métodos de pago
        String[] opcionesPago = {"Bizum", "Visa", "PayPal"};
        JComboBox<String> comboBox = new JComboBox<>(opcionesPago);

        // Mostrar el cuadro de diálogo con el JComboBox
        int opcion = JOptionPane.showOptionDialog(
                this,
                comboBox,
                "Selecciona un método de pago",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Aceptar", "Cancelar"},
                "Aceptar"
        );

        // Si se ha seleccionado "Aceptar"
        if (opcion == 0) {
            String metodoPago = (String) comboBox.getSelectedItem(); // Obtén el método de pago seleccionado
            JOptionPane.showMessageDialog(this, "Método de pago seleccionado: " + metodoPago, "Pago seleccionado", JOptionPane.INFORMATION_MESSAGE);

            // Realiza las acciones correspondientes al método de pago seleccionado
            // Por ejemplo, podrías redirigir a una pasarela de pagos o proceder con el proceso
        } else {
            // Si el usuario seleccionó "Cancelar", mostrar un mensaje
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un método de pago.", "Cancelado", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jbPagarActionPerformed
    /**
     * Evento muestra en el campo texto horas segun la selecion del slider
     *
     * @param evt
     */
    private void jSliderTiempoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderTiempoStateChanged
        horas = jSliderTiempo.getValue();
        jTexthora.setText(String.valueOf(horas + "m"));
        jTexthora.setForeground(Color.black);
        total = (precioPorHora * horas);
        jttotal.setText(String.valueOf(total + "€"));

    }//GEN-LAST:event_jSliderTiempoStateChanged
    /**
     * Metodo elimna el panel actual y muestra el que se le pasa
     *
     * @param panel
     */
    private void mostrarPanel(JPanel panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);
        jPanelTiket.removeAll();
        jPanelTiket.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanelTiket.revalidate();
        jPanelTiket.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTiket;
    private javax.swing.JPanel jPdatosReserva;
    private javax.swing.JSlider jSliderTiempo;
    private javax.swing.JTextField jTexthora;
    private javax.swing.JButton jbPagar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlTiempo;
    private javax.swing.JLabel jlnombre2;
    private javax.swing.JLabel jlnombre3;
    private javax.swing.JLabel jlnombre5;
    private javax.swing.JLabel jlnombre7;
    private javax.swing.JLabel jltiempo;
    private javax.swing.JLabel jltitulo4;
    private javax.swing.JLabel jltituloReserva;
    private javax.swing.JTextField jtcoche;
    private javax.swing.JTextField jtmatricula;
    private javax.swing.JTextField jtplaza;
    private javax.swing.JTextField jttotal;
    // End of variables declaration//GEN-END:variables

}
