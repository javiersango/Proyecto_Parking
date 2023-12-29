/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.HibernateUtil;

import modelo.Historial;
import org.hibernate.SessionFactory;

import modelo.Usuarios;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.mapping.Set;


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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new vista.PanelRound();
        jltitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbcuenta = new javax.swing.JButton();
        jbhistorial = new javax.swing.JButton();
        jbreserva2 = new javax.swing.JButton();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelRound1.setBackground(new java.awt.Color(249, 251, 255));
        panelRound1.setMaximumSize(null);
        panelRound1.setPreferredSize(new java.awt.Dimension(428, 800));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);

        jltitulo1.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jltitulo1.setForeground(new java.awt.Color(39, 59, 244));
        jltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo1.setText("¿Que desea hacer?");
        jltitulo1.setPreferredSize(new java.awt.Dimension(273, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/LogoParking.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jbcuenta.setBackground(new java.awt.Color(39, 59, 244));
        jbcuenta.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbcuenta.setForeground(new java.awt.Color(255, 255, 255));
        jbcuenta.setText("Cuenta");
        jbcuenta.setToolTipText("Boton para modificar datos del usuario");
        jbcuenta.setPreferredSize(new java.awt.Dimension(124, 49));

        jbhistorial.setBackground(new java.awt.Color(39, 59, 244));
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

        jbreserva2.setBackground(new java.awt.Color(39, 59, 244));
        jbreserva2.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbreserva2.setForeground(new java.awt.Color(255, 255, 255));
        jbreserva2.setText("Reservar");
        jbreserva2.setToolTipText("Botón para reservar una plaza de aparcamiento");
        jbreserva2.setPreferredSize(new java.awt.Dimension(124, 49));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jltitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbhistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(jbreserva2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(jbcuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jbreserva2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbhistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbhistorialActionPerformed
        
    // Crear una fábrica de sesiones de Hibernate
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Abrir una sesión de Hibernate
    Session sesion = sessionFactory.openSession();

    try {
        // Cargar un usuario por su ID (en este caso, ID 5)
        Usuarios usuario = sesion.load(Usuarios.class, 5);

        System.out.println("Nombre del usuario: " + usuario.getNombre());
        System.out.println("Apellidos del usuario: " + usuario.getApellidos());
        System.out.println("Matricula del usuario: " + usuario.getContrasena());

    } catch (ObjectNotFoundException e) {
        System.out.println("El usuario no existe");
    } finally {
        // Cerrar la sesión de Hibernate
        sesion.close();
    }
    }//GEN-LAST:event_jbhistorialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbcuenta;
    private javax.swing.JButton jbhistorial;
    private javax.swing.JButton jbreserva2;
    private javax.swing.JLabel jltitulo1;
    private vista.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
