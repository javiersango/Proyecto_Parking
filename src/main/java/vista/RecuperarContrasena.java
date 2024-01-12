/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import controlador.MetodosRecuperarContrasena;
import controlador.MetodosContrasena;
import controlador.MetodosRegistroCuenta;
import controlador.EmailUtil;



/**
 *
 * @author Javier
 */
public class RecuperarContrasena extends javax.swing.JFrame {
    
    private boolean inglesRecuperarContrasena;
    
    MetodosRegistroCuenta mrc = new MetodosRegistroCuenta();

    /**
     * Creates new form RecuperarContrasena
     */
    public RecuperarContrasena(boolean ingles) {
        initComponents();
        setLocationRelativeTo(null);
        this.inglesRecuperarContrasena = ingles;
        
        Shape forma = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30);
        setShape(forma);
        
        // Poner jTexfield y jBotton el radio
        jtemail.putClientProperty("FlatLaf.style", "arc: 15");
        jbaceptar.putClientProperty("FlatLaf.style", "arc: 15");
        jbcancelar.putClientProperty("FlatLaf.style", "arc: 15");

        // Poner el stiylo al texto
        jltitulo1.putClientProperty("FlatLaf.styleClass", "h1");
        jltitulo2.putClientProperty("FlatLaf.styleClass", "h1");
        jlemail.putClientProperty("FlatLaf.styleClass", "h2");
        
        
            cambiarIdiomaEn();
        

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
        jltitulo2 = new javax.swing.JLabel();
        jPanelContaseña = new javax.swing.JPanel();
        jlemail = new javax.swing.JLabel();
        jtemail = new javax.swing.JTextField();
        jbcancelar = new javax.swing.JButton();
        jltitulo1 = new javax.swing.JLabel();
        jbaceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound.setBackground(new java.awt.Color(39, 59, 244));
        panelRound.setAlignmentX(0.0F);
        panelRound.setAlignmentY(0.0F);

        jltitulo2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(255, 255, 255));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jltitulo2.setText("para recuperar la contraseña");
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));

        jPanelContaseña.setBackground(new java.awt.Color(39, 59, 244));
        jPanelContaseña.setPreferredSize(new java.awt.Dimension(335, 82));

        jlemail.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jlemail.setForeground(new java.awt.Color(255, 255, 255));
        jlemail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlemail.setText("Email");
        jlemail.setPreferredSize(new java.awt.Dimension(51, 17));

        jtemail.setBackground(new java.awt.Color(221, 221, 221));
        jtemail.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtemail.setForeground(new java.awt.Color(153, 153, 153));
        jtemail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtemail.setText("Email");
        jtemail.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtemail.setPreferredSize(new java.awt.Dimension(335, 50));
        jtemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtemailMouseClicked(evt);
            }
        });
        jtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtemailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContaseñaLayout = new javax.swing.GroupLayout(jPanelContaseña);
        jPanelContaseña.setLayout(jPanelContaseñaLayout);
        jPanelContaseñaLayout.setHorizontalGroup(
            jPanelContaseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContaseñaLayout.createSequentialGroup()
                .addComponent(jlemail, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jtemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelContaseñaLayout.setVerticalGroup(
            jPanelContaseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContaseñaLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jlemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbcancelar.setBackground(new java.awt.Color(255, 3, 3));
        jbcancelar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbcancelar.setText("Cancelar");
        jbcancelar.setToolTipText("Boton cancela la accion");
        jbcancelar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        jltitulo1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jltitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jltitulo1.setText("Introduzca sus datos");
        jltitulo1.setPreferredSize(new java.awt.Dimension(273, 30));

        jbaceptar.setBackground(new java.awt.Color(43, 220, 61));
        jbaceptar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbaceptar.setForeground(new java.awt.Color(255, 255, 255));
        jbaceptar.setText("Aceptar");
        jbaceptar.setToolTipText("Boton acepta el envio para recuperar la contraseña");
        jbaceptar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbaceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbaceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelRoundLayout.createSequentialGroup()
                            .addComponent(jbaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanelContaseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelContaseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(205, 205, 205))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
     dispose();  //salir
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void jtemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtemailMouseClicked
        mrc.comportamientoCampos(jtemail, "Email");
    }//GEN-LAST:event_jtemailMouseClicked
    /** Evento comprueba que el correo sea valido , enviado un correo electronico para la recuperacion de la contraseña al usuario*/
    private void jbaceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbaceptarMouseClicked
       
        String correoElectronico = jtemail.getText();
        MetodosContrasena metodo = new MetodosContrasena();
        // comprobaciones correo no sea nulo o este vacio o si no existe en la base de datos
        if (correoElectronico != null || !correoElectronico.isEmpty() || MetodosRecuperarContrasena.existeEmail(correoElectronico) != false ) {
            if (metodo.esCorreoElectronicoValido(correoElectronico)) {
                JOptionPane.showMessageDialog(null, "La dirección de correo electrónico es válida.");
               
                String nuevaContrasena = MetodosRecuperarContrasena.generarContrasenaAleatoria(); // genera una contreaseña nueva aleatoria
                
                String nuevoHash = MetodosContrasena.crearHashContrasena(nuevaContrasena, nuevaContrasena); // Genera un hash con la contraseña nueva
                
                MetodosRecuperarContrasena.guardarHashContraseña(correoElectronico, nuevoHash);
                
                EmailUtil.enviarCorreoRecuperacionContrasena(correoElectronico, nuevaContrasena);  //envia email con la nueva contraseña
               
                jtemail.setText("Email"); 
                jtemail.setForeground(Color.gray);
                
                dispose();  //salir ;
            } else {
                JOptionPane.showMessageDialog(null, "La dirección de correo electrónico no es válida o no existe.");
                jtemail.setForeground(Color.red); // Cambia el color del texto a rojo para indicar un error
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha introducido ninguna dirección de correo electrónico.");
             jtemail.setText("Email"); 
             jtemail.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jbaceptarMouseClicked

    private void jtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtemailActionPerformed
        mrc.comportamientoCampos(jtemail, "Email");
        
    }//GEN-LAST:event_jtemailActionPerformed

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
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecuperarContrasena(false).setVisible(true);
            }
        });
    }
    
 

    public void cambiarIdiomaEn() {
       
            Locale locale = new Locale("en");
            ResourceBundle resourceBundle = ResourceBundle.getBundle("mensajes/messages_en", locale);
            String titulo1 = resourceBundle.getString("IntroduzcaSuEmail");
            String titulo2 = resourceBundle.getString("paraRecuperarLacontrasena");
            String aceptar = resourceBundle.getString("Aceptar");
            String cancelar = resourceBundle.getString("Cancelar");
            jltitulo1.setText(titulo1);
            jltitulo2.setText(titulo2);
            jbaceptar.setText(aceptar);
            jbcancelar.setText(cancelar);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelContaseña;
    private javax.swing.JButton jbaceptar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JLabel jlemail;
    private javax.swing.JLabel jltitulo1;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JTextField jtemail;
    private vista.PanelRound panelRound;
    // End of variables declaration//GEN-END:variables
}
