/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.Usuarios;
import modelo.Vehiculos;
import modelo.Historial;
import controlador.MetodosAdministrador;
import controlador.MetodosHistorial;


/**
 *
 * @author Javier Sánchez Gonzalez
 */
public class Administrador extends javax.swing.JPanel {

    /**
     * Variables historial
     */
    private final Usuarios usuarios;
    private final Vehiculos vehiculos;
    private MetodosAdministrador metodosAdministrador;

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
     *
     * @param usuarios
     * @param vehiculos
     */
    public Administrador(Usuarios usuarios, Vehiculos vehiculos) {
        this.usuarios = usuarios;
        this.vehiculos = vehiculos;

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgeleccion = new javax.swing.ButtonGroup();
        panelAdministrador = new vista.PanelRound();
        jlhistorial = new javax.swing.JLabel();
        jbmostrarDatosUsuarios = new javax.swing.JButton();
        jbMostrarAparcamientos = new javax.swing.JButton();
        jltitulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jbmostrarHistorialReservas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtabla1 = new javax.swing.JTable();

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

        jbmostrarDatosUsuarios.setBackground(new java.awt.Color(43, 220, 61));
        jbmostrarDatosUsuarios.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbmostrarDatosUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jbmostrarDatosUsuarios.setText("Mostrar usuarios");
        jbmostrarDatosUsuarios.setToolTipText("Muestra el historial por nombre o por matricula");
        jbmostrarDatosUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbmostrarDatosUsuarios.setPreferredSize(new java.awt.Dimension(124, 49));
        jbmostrarDatosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbmostrarDatosUsuariosActionPerformed(evt);
            }
        });

        jbMostrarAparcamientos.setBackground(new java.awt.Color(43, 220, 61));
        jbMostrarAparcamientos.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbMostrarAparcamientos.setForeground(new java.awt.Color(255, 255, 255));
        jbMostrarAparcamientos.setText("Mostrar Aparcamiento");
        jbMostrarAparcamientos.setToolTipText("Boton cancela operacion y regresa a la pantalla anterior");
        jbMostrarAparcamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMostrarAparcamientos.setPreferredSize(new java.awt.Dimension(124, 49));
        jbMostrarAparcamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarAparcamientosActionPerformed(evt);
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
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtabla);

        jbmostrarHistorialReservas.setBackground(new java.awt.Color(43, 220, 61));
        jbmostrarHistorialReservas.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbmostrarHistorialReservas.setForeground(new java.awt.Color(255, 255, 255));
        jbmostrarHistorialReservas.setText("Historial reservas");
        jbmostrarHistorialReservas.setToolTipText("Muestra el historial por nombre o por matricula");
        jbmostrarHistorialReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbmostrarHistorialReservas.setPreferredSize(new java.awt.Dimension(124, 49));
        jbmostrarHistorialReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbmostrarHistorialReservasActionPerformed(evt);
            }
        });

        jtabla1.setBackground(new java.awt.Color(198, 212, 255));
        jtabla1.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        jtabla1.setForeground(new java.awt.Color(0, 0, 0));
        jtabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtabla1);

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
                        .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbMostrarAparcamientos, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                .addComponent(jbmostrarDatosUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbmostrarHistorialReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdministradorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        panelAdministradorLayout.setVerticalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbmostrarDatosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbmostrarHistorialReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbMostrarAparcamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jbmostrarDatosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbmostrarDatosUsuariosActionPerformed
        // Llamar al método para obtener la lista de usuarios
        List<Usuarios> usuarios = MetodosAdministrador.buscarUsuarios();

        // Obtener el modelo de la tabla y limpiar las filas antes de añadir nuevos datos
        DefaultTableModel model = (DefaultTableModel) jtabla1.getModel();
        model.setRowCount(0); // Limpiar la tabla

        // Títulos de las columnas para los usuarios (solo es necesario si no se establecen en el diseño de la tabla)
        String[] columnTitles = {"ID", "Nombre", "Apellidos", "Email"};
        model.setColumnIdentifiers(columnTitles); // Establecer títulos de columnas

        // Verificar si la lista de usuarios no está vacía
        if (!usuarios.isEmpty()) {
            // Agregar los datos de los usuarios a la tabla
            for (Usuarios usu : usuarios) {
                model.addRow(new Object[]{
                    usu.getId(),
                    usu.getNombre(),
                    usu.getApellidos(),
                    usu.getEmail()
                });
            }

            // Centrar el contenido de las celdas
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < jtabla1.getColumnCount(); i++) {
                jtabla1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } else {
            // Mostrar mensaje si no hay registros
            JOptionPane.showMessageDialog(null, "No hay registros de usuarios.", "Usuarios", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jbmostrarDatosUsuariosActionPerformed

    /**
     * Evento si al introducir los datos son erroneos, al cancelar vuelven a
     * incilizarse los campos
     */
    private void jbMostrarAparcamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarAparcamientosActionPerformed
        ParkingAdministrador parkingAdministrador = new ParkingAdministrador(usuarios, vehiculos);
        mostrarPanel(parkingAdministrador);

    }//GEN-LAST:event_jbMostrarAparcamientosActionPerformed

    private void jbmostrarHistorialReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbmostrarHistorialReservasActionPerformed
        // Obtener la lista de reservas desde MetodosHistorial

        List<Historial> historia = MetodosHistorial.mostrarHistorial();

        // Limpiar la tabla antes de añadir nuevos datos
        DefaultTableModel model = (DefaultTableModel) jtabla.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (!historia.isEmpty()) {
            // Títulos de las columnas para el historial
            String[] columnTitles = {"Día", "Duración", "Precio", "Matrícula"};
            model.setColumnIdentifiers(columnTitles); // Establecer títulos de columnas

            for (modelo.Historial his : historia) {
                Double precio = his.getPrecio() != null ? his.getPrecio() : 0.0;
                model.addRow(new Object[]{his.getDia(), his.getTiempoReservado(), precio, his.getMatricula()});

            }

            // Centrar el contenido de las celdas
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < jtabla.getColumnCount(); i++) {
                jtabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros en el historial.", "Historial", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbmostrarHistorialReservasActionPerformed

    private void jtabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabla1MouseClicked
        int selectedRow = jtabla1.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (selectedRow >= 0) {
            // Obtener el ID del usuario desde la tabla
            int idUsuario = (int) jtabla1.getValueAt(selectedRow, 0);
            String nombreUsuario = (String) jtabla1.getValueAt(selectedRow, 1);

            // Mostrar mensaje de confirmación
            int confirm = JOptionPane.showConfirmDialog(null,
                    "¿Desea eliminar al usuario " + nombreUsuario + " con ID " + idUsuario + "?",
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            // Si el usuario confirma, eliminar el registro
            if (confirm == JOptionPane.YES_OPTION) {
                boolean eliminado = metodosAdministrador.eliminarUsuario(idUsuario);

                if (eliminado) {
                    JOptionPane.showMessageDialog(null,
                            "Usuario eliminado correctamente.",
                            "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);

                    // Actualizar la tabla después de la eliminación
                    DefaultTableModel model = (DefaultTableModel) jtabla1.getModel();
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al eliminar el usuario.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jtabla1MouseClicked
    public void mostrarPanel(JPanel panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);

        panelAdministrador.removeAll();
        panelAdministrador.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelAdministrador.revalidate();
        panelAdministrador.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgeleccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbMostrarAparcamientos;
    private javax.swing.JButton jbmostrarDatosUsuarios;
    private javax.swing.JButton jbmostrarHistorialReservas;
    private javax.swing.JLabel jlhistorial;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JTable jtabla;
    private javax.swing.JTable jtabla1;
    private vista.PanelRound panelAdministrador;
    // End of variables declaration//GEN-END:variables

}
