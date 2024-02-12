/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import controlador.MetodosRegistroCuenta;
import javax.swing.JRootPane;




/**
 *
 * @author Javier
 */
public class Modificada extends javax.swing.JFrame {
    
 
    
    MetodosRegistroCuenta mrc = new MetodosRegistroCuenta();
      

    /**
     * Creates new form RecuperarContrasena
     */
    public Modificada(boolean ingles) {
        initComponents();
        setLocationRelativeTo(null);
        
       
        
        jbaceptar.putClientProperty("FlatLaf.style","arc: 25");
      

    }

    Modificada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound = new vista.PanelRound();
        jltitulo1 = new javax.swing.JLabel();
        jbaceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound.setBackground(new java.awt.Color(39, 59, 244));
        panelRound.setAlignmentX(0.0F);
        panelRound.setAlignmentY(0.0F);

        jltitulo1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jltitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo1.setText("MODIFICADA");
        jltitulo1.setPreferredSize(new java.awt.Dimension(273, 30));

        jbaceptar.setBackground(new java.awt.Color(43, 220, 61));
        jbaceptar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbaceptar.setForeground(new java.awt.Color(255, 255, 255));
        jbaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/check.png"))); // NOI18N
        jbaceptar.setToolTipText("Boton acepta el envio para recuperar la contraseña");
        jbaceptar.setPreferredSize(new java.awt.Dimension(124, 49));

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jbaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Modificada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificada(false).setVisible(true);
            }
        });
    }

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbaceptar;
    private javax.swing.JLabel jltitulo1;
    private vista.PanelRound panelRound;
    // End of variables declaration//GEN-END:variables

}
