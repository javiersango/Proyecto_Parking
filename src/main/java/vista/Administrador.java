/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.MetodosHistorial;
import controlador.MetodosRegistroCuenta;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuarios;

/**
 *
 * @author Javier Sánchez Gonzalez
 */
public class Administrador extends javax.swing.JPanel {

    /**
     * Variables historial
     */
    private Usuarios usuarioActual;
    private String nombre;
    private String contrasena;

    /**
     * Creates new form RegistroCuenta
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /**
     * Creates new form RegistroCuenta
     */
    public Administrador(Usuarios usuario) {

        initComponents();
        this.usuarioActual = usuario;

        nombre = usuarioActual.getNombre();
        contrasena = usuarioActual.getContrasena();
        System.out.println(usuarioActual.getNombre() + "  " + usuarioActual.getContrasena());

        // Poner jTexfield y jBotton el radio
        jbmostrar.putClientProperty("FlatLaf.style", "arc: 15");
        jbcancelar.putClientProperty("FlatLaf.style", "arc: 15");
        // jlhistorial.putClientProperty("FlatLaf.styleClass", "h2");
        jlhistorial.putClientProperty("Flatlaf.styleClass", "");
        jltitulo2.putClientProperty("FlatLaf.styleClass", "h0");

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgeleccion = new javax.swing.ButtonGroup();
        panelAdministrador = new vista.PanelRound();
        jlhistorial = new javax.swing.JLabel();
        jbmostrar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jltitulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelAdministrador.setBackground(new java.awt.Color(249, 251, 255));
        panelAdministrador.setMaximumSize(null);
        panelAdministrador.setPreferredSize(new java.awt.Dimension(428, 800));
        panelAdministrador.setRoundBottomLeft(30);
        panelAdministrador.setRoundBottomRight(30);

        jlhistorial.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jlhistorial.setForeground(new java.awt.Color(39, 59, 244));
        jlhistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlhistorial.setText("HISTORIAL APARCAMIENTO");
        jlhistorial.setPreferredSize(new java.awt.Dimension(273, 30));

        jbmostrar.setBackground(new java.awt.Color(43, 220, 61));
        jbmostrar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbmostrar.setForeground(new java.awt.Color(255, 255, 255));
        jbmostrar.setText("Mostrar");
        jbmostrar.setToolTipText("Muestra el historial por nombre o por matricula");
        jbmostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbmostrar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbmostrarActionPerformed(evt);
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

        jltitulo2.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(25, 35, 66));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo2.setText("Administrador");
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));

        jtabla.setBackground(new java.awt.Color(198, 212, 255));
        jtabla.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        jtabla.setForeground(new java.awt.Color(0, 0, 0));
        jtabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Duración", "Precio", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtabla);

        javax.swing.GroupLayout panelAdministradorLayout = new javax.swing.GroupLayout(panelAdministrador);
        panelAdministrador.setLayout(panelAdministradorLayout);
        panelAdministradorLayout.setHorizontalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdministradorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAdministradorLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                .addComponent(jbcancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbmostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAdministradorLayout.setVerticalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jbmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jbcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     *
     * @param evt Metodo buscarMatricula var matricula = se pasa al metodo y nos
     * devuelve un arrayList del historial
     */

    private void jbmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbmostrarActionPerformed

        List<modelo.Historial> historia = MetodosHistorial.buscarMatricula();

        if (!historia.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jtabla.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de añadir nuevos datos

            for (modelo.Historial his : historia) {
                model.addRow(new Object[]{his.getDia(), his.getTiempoReservado(), his.getPrecio(), his.getMatricula()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros en el historial: ", "Historial", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jbmostrarActionPerformed

    /**
     * Evento si al introducir los datos son erroneos, al cancelar vuelven a
     * incilizarse los campos
     */
    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed

        // Crea una instancia de InicioCuenta
        InicioCuenta ic = new InicioCuenta();
        // Muestra la ventana InicioCuenta
        mostrarPanel(ic);

    }//GEN-LAST:event_jbcancelarActionPerformed

    /**
     * Metodo se le pasa el panel IncioCuenta para que elmine el actual y
     * muestre este.
     *
     * @param panel
     */
    private void mostrarPanel(InicioCuenta panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);

        panelAdministrador.removeAll();
        panelAdministrador.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelAdministrador.revalidate();
        panelAdministrador.repaint();

    }
    /**
     * Metodo crean la variables para que al leer el archivo de texto traducido
     * lo identifique
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgeleccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbmostrar;
    private javax.swing.JLabel jlhistorial;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JTable jtabla;
    private vista.PanelRound panelAdministrador;
    // End of variables declaration//GEN-END:variables

}
