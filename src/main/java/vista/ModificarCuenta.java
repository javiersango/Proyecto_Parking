/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JOptionPane;
import controlador.MetodosContrasena;
import controlador.MetodosModificar;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import modelo.Usuarios;
import modelo.Vehiculos;
import controlador.MetodosRegistroCuenta;

/**
 *
 * @author Javier Sánchez González
 */
public class ModificarCuenta extends javax.swing.JPanel {

    // Inicializacin variables
    private boolean esCoche;
    private String nombre;
    private String apellidos;
    private String email;
    private String matricula;
    private String contrasena;
    private String repetirContrasena;
    private int idUsuario;
    private final Usuarios usuario;
    private final Vehiculos vehiculos;

    MetodosRegistroCuenta mrc = new MetodosRegistroCuenta();
    private final boolean inglesRegistroCuenta = false;

    /**
     * Creates new form RegistroCuenta
     *
     * @param ingles
     * @param usuario
     */
    public ModificarCuenta(boolean ingles, Usuarios usuario, Vehiculos vehiculos) {
        initComponents();

        this.usuario = usuario;
        this.vehiculos = vehiculos;

        // Llamada para mostrar los datos en los campos de texto
        mostrarDatos();

        // this.inglesRegistroCuenta = ingles;
        // Poner jTexfield y jBotton el radio
        jtnombre.putClientProperty("FlatLaf.style", "arc: 15");
        jtapellidos.putClientProperty("FlatLaf.style", "arc: 15");
        jtemail.putClientProperty("FlatLaf.style", "arc: 15");
        jtmatricula.putClientProperty("FlatLaf.style", "arc: 15");
        jtcontrasena.putClientProperty("FlatLaf.style", "arc: 15");
        jtrepetirContrasena.putClientProperty("FlatLaf.style", "arc: 15");

        jbModificar.putClientProperty("FlatLaf.style", "arc: 15");
        jbCancelar.putClientProperty("FlatLaf.style", "arc: 15");

        jlnombre.putClientProperty("FlatLaf.styleClass", "h3");
        jlapellidos.putClientProperty("FlatLaf.styleClass", "h3");
        jlemail.putClientProperty("FlatLaf.styleClass", "h3");
        jlmatricula.putClientProperty("FlatLaf.styleClass", "h3");
        jlcontrasena.putClientProperty("FlatLaf.styleClass", "h3");
        jlrepetirContrasena.putClientProperty("FlatLaf.styleClass", "h3");

        // añadir a los jTextField iconos
        jtnombre.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/usuario.svg"));
        jtapellidos.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/apellidos.svg"));
        jtemail.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/email.svg"));

        jtmatricula.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/matricula.svg"));
        jtcontrasena.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/candadoCerrado.svg"));
        jtrepetirContrasena.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/candadoCerrado.svg"));

        if (ingles == false) {  // cambia idoma segun seleccion
            // cambiarIdiomaEs();
            System.out.println("CAMBIAR IDIOMA " + ingles);
        } else {
            cambiarIdiomaEn();
            System.out.println("CAMBIAR IDIOMA " + ingles);
        }
    }

    // Método para mostrar los datos en la interfaz
    public void mostrarDatos() {
        idUsuario = usuario.getId();
        nombre = usuario.getNombre();
        jtnombre.setText(nombre);
        apellidos = usuario.getApellidos();
        jtapellidos.setText(apellidos);
        email = usuario.getEmail();
        jtemail.setText(email);
        

        matricula = vehiculos.getMatricula();
        
        contrasena = nombre + "@" + matricula.substring(0, Math.min(4, matricula.length()));
        jtcontrasena.setText(contrasena);
        repetirContrasena = nombre + "@" + matricula.substring(0, Math.min(4, matricula.length()));
        jtrepetirContrasena.setText(contrasena);
        
        jtmatricula.setText(matricula);
        esCoche = vehiculos.getEsCoche();
        Boolean esCocheVehiculo = vehiculos.getEsCoche();
        if (esCocheVehiculo != null) {
            esCoche = esCocheVehiculo;
            jCheckBoxCoche.setSelected(esCocheVehiculo);
            jCheckBoxMoto.setSelected(!esCocheVehiculo);
        } else {
            // Opcional: Manejar el caso donde esCoche es null
            esCoche = false; // o un valor por defecto
            jCheckBoxCoche.setSelected(false);
            jCheckBoxMoto.setSelected(false);
            System.out.println("Advertencia: el tipo de vehículo es null.");
        }

        System.out.println("ID Usuario: " + usuario.getId());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellidos: " + usuario.getApellidos());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Matrícula Vehículo: " + vehiculos.getMatricula());
        System.out.println("Es coche: " + vehiculos.getEsCoche());
        System.out.println("matricula: " + contrasena);
        System.out.println("repetir matricula: " + repetirContrasena);
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
        panelRegistroCuenta = new vista.PanelRound();
        jltitulo1 = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jPanelNombre = new javax.swing.JPanel();
        jlnombre = new javax.swing.JLabel();
        jtnombre = new javax.swing.JTextField();
        jPanelApellidos = new javax.swing.JPanel();
        jlapellidos = new javax.swing.JLabel();
        jtapellidos = new javax.swing.JTextField();
        jPanelEmail = new javax.swing.JPanel();
        jlemail = new javax.swing.JLabel();
        jtemail = new javax.swing.JTextField();
        jPanelMatricula = new javax.swing.JPanel();
        jlmatricula = new javax.swing.JLabel();
        jtmatricula = new javax.swing.JTextField();
        jltitulo3 = new javax.swing.JLabel();
        jCheckBoxCoche = new javax.swing.JCheckBox();
        jCheckBoxMoto = new javax.swing.JCheckBox();
        jPanelContrasena = new javax.swing.JPanel();
        jlcontrasena = new javax.swing.JLabel();
        jtcontrasena = new javax.swing.JPasswordField();
        jPanelContrasena1 = new javax.swing.JPanel();
        jlrepetirContrasena = new javax.swing.JLabel();
        jtrepetirContrasena = new javax.swing.JPasswordField();
        jLiconMoto = new javax.swing.JLabel();
        jLiconCoche = new javax.swing.JLabel();
        jltitulo2 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jNombre = new javax.swing.JLabel();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(428, 800));

        panelRegistroCuenta.setBackground(new java.awt.Color(249, 251, 255));
        panelRegistroCuenta.setMaximumSize(null);
        panelRegistroCuenta.setPreferredSize(new java.awt.Dimension(428, 800));
        panelRegistroCuenta.setRoundBottomLeft(30);
        panelRegistroCuenta.setRoundBottomRight(30);

        jltitulo1.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jltitulo1.setForeground(new java.awt.Color(39, 59, 244));
        jltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo1.setText("modifica  TU CUENTA");
        jltitulo1.setPreferredSize(new java.awt.Dimension(273, 30));

        jbModificar.setBackground(new java.awt.Color(43, 220, 61));
        jbModificar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbModificar.setText("Modificar");
        jbModificar.setToolTipText("Boton confirma el registro ");
        jbModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbModificar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jPanelNombre.setBackground(new java.awt.Color(249, 251, 255));
        jPanelNombre.setPreferredSize(new java.awt.Dimension(335, 82));

        jlnombre.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlnombre.setForeground(new java.awt.Color(25, 35, 66));
        jlnombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlnombre.setText("Nombre");
        jlnombre.setPreferredSize(new java.awt.Dimension(51, 17));

        jtnombre.setBackground(new java.awt.Color(198, 212, 255));
        jtnombre.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtnombre.setForeground(new java.awt.Color(153, 153, 153));
        jtnombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtnombre.setText("Nombre");
        jtnombre.setToolTipText("Introduce tu nombre minimo tiene que tener 3 caracteres");
        jtnombre.setPreferredSize(new java.awt.Dimension(335, 50));
        jtnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtnombreMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNombreLayout = new javax.swing.GroupLayout(jPanelNombre);
        jPanelNombre.setLayout(jPanelNombreLayout);
        jPanelNombreLayout.setHorizontalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanelNombreLayout.createSequentialGroup()
                .addComponent(jlnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelNombreLayout.setVerticalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreLayout.createSequentialGroup()
                .addComponent(jlnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelApellidos.setBackground(new java.awt.Color(249, 251, 255));
        jPanelApellidos.setPreferredSize(new java.awt.Dimension(335, 82));

        jlapellidos.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlapellidos.setForeground(new java.awt.Color(25, 35, 66));
        jlapellidos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlapellidos.setText("Apellidos");
        jlapellidos.setPreferredSize(new java.awt.Dimension(51, 17));

        jtapellidos.setBackground(new java.awt.Color(198, 212, 255));
        jtapellidos.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtapellidos.setForeground(new java.awt.Color(153, 153, 153));
        jtapellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtapellidos.setText("Apellidos");
        jtapellidos.setToolTipText("Introduce el primer apellido");
        jtapellidos.setPreferredSize(new java.awt.Dimension(335, 50));
        jtapellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtapellidosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelApellidosLayout = new javax.swing.GroupLayout(jPanelApellidos);
        jPanelApellidos.setLayout(jPanelApellidosLayout);
        jPanelApellidosLayout.setHorizontalGroup(
            jPanelApellidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanelApellidosLayout.createSequentialGroup()
                .addComponent(jlapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelApellidosLayout.setVerticalGroup(
            jPanelApellidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelApellidosLayout.createSequentialGroup()
                .addComponent(jlapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelEmail.setBackground(new java.awt.Color(249, 251, 255));
        jPanelEmail.setPreferredSize(new java.awt.Dimension(335, 82));

        jlemail.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlemail.setForeground(new java.awt.Color(25, 35, 66));
        jlemail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlemail.setText("Email");
        jlemail.setPreferredSize(new java.awt.Dimension(51, 17));

        jtemail.setBackground(new java.awt.Color(198, 212, 255));
        jtemail.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtemail.setForeground(new java.awt.Color(153, 153, 153));
        jtemail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtemail.setText("Email");
        jtemail.setToolTipText("Introduce un email valido, Minimo: 1 letra mayuscula, 1 letra minuscula, 1 caracter especial, 1 numero.");
        jtemail.setPreferredSize(new java.awt.Dimension(335, 50));
        jtemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtemailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelEmailLayout = new javax.swing.GroupLayout(jPanelEmail);
        jPanelEmail.setLayout(jPanelEmailLayout);
        jPanelEmailLayout.setHorizontalGroup(
            jPanelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanelEmailLayout.createSequentialGroup()
                .addComponent(jlemail, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelEmailLayout.setVerticalGroup(
            jPanelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmailLayout.createSequentialGroup()
                .addComponent(jlemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelMatricula.setBackground(new java.awt.Color(249, 251, 255));
        jPanelMatricula.setPreferredSize(new java.awt.Dimension(335, 82));

        jlmatricula.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlmatricula.setForeground(new java.awt.Color(25, 35, 66));
        jlmatricula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlmatricula.setText("Matricula");
        jlmatricula.setPreferredSize(new java.awt.Dimension(51, 17));

        jtmatricula.setBackground(new java.awt.Color(198, 212, 255));
        jtmatricula.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtmatricula.setForeground(new java.awt.Color(153, 153, 153));
        jtmatricula.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtmatricula.setText("Matricula");
        jtmatricula.setToolTipText("Formato matriculo 0000 XXX");
        jtmatricula.setPreferredSize(new java.awt.Dimension(335, 50));
        jtmatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtmatriculaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelMatriculaLayout = new javax.swing.GroupLayout(jPanelMatricula);
        jPanelMatricula.setLayout(jPanelMatriculaLayout);
        jPanelMatriculaLayout.setHorizontalGroup(
            jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelMatriculaLayout.setVerticalGroup(
            jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                .addComponent(jlmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jltitulo3.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jltitulo3.setForeground(new java.awt.Color(25, 35, 66));
        jltitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo3.setText("Modificar");
        jltitulo3.setPreferredSize(new java.awt.Dimension(273, 30));

        jCheckBoxCoche.setBackground(new java.awt.Color(249, 251, 255));
        bgrupovehiculos.add(jCheckBoxCoche);
        jCheckBoxCoche.setForeground(new java.awt.Color(39, 59, 244));
        jCheckBoxCoche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxCoche.setMaximumSize(null);
        jCheckBoxCoche.setMinimumSize(null);
        jCheckBoxCoche.setPreferredSize(new java.awt.Dimension(25, 19));

        jCheckBoxMoto.setBackground(new java.awt.Color(249, 251, 255));
        bgrupovehiculos.add(jCheckBoxMoto);
        jCheckBoxMoto.setForeground(new java.awt.Color(39, 59, 244));
        jCheckBoxMoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxMoto.setMaximumSize(null);
        jCheckBoxMoto.setMinimumSize(null);
        jCheckBoxMoto.setPreferredSize(new java.awt.Dimension(25, 19));

        jPanelContrasena.setBackground(new java.awt.Color(249, 251, 255));
        jPanelContrasena.setPreferredSize(new java.awt.Dimension(335, 82));

        jlcontrasena.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlcontrasena.setForeground(new java.awt.Color(25, 35, 66));
        jlcontrasena.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlcontrasena.setText("Contraseña");
        jlcontrasena.setPreferredSize(new java.awt.Dimension(51, 17));

        jtcontrasena.setBackground(new java.awt.Color(198, 212, 255));
        jtcontrasena.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtcontrasena.setForeground(new java.awt.Color(153, 153, 153));
        jtcontrasena.setText("********");
        jtcontrasena.setToolTipText("Introduce una contraseña entre 8 y 30 caracteres");
        jtcontrasena.setPreferredSize(new java.awt.Dimension(335, 50));
        jtcontrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtcontrasenaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelContrasenaLayout = new javax.swing.GroupLayout(jPanelContrasena);
        jPanelContrasena.setLayout(jPanelContrasenaLayout);
        jPanelContrasenaLayout.setHorizontalGroup(
            jPanelContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtcontrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanelContrasenaLayout.createSequentialGroup()
                .addComponent(jlcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelContrasenaLayout.setVerticalGroup(
            jPanelContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContrasenaLayout.createSequentialGroup()
                .addComponent(jlcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelContrasena1.setBackground(new java.awt.Color(249, 251, 255));
        jPanelContrasena1.setPreferredSize(new java.awt.Dimension(335, 82));

        jlrepetirContrasena.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlrepetirContrasena.setForeground(new java.awt.Color(25, 35, 66));
        jlrepetirContrasena.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlrepetirContrasena.setText("Repetir contraseña");
        jlrepetirContrasena.setPreferredSize(new java.awt.Dimension(51, 17));

        jtrepetirContrasena.setBackground(new java.awt.Color(198, 212, 255));
        jtrepetirContrasena.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtrepetirContrasena.setForeground(new java.awt.Color(153, 153, 153));
        jtrepetirContrasena.setText("********");
        jtrepetirContrasena.setToolTipText("Repetir contraseña introducida");
        jtrepetirContrasena.setPreferredSize(new java.awt.Dimension(335, 50));
        jtrepetirContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtrepetirContrasenaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelContrasena1Layout = new javax.swing.GroupLayout(jPanelContrasena1);
        jPanelContrasena1.setLayout(jPanelContrasena1Layout);
        jPanelContrasena1Layout.setHorizontalGroup(
            jPanelContrasena1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtrepetirContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanelContrasena1Layout.createSequentialGroup()
                .addComponent(jlrepetirContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelContrasena1Layout.setVerticalGroup(
            jPanelContrasena1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContrasena1Layout.createSequentialGroup()
                .addComponent(jlrepetirContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jtrepetirContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLiconMoto.setBackground(new java.awt.Color(39, 59, 244));
        jLiconMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/motorbike-fill 1.png"))); // NOI18N
        jLiconMoto.setMaximumSize(null);
        jLiconMoto.setMinimumSize(null);
        jLiconMoto.setPreferredSize(new java.awt.Dimension(25, 19));

        jLiconCoche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/car-fill 2.png"))); // NOI18N
        jLiconCoche.setMaximumSize(null);
        jLiconCoche.setMinimumSize(null);
        jLiconCoche.setPreferredSize(new java.awt.Dimension(25, 19));

        jltitulo2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(51, 51, 51));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo2.setText("que quieres modificar de  tu cuenta? ");
        jltitulo2.setToolTipText("Volver pantalla anterior");
        jltitulo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));

        jbCancelar.setBackground(new java.awt.Color(255, 3, 3));
        jbCancelar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("Boton confirma el registro ");
        jbCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCancelar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jNombre.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jNombre.setForeground(new java.awt.Color(39, 59, 244));
        jNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jNombre.setToolTipText("Volver pantalla anterior");
        jNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jNombre.setPreferredSize(new java.awt.Dimension(273, 30));

        javax.swing.GroupLayout panelRegistroCuentaLayout = new javax.swing.GroupLayout(panelRegistroCuenta);
        panelRegistroCuenta.setLayout(panelRegistroCuentaLayout);
        panelRegistroCuentaLayout.setHorizontalGroup(
            panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jltitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroCuentaLayout.createSequentialGroup()
                                        .addComponent(jPanelMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLiconCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCheckBoxCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBoxMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLiconMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(jPanelContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(jPanelContrasena1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(jPanelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(jPanelApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRegistroCuentaLayout.setVerticalGroup(
            panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jltitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRegistroCuentaLayout.createSequentialGroup()
                        .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLiconCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLiconMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelRegistroCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistroCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento comprobacion que los campos no esten vacios comprobacion que el
     * campo matricula y contraseña sean correctos MeodoCotraseña se le pasa
     * contraseña y genra un hash en y se guardan todos los datos den la tabla
     * usuarios
     *
     * @param evt
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

        if (jCheckBoxCoche.isSelected()) {
            esCoche = true;
        } else if (jCheckBoxMoto.isSelected()) {
            esCoche = false;
        }

        if (jtnombre.getText().isEmpty() || jtapellidos.getText().isEmpty() || jtemail.getText().isEmpty()
                || jtmatricula.getText().isEmpty() || jtcontrasena.getText().isEmpty() || jtrepetirContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de continuar", "Campos Incompletos", JOptionPane.ERROR_MESSAGE);
        } else if (jtnombre.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "El nombre debe contener al menos tres caracteres", "Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
        } else if (!MetodosContrasena.esCorreoElectronicoValido(jtemail.getText())) {
            JOptionPane.showMessageDialog(null, "El correo electronico no es valido", "Correo Electrnico Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else if (!MetodosRegistroCuenta.validarMatricula(jtmatricula.getText())) {
            JOptionPane.showMessageDialog(null, "La matrícula no es válida", "Matricula Incorrecta", JOptionPane.ERROR_MESSAGE);
        } else if (!jCheckBoxCoche.isSelected() && !jCheckBoxMoto.isSelected()) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado tipo de vehiculo", "Vehiculo", JOptionPane.ERROR_MESSAGE);
        } else if (jCheckBoxCoche.isSelected() && jCheckBoxMoto.isSelected()) {
            JOptionPane.showMessageDialog(null, "Solo puedes seleccionar un vehiculo", "Vehiculo", JOptionPane.ERROR_MESSAGE);
        } else {
            contrasena = jtcontrasena.getText();
            repetirContrasena = jtrepetirContrasena.getText();

            MetodosContrasena metodos = new MetodosContrasena();
            String hash = metodos.crearHashContrasena(contrasena, repetirContrasena);

            if (hash != null) {
                // Llamar al método guardar cuenta usuario
                if (MetodosRegistroCuenta.guardarCuentaUsuario(nombre, apellidos, jtemail.getText(), jtmatricula.getText(), hash, esCoche)) {
                    JOptionPane.showMessageDialog(null, "Se acaba de registrar el usuario " + nombre, "Correcto", JOptionPane.INFORMATION_MESSAGE);

                    InicioSesion is = new InicioSesion();
                    mostrarPanel(is.getPanelfondo());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la contraseña. " + nombre, "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_jbModificarActionPerformed

    /*
    /**
     * Evento compotamiento de los campos al seleccionar
     */
    private void jtnombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtnombreMouseClicked

        mrc.comportamientoCampos(jtnombre, "Nombre");

    }//GEN-LAST:event_jtnombreMouseClicked

    private void jtapellidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtapellidosMouseClicked
        mrc.comportamientoCampos(jtapellidos, "Apellidos");
    }//GEN-LAST:event_jtapellidosMouseClicked

    private void jtmatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtmatriculaMouseClicked
        mrc.comportamientoCampos(jtmatricula, "Matricula");
    }//GEN-LAST:event_jtmatriculaMouseClicked

    private void jtcontrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtcontrasenaMouseClicked
        mrc.comportamientoCampos(jtcontrasena, "********");
    }//GEN-LAST:event_jtcontrasenaMouseClicked

    private void jtrepetirContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtrepetirContrasenaMouseClicked
        mrc.comportamientoCampos(jtrepetirContrasena, "********");
    }//GEN-LAST:event_jtrepetirContrasenaMouseClicked

    private void jtemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtemailMouseClicked
        mrc.comportamientoCampos(jtemail, "Email");
    }//GEN-LAST:event_jtemailMouseClicked

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        InicioCuenta inicioCuenta = new InicioCuenta(usuario);
        mostrarPanel(inicioCuenta);
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Metodo elimina el panel actual y nos muestra el panel que se le pase
     *
     * @param panel
     */
    private void mostrarPanel(JPanel panel) {
        panel.setSize(428, 800);
        panel.setLocation(0, 0);
        panelRegistroCuenta.removeAll();
        panelRegistroCuenta.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        panelRegistroCuenta.revalidate();
        panelRegistroCuenta.repaint();
    }

    /**
     * Metodo crean la variables para que al leer el archivo de texto traducido
     * lo identifique
     */
    public void cambiarIdiomaEn() {

        Locale locale = new Locale("en");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mensajes/messages_en", locale);
        String titulo1 = resourceBundle.getString("RegistraTuCuenta");
        String titulo2 = resourceBundle.getString("YaRegistrasteTuCuenta?");
        String titulo3 = resourceBundle.getString("InicieSesiónORegístrese");

        String nombre = resourceBundle.getString("Nombre");
        String apellidos = resourceBundle.getString("Apellidos");
        String matricula = resourceBundle.getString("Matricula");
        String contrasena = resourceBundle.getString("Contraseña");
        String repetirContrasena = resourceBundle.getString("PrepetirContraseña");

        String registro = resourceBundle.getString("Registro");
        String borrar = resourceBundle.getString("Borrar");
        jltitulo1.setText(titulo1);
        jltitulo2.setText(titulo2);
        jltitulo3.setText(titulo3);
        // jbCancelar.setText(borrar);

        jlnombre.setText(nombre);
        jlapellidos.setText(apellidos);
        jlmatricula.setText(matricula);
        jlcontrasena.setText(contrasena);
        jlrepetirContrasena.setText(repetirContrasena);

        jtnombre.setText(nombre);
        jtapellidos.setText(apellidos);
        jtmatricula.setText(matricula);

        jbModificar.setText(registro);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrupovehiculos;
    private javax.swing.JCheckBox jCheckBoxCoche;
    private javax.swing.JCheckBox jCheckBoxMoto;
    private javax.swing.JLabel jLiconCoche;
    private javax.swing.JLabel jLiconMoto;
    private javax.swing.JLabel jNombre;
    private javax.swing.JPanel jPanelApellidos;
    private javax.swing.JPanel jPanelContrasena;
    private javax.swing.JPanel jPanelContrasena1;
    private javax.swing.JPanel jPanelEmail;
    private javax.swing.JPanel jPanelMatricula;
    private javax.swing.JPanel jPanelNombre;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JLabel jlapellidos;
    private javax.swing.JLabel jlcontrasena;
    private javax.swing.JLabel jlemail;
    private javax.swing.JLabel jlmatricula;
    private javax.swing.JLabel jlnombre;
    private javax.swing.JLabel jlrepetirContrasena;
    private javax.swing.JLabel jltitulo1;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JLabel jltitulo3;
    private javax.swing.JTextField jtapellidos;
    private javax.swing.JPasswordField jtcontrasena;
    private javax.swing.JTextField jtemail;
    private javax.swing.JTextField jtmatricula;
    private javax.swing.JTextField jtnombre;
    private javax.swing.JPasswordField jtrepetirContrasena;
    private vista.PanelRound panelRegistroCuenta;
    // End of variables declaration//GEN-END:variables

}
