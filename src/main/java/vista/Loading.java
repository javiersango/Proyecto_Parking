/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Javier Sánchez González
 */
public class Loading extends javax.swing.JFrame {

    // Inicio de la variables
    int xMouse, yMouse;
    private int nivelBateria = 101;

    /**
     * Creates new form Loading
     */
    public Loading() {
        initComponents();
        setLocationRelativeTo(null);

        //jLTitulo.setFont(new java.awt.Font("Monoton", 1, 32));
        jLTitulo.putClientProperty("FlatLaf.styleClass", "h0");
        jPBarraProgreso.putClientProperty("FlatLaf.style", "arc: 15");

        // Poner bordes redondos JFrame
        Shape forma = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30);
        setShape(forma);

        //Configuracion reloj 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String horaActual = sdf.format(new Date());
        jLtime.setText(horaActual);

        // Inicia una tarea programada para actualizar el nivel de la batería y el JLabel
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateBatteryLevel();
            }
        }, 0, 600000); // Actualiza cada segundo (1000 ms)

    }

    private void updateBatteryLevel() {
        // Lógica para obtener el nivel de la batería (simulado aquí)
        int batteryLevel = obtenerNivelBateria();

        // Actualiza el JLabel con el nivel de la batería
        jLporcentajeBateria.setText(batteryLevel + "%");

    }

    /**
     * Método de ejemplo para obtener el nivel de la batería (simulado)
     * @return 
     */
    private int obtenerNivelBateria() {
        //  AtomicInteger atomicBatteryLevel = new AtomicInteger((int) (Math.random() * 100));
        //  return atomicBatteryLevel.get();
        if (nivelBateria > 0) {
            nivelBateria--; // Disminuimos el nivel de batería en 1
        }
        return nivelBateria;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRoundFondo = new vista.PanelRound();
        jLPorciento = new javax.swing.JLabel();
        jPBarraProgreso = new javax.swing.JProgressBar();
        jLcoche = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        panelRoundBarraFondo = new vista.PanelRound();
        jLporcentajeBateria = new javax.swing.JLabel();
        jLsignal = new javax.swing.JLabel();
        jLwifi = new javax.swing.JLabel();
        jLiconoBateria = new javax.swing.JLabel();
        panelRoundFondoCierre = new vista.PanelRound();
        jLcierre = new javax.swing.JLabel();
        jLtime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRoundFondo.setBackground(new java.awt.Color(249, 251, 255));
        panelRoundFondo.setMaximumSize(null);
        panelRoundFondo.setMinimumSize(null);
        panelRoundFondo.setPreferredSize(new java.awt.Dimension(428, 760));
        panelRoundFondo.setRoundBottomLeft(30);
        panelRoundFondo.setRoundBottomRight(30);
        panelRoundFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLPorciento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLPorciento.setForeground(new java.awt.Color(86, 125, 244));
        jLPorciento.setText("0%");
        panelRoundFondo.add(jLPorciento, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 383, -1, -1));

        jPBarraProgreso.setForeground(new java.awt.Color(86, 125, 244));
        panelRoundFondo.add(jPBarraProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 433, 337, 22));

        jLcoche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/LogoCar.png"))); // NOI18N
        panelRoundFondo.add(jLcoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 430, 319));

        jLTitulo.setFont(new java.awt.Font("Stencil", 1, 32)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText(" APP PARKING");
        jLTitulo.setPreferredSize(new java.awt.Dimension(273, 30));
        panelRoundFondo.add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 506, -1, 34));

        getContentPane().add(panelRoundFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, -1, -1));

        panelRoundBarraFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBarraFondo.setForeground(new java.awt.Color(255, 255, 255));
        panelRoundBarraFondo.setMaximumSize(null);
        panelRoundBarraFondo.setPreferredSize(new java.awt.Dimension(428, 44));
        panelRoundBarraFondo.setRoundTopLeft(30);
        panelRoundBarraFondo.setRoundTopRight(30);
        panelRoundBarraFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelRoundBarraFondoMouseDragged(evt);
            }
        });
        panelRoundBarraFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRoundBarraFondoMousePressed(evt);
            }
        });

        jLporcentajeBateria.setForeground(new java.awt.Color(0, 0, 0));
        jLporcentajeBateria.setPreferredSize(new java.awt.Dimension(17, 13));

        jLsignal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Mobile Signal.png"))); // NOI18N
        jLsignal.setText("jLabel2");
        jLsignal.setToolTipText("Cobertura");
        jLsignal.setPreferredSize(new java.awt.Dimension(17, 13));

        jLwifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Wifi.png"))); // NOI18N
        jLwifi.setText("jLabel2");
        jLwifi.setToolTipText("Wifi");
        jLwifi.setPreferredSize(new java.awt.Dimension(17, 13));

        jLiconoBateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Battery.png"))); // NOI18N
        jLiconoBateria.setText("jLabel2");
        jLiconoBateria.setPreferredSize(new java.awt.Dimension(17, 13));

        panelRoundFondoCierre.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundFondoCierre.setForeground(new java.awt.Color(255, 255, 255));
        panelRoundFondoCierre.setRoundTopRight(30);

        jLcierre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLcierre.setForeground(new java.awt.Color(0, 0, 0));
        jLcierre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLcierre.setText("X");
        jLcierre.setToolTipText("Cerrar");
        jLcierre.setPreferredSize(new java.awt.Dimension(17, 17));
        jLcierre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLcierreMouseMoved(evt);
            }
        });
        jLcierre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLcierreMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLcierreMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRoundFondoCierreLayout = new javax.swing.GroupLayout(panelRoundFondoCierre);
        panelRoundFondoCierre.setLayout(panelRoundFondoCierreLayout);
        panelRoundFondoCierreLayout.setHorizontalGroup(
            panelRoundFondoCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLcierre, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        panelRoundFondoCierreLayout.setVerticalGroup(
            panelRoundFondoCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLcierre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLtime.setToolTipText("Hora");
        jLtime.setPreferredSize(new java.awt.Dimension(17, 13));

        javax.swing.GroupLayout panelRoundBarraFondoLayout = new javax.swing.GroupLayout(panelRoundBarraFondo);
        panelRoundBarraFondo.setLayout(panelRoundBarraFondoLayout);
        panelRoundBarraFondoLayout.setHorizontalGroup(
            panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBarraFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLtime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(jLsignal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLwifi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLiconoBateria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLporcentajeBateria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRoundFondoCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRoundBarraFondoLayout.setVerticalGroup(
            panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundFondoCierre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRoundBarraFondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLporcentajeBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLiconoBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLwifi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLsignal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(panelRoundBarraFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 41));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelRoundBarraFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoundBarraFondoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelRoundBarraFondoMouseDragged

    private void panelRoundBarraFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoundBarraFondoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelRoundBarraFondoMousePressed

    private void jLcierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLcierreMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLcierreMouseClicked

    private void jLcierreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLcierreMouseExited
        panelRoundFondoCierre.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLcierreMouseExited

    private void jLcierreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLcierreMouseMoved
        panelRoundFondoCierre.setBackground(Color.lightGray);
    }//GEN-LAST:event_jLcierreMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLPorciento;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLcierre;
    private javax.swing.JLabel jLcoche;
    private javax.swing.JLabel jLiconoBateria;
    private javax.swing.JLabel jLporcentajeBateria;
    private javax.swing.JLabel jLsignal;
    private javax.swing.JLabel jLtime;
    private javax.swing.JLabel jLwifi;
    public static javax.swing.JProgressBar jPBarraProgreso;
    private vista.PanelRound panelRoundBarraFondo;
    private vista.PanelRound panelRoundFondo;
    private vista.PanelRound panelRoundFondoCierre;
    // End of variables declaration//GEN-END:variables
}
