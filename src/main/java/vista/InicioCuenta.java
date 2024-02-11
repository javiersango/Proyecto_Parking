/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;


import javax.swing.JPanel;



/**
 *
 * @author Javier
 */
public class InicioCuenta extends javax.swing.JPanel {

    /**
     * Creates new form RegistroCuenta
     */
    public InicioCuenta() {
        initComponents();
        

        jbcuenta.putClientProperty("FlatLaf.style","arc: 15");
        jbreserva.putClientProperty("FlatLaf.style","arc: 15");
        jbhistorial.putClientProperty("FlatLaf.style","arc: 15");
        jbcancelar.putClientProperty("FlatLaf.style","arc: 15");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicioCuenta = new vista.PanelRound();
        jltitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbcuenta = new javax.swing.JButton();
        jbhistorial = new javax.swing.JButton();
        jbreserva = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelInicioCuenta.setBackground(new java.awt.Color(249, 251, 255));
        panelInicioCuenta.setMaximumSize(null);
        panelInicioCuenta.setPreferredSize(new java.awt.Dimension(428, 800));
        panelInicioCuenta.setRoundBottomLeft(30);
        panelInicioCuenta.setRoundBottomRight(30);

        jltitulo1.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jltitulo1.setForeground(new java.awt.Color(39, 59, 244));
        jltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo1.setText("¿Que desea hacer?");
        jltitulo1.setPreferredSize(new java.awt.Dimension(273, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/LogoParking.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jbcuenta.setBackground(new java.awt.Color(43, 220, 61));
        jbcuenta.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcuenta.setForeground(new java.awt.Color(255, 255, 255));
        jbcuenta.setText("Cuenta");
        jbcuenta.setToolTipText("Boton para modificar datos del usuario");
        jbcuenta.setPreferredSize(new java.awt.Dimension(124, 49));
        jbcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcuentaActionPerformed(evt);
            }
        });

        jbhistorial.setBackground(new java.awt.Color(43, 220, 61));
        jbhistorial.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbhistorial.setForeground(new java.awt.Color(255, 255, 255));
        jbhistorial.setText("Historial");
        jbhistorial.setToolTipText("Boton muestra historial de aparcamiento del usuario");
        jbhistorial.setPreferredSize(new java.awt.Dimension(124, 49));
        jbhistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbhistorialActionPerformed(evt);
            }
        });

        jbreserva.setBackground(new java.awt.Color(43, 220, 61));
        jbreserva.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbreserva.setForeground(new java.awt.Color(255, 255, 255));
        jbreserva.setText("Reservar");
        jbreserva.setToolTipText("Botón para reservar una plaza de aparcamiento");
        jbreserva.setPreferredSize(new java.awt.Dimension(124, 49));
        jbreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbreservaActionPerformed(evt);
            }
        });

        jbcancelar.setBackground(new java.awt.Color(255, 3, 3));
        jbcancelar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbcancelar.setText("Cancelar");
        jbcancelar.setToolTipText("Boton cancela operacion y regresa a la pantalla anterior");
        jbcancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbcancelar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInicioCuentaLayout = new javax.swing.GroupLayout(panelInicioCuenta);
        panelInicioCuenta.setLayout(panelInicioCuentaLayout);
        panelInicioCuentaLayout.setHorizontalGroup(
            panelInicioCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jltitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelInicioCuentaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioCuentaLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(panelInicioCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbhistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(jbreserva, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(jbcuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(jbcancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        panelInicioCuentaLayout.setVerticalGroup(
            panelInicioCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioCuentaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jbreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicioCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicioCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbhistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbhistorialActionPerformed
     Historiales panelHistorial = new Historiales();
        mostrarPanel(panelHistorial);
    }//GEN-LAST:event_jbhistorialActionPerformed

    private void jbcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcuentaActionPerformed
         Cuenta panelCuenta = new Cuenta();
         mostrarPanel(panelCuenta );
    }//GEN-LAST:event_jbcuentaActionPerformed

    private void jbreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbreservaActionPerformed
        Parking panelReserva = new Parking();
        mostrarPanel(panelReserva);
    }//GEN-LAST:event_jbreservaActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed

        // Crea una instancia de InicioCuenta
        InicioCuenta ic = new InicioCuenta();
        // Muestra la ventana InicioCuenta
        mostrarPanel(ic);

    }//GEN-LAST:event_jbcancelarActionPerformed

     private void mostrarPanel(JPanel panel) {
        panel.setSize(428, 800);
        panel.setLocation(0,0);  
       
        panelInicioCuenta.removeAll();
        panelInicioCuenta.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelInicioCuenta.revalidate();
        panelInicioCuenta.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbcuenta;
    private javax.swing.JButton jbhistorial;
    private javax.swing.JButton jbreserva;
    private javax.swing.JLabel jltitulo1;
    private vista.PanelRound panelInicioCuenta;
    // End of variables declaration//GEN-END:variables
}
