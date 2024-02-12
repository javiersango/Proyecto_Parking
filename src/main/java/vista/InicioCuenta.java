/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import javax.swing.JPanel;

/**
 *
 * @author Javier Sánchez Gonzalez
 */
public class InicioCuenta extends javax.swing.JPanel {

    /**
     * Creates new form RegistroCuenta
     *
     * @param ingles
     */
    /**
     * Creates new form RegistroCuenta
     */
    public InicioCuenta() {
        initComponents();

        // Poner los jbonton  bordes redondeados
        jbcuenta.putClientProperty("FlatLaf.style", "arc: 15");
        jbreserva.putClientProperty("FlatLaf.style", "arc: 15");
        jbhistorial.putClientProperty("FlatLaf.style", "arc: 15");

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
        jbcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jbhistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jbreserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbreserva.setPreferredSize(new java.awt.Dimension(124, 49));
        jbreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbreservaActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioCuentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInicioCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbhistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbreserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(panelInicioCuentaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelInicioCuentaLayout.setVerticalGroup(
            panelInicioCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioCuentaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jbreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
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
    /**
     * Evento se le pasa el panel a mostrarPanel
     *
     * @param evt
     */
    private void jbhistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbhistorialActionPerformed
        Historiales panelHistorial = new Historiales();
        mostrarPanel(panelHistorial);
    }//GEN-LAST:event_jbhistorialActionPerformed
    /**
     * Evento se le pasa el panel a mostrarPanel
     *
     * @param evt
     */
    private void jbcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcuentaActionPerformed
        Cuenta panelCuenta = new Cuenta();
        mostrarPanel(panelCuenta);
    }//GEN-LAST:event_jbcuentaActionPerformed
    /**
     * Evento se le pasa el panel a mostrarPanel
     *
     * @param evt
     */
    private void jbreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbreservaActionPerformed
        Parking panelReserva = new Parking();
        mostrarPanel(panelReserva);
    }//GEN-LAST:event_jbreservaActionPerformed
    /**
     * Metodo elimna el panel actual y lo sustitulle con el que se le pase
     *
     * @param evt
     */
    private void mostrarPanel(JPanel panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);

        panelInicioCuenta.removeAll();
        panelInicioCuenta.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelInicioCuenta.revalidate();
        panelInicioCuenta.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbcuenta;
    private javax.swing.JButton jbhistorial;
    private javax.swing.JButton jbreserva;
    private javax.swing.JLabel jltitulo1;
    private vista.PanelRound panelInicioCuenta;
    // End of variables declaration//GEN-END:variables
}
