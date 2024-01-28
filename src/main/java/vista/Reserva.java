/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.JOptionPane;
import controlador.MetodosContrasena;
import controlador.MetodosRegistroCuenta;
import javax.swing.JPanel;
import vista.InicioCuenta;

/**
 *
 * @author Javier
 */
public class Reserva extends javax.swing.JPanel {

    // Variables
    private boolean esCoche;
    private String nombre;
    private String apellidos;
    private String matricula;
    private String email;
    private String contrasena;
    private  String repetirContrasena;
   
    MetodosRegistroCuenta mrc = new MetodosRegistroCuenta();
 
    /**
     * Creates new form RegistroCuenta
     */
    public Reserva() {
        initComponents();
        
        // Poner jTexfield y jBotton el radio
    
        jtmatricula.putClientProperty("FlatLaf.style","arc: 15");
      
        
     
 
        jltitulo1.putClientProperty("FlatLaf.styleClass", "h1");
        jltitulo2.putClientProperty("FlatLaf.styleClass", "h3");
        //jlvolver.putClientProperty("FlatLaf.styleClass", "h3");
   
        
      
        // añadir a los jTextField iconos
        jtcoche.putClientProperty( FlatClientProperties.TEXT_FIELD_LEADING_ICON,new FlatSVGIcon( "img/usuario.svg" ) );
        jtmatricula.putClientProperty( FlatClientProperties.TEXT_FIELD_LEADING_ICON,new FlatSVGIcon( "img/apellidos.svg" ) );
        jtplaza.putClientProperty( FlatClientProperties.TEXT_FIELD_LEADING_ICON,new FlatSVGIcon( "img/email.svg" ) );
        
        jtmatricula.putClientProperty( FlatClientProperties.TEXT_FIELD_LEADING_ICON,new FlatSVGIcon( "img/matricula.svg" ) );

       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrupovehiculos = new javax.swing.ButtonGroup();
        panelRoundFondo = new vista.PanelRound();
        jlnombre1 = new javax.swing.JLabel();
        jltitulo1 = new javax.swing.JLabel();
        jltitulo2 = new javax.swing.JLabel();
        jPdatosReserva = new javax.swing.JPanel();
        jtcoche = new javax.swing.JTextField();
        jtplaza = new javax.swing.JTextField();
        jtmatricula = new javax.swing.JTextField();
        jlnombre2 = new javax.swing.JLabel();
        jlnombre3 = new javax.swing.JLabel();
        jlnombre4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jlnombre5 = new javax.swing.JLabel();
        jtplaza2 = new javax.swing.JTextField();
        jbConfirmar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jbcancelar1 = new javax.swing.JButton();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelRoundFondo.setBackground(new java.awt.Color(249, 251, 255));
        panelRoundFondo.setMaximumSize(null);
        panelRoundFondo.setPreferredSize(new java.awt.Dimension(428, 800));
        panelRoundFondo.setRoundBottomLeft(30);
        panelRoundFondo.setRoundBottomRight(30);

        jlnombre1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre1.setForeground(new java.awt.Color(0, 0, 0));
        jlnombre1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre1.setText("Tiempo duración");
        jlnombre1.setToolTipText("");
        jlnombre1.setPreferredSize(new java.awt.Dimension(51, 17));

        jltitulo1.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jltitulo1.setForeground(new java.awt.Color(39, 59, 244));
        jltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo1.setText("DATOS RESERVA");
        jltitulo1.setPreferredSize(new java.awt.Dimension(273, 30));

        jltitulo2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(25, 35, 66));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jltitulo2.setText("Detalle plaza reservada.");
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));

        jPdatosReserva.setBackground(new java.awt.Color(198, 212, 255));
        jPdatosReserva.setForeground(new java.awt.Color(198, 212, 255));
        jPdatosReserva.setPreferredSize(new java.awt.Dimension(335, 82));

        jtcoche.setBackground(new java.awt.Color(198, 212, 255));
        jtcoche.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtcoche.setForeground(new java.awt.Color(153, 153, 153));
        jtcoche.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtcoche.setText("COCHE");
        jtcoche.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtcoche.setPreferredSize(new java.awt.Dimension(335, 50));

        jtplaza.setBackground(new java.awt.Color(198, 212, 255));
        jtplaza.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtplaza.setForeground(new java.awt.Color(153, 153, 153));
        jtplaza.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtplaza.setText("P01");
        jtplaza.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtplaza.setPreferredSize(new java.awt.Dimension(335, 50));

        jtmatricula.setBackground(new java.awt.Color(198, 212, 255));
        jtmatricula.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtmatricula.setForeground(new java.awt.Color(153, 153, 153));
        jtmatricula.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtmatricula.setText("matricula");
        jtmatricula.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtmatricula.setPreferredSize(new java.awt.Dimension(335, 50));

        jlnombre2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre2.setForeground(new java.awt.Color(153, 153, 153));
        jlnombre2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre2.setText("Matricula");
        jlnombre2.setToolTipText("");
        jlnombre2.setPreferredSize(new java.awt.Dimension(51, 17));

        jlnombre3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre3.setForeground(new java.awt.Color(153, 153, 153));
        jlnombre3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre3.setText("Tipo de vehiculo");
        jlnombre3.setToolTipText("");
        jlnombre3.setPreferredSize(new java.awt.Dimension(51, 17));

        jlnombre4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre4.setForeground(new java.awt.Color(153, 153, 153));
        jlnombre4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre4.setText("Plaza de aparcamiento");
        jlnombre4.setToolTipText("");
        jlnombre4.setPreferredSize(new java.awt.Dimension(51, 17));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(39, 59, 244));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 9, 50));

        jlnombre5.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre5.setForeground(new java.awt.Color(153, 153, 153));
        jlnombre5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre5.setText("TOTAL");
        jlnombre5.setToolTipText("");
        jlnombre5.setPreferredSize(new java.awt.Dimension(51, 17));
        jPanel1.add(jlnombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jtplaza2.setBackground(new java.awt.Color(153, 204, 255));
        jtplaza2.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtplaza2.setForeground(new java.awt.Color(0, 0, 0));
        jtplaza2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtplaza2.setText("00");
        jtplaza2.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtplaza2.setPreferredSize(new java.awt.Dimension(335, 50));
        jtplaza2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtplaza2MousePressed(evt);
            }
        });
        jPanel1.add(jtplaza2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 130, 40));

        javax.swing.GroupLayout jPdatosReservaLayout = new javax.swing.GroupLayout(jPdatosReserva);
        jPdatosReserva.setLayout(jPdatosReservaLayout);
        jPdatosReservaLayout.setHorizontalGroup(
            jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtcoche, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jtplaza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPdatosReservaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jlnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPdatosReservaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPdatosReservaLayout.setVerticalGroup(
            jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPdatosReservaLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPdatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtcoche, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jtplaza, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbConfirmar.setBackground(new java.awt.Color(43, 220, 61));
        jbConfirmar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jbConfirmar.setText("Confirmar y pagar");
        jbConfirmar.setToolTipText("Boton cofirmar el pago");
        jbConfirmar.setPreferredSize(new java.awt.Dimension(124, 49));

        jbcancelar.setBackground(new java.awt.Color(39, 59, 244));
        jbcancelar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/calendario.png"))); // NOI18N
        jbcancelar.setToolTipText("Boton muesetra el calendario para selecicionar fecha");
        jbcancelar.setPreferredSize(new java.awt.Dimension(124, 49));

        jSlider1.setMajorTickSpacing(24);
        jSlider1.setMaximum(24);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("Selecciona la horas que quieres reservar la plaza");

        jbcancelar1.setBackground(new java.awt.Color(255, 3, 3));
        jbcancelar1.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcancelar1.setForeground(new java.awt.Color(255, 255, 255));
        jbcancelar1.setText("Cancelar");
        jbcancelar1.setToolTipText("Boton cancela el pago y vuelve a la panta del parking");
        jbcancelar1.setPreferredSize(new java.awt.Dimension(124, 49));

        javax.swing.GroupLayout panelRoundFondoLayout = new javax.swing.GroupLayout(panelRoundFondo);
        panelRoundFondo.setLayout(panelRoundFondoLayout);
        panelRoundFondoLayout.setHorizontalGroup(
            panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jltitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRoundFondoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRoundFondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbcancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelRoundFondoLayout.createSequentialGroup()
                            .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPdatosReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelRoundFondoLayout.setVerticalGroup(
            panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundFondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPdatosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbConfirmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbcancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtplaza2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtplaza2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtplaza2MousePressed
     

    private void mostrarPanel(JPanel panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);
        panelRoundFondo.removeAll();
        panelRoundFondo.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelRoundFondo.revalidate();
        panelRoundFondo.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrupovehiculos;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPdatosReserva;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbcancelar1;
    private javax.swing.JLabel jlnombre1;
    private javax.swing.JLabel jlnombre2;
    private javax.swing.JLabel jlnombre3;
    private javax.swing.JLabel jlnombre4;
    private javax.swing.JLabel jlnombre5;
    private javax.swing.JLabel jltitulo1;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JTextField jtcoche;
    private javax.swing.JTextField jtmatricula;
    private javax.swing.JTextField jtplaza;
    private javax.swing.JTextField jtplaza2;
    private vista.PanelRound panelRoundFondo;
    // End of variables declaration//GEN-END:variables




}
