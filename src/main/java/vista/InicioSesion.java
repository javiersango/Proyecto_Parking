/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.Color;


import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controlador.HibernateUtil;

/**
 *
 * @author Javier
 */
public class InicioSesion extends javax.swing.JFrame {
     int xMouse, yMouse;
     private ResourceBundle resourceBundle;
     private RecuperarContrasena recuperarContrasena;


    /**
     * Creates new form Incio
     */
    public InicioSesion() {
        initComponents();
        setLocationRelativeTo(null);
        
        // Cargar el idioma predeterminado (español)
        Locale defaultLocale = new Locale("es");
        resourceBundle = ResourceBundle.getBundle("mensajes/messages_es", defaultLocale);
        
        // Poner bordes redondos JFrame
        Shape forma = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30);
        setShape(forma);
        // Poner jTexfield y jBotton el radio
        jtnombre.putClientProperty("FlatLaf.style","arc: 15");
        jtcontrasena.putClientProperty("FlatLaf.style","arc: 15");
        jbiniciar.putClientProperty("FlatLaf.style","arc: 15");
        jbrecuperar.putClientProperty("FlatLaf.style","arc: 15");
        jbregistrarse.putClientProperty("FlatLaf.style","arc: 15");
        
        //jltitulo1.setFont(new java.awt.Font("Stencyl",Font.PLAIN, 23)); // NOI18N
        //jltitulo1.putClientProperty("FlatLaf.styleClass", "h0");
        jltitulo2.putClientProperty("FlatLaf.styleClass", "h0");
        jlo.putClientProperty("FlatLaf.styleClass", "h2");
      
        //añadir a los jTextField iconos
        jtnombre.putClientProperty( FlatClientProperties.TEXT_FIELD_LEADING_ICON,new FlatSVGIcon( "img/usuario.svg" ) );
        jtcontrasena.putClientProperty( FlatClientProperties.TEXT_FIELD_LEADING_ICON,new FlatSVGIcon( "img/candadoCerrado.svg" ) );
        
        
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
        }, 0, 10000); // Actualiza cada segundo (1000 ms)
        
    }
    
       private void updateBatteryLevel() {
        // Lógica para obtener el nivel de la batería (simulado aquí)
        int batteryLevel = obtenerNivelBateria();

       // Actualiza el JLabel con el nivel de la batería
        jLporcentajeBateria.setText( batteryLevel + "%");
        
    }

    // Método de ejemplo para obtener el nivel de la batería (simulado)
    private int obtenerNivelBateria() {
        AtomicInteger atomicBatteryLevel = new AtomicInteger((int) (Math.random() * 100));
        return atomicBatteryLevel.get();
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
        jLlogoParking = new javax.swing.JLabel();
        jltitulo1 = new javax.swing.JLabel();
        jltitulo2 = new javax.swing.JLabel();
        jPanelNombre = new javax.swing.JPanel();
        jlnombre = new javax.swing.JLabel();
        jtnombre = new javax.swing.JTextField();
        jbiniciar = new javax.swing.JButton();
        jbregistrarse = new javax.swing.JButton();
        jlo = new javax.swing.JLabel();
        jbrecuperar = new javax.swing.JButton();
        jpanelContrasena = new javax.swing.JPanel();
        jlcontrasena = new javax.swing.JLabel();
        jtcontrasena = new javax.swing.JPasswordField();
        panelRoundBarraFondo = new vista.PanelRound();
        jLporcentajeBateria = new javax.swing.JLabel();
        jLsignal = new javax.swing.JLabel();
        jLwifi = new javax.swing.JLabel();
        jLiconoBateria = new javax.swing.JLabel();
        panelRoundFondoCierre = new vista.PanelRound();
        jLcierre = new javax.swing.JLabel();
        jLtime = new javax.swing.JLabel();
        jlingles = new javax.swing.JLabel();
        jlespana = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRoundFondo.setBackground(new java.awt.Color(249, 251, 255));
        panelRoundFondo.setMaximumSize(null);
        panelRoundFondo.setPreferredSize(new java.awt.Dimension(428, 800));
        panelRoundFondo.setRoundBottomLeft(30);
        panelRoundFondo.setRoundBottomRight(30);

        jLlogoParking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/LogoParking.png"))); // NOI18N
        jLlogoParking.setText("jLabel1");

        jltitulo1.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jltitulo1.setForeground(new java.awt.Color(39, 59, 244));
        jltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo1.setText("¿BUSCAS PLAZAS DE APARCAMIENTO?");
        jltitulo1.setPreferredSize(new java.awt.Dimension(273, 30));

        jltitulo2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jltitulo2.setForeground(new java.awt.Color(25, 35, 66));
        jltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo2.setText("Inicie sesión o regístrese");
        jltitulo2.setPreferredSize(new java.awt.Dimension(273, 30));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtnombreMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNombreLayout = new javax.swing.GroupLayout(jPanelNombre);
        jPanelNombre.setLayout(jPanelNombreLayout);
        jPanelNombreLayout.setHorizontalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreLayout.createSequentialGroup()
                .addComponent(jlnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNombreLayout.setVerticalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreLayout.createSequentialGroup()
                .addComponent(jlnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbiniciar.setBackground(new java.awt.Color(39, 59, 244));
        jbiniciar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbiniciar.setForeground(new java.awt.Color(255, 255, 255));
        jbiniciar.setText("Iniciar sesión");
        jbiniciar.setToolTipText("Boton incia sesion aplicacion");
        jbiniciar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbiniciarActionPerformed(evt);
            }
        });

        jbregistrarse.setBackground(new java.awt.Color(39, 59, 244));
        jbregistrarse.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbregistrarse.setForeground(new java.awt.Color(255, 255, 255));
        jbregistrarse.setText("Registrarse");
        jbregistrarse.setToolTipText("Botón para registra nuevo usuario");
        jbregistrarse.setPreferredSize(new java.awt.Dimension(124, 49));
        jbregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbregistrarseActionPerformed(evt);
            }
        });

        jlo.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlo.setForeground(new java.awt.Color(0, 0, 0));
        jlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlo.setText("o");
        jlo.setPreferredSize(new java.awt.Dimension(24, 27));

        jbrecuperar.setBackground(new java.awt.Color(39, 59, 244));
        jbrecuperar.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jbrecuperar.setForeground(new java.awt.Color(255, 255, 255));
        jbrecuperar.setText("Recuperar contraseña");
        jbrecuperar.setToolTipText("Botón para recuparar contraseña ");
        jbrecuperar.setActionCommand("Registrarse");
        jbrecuperar.setPreferredSize(new java.awt.Dimension(124, 49));
        jbrecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbrecuperarActionPerformed(evt);
            }
        });

        jpanelContrasena.setBackground(new java.awt.Color(249, 251, 255));
        jpanelContrasena.setPreferredSize(new java.awt.Dimension(335, 82));

        jlcontrasena.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlcontrasena.setForeground(new java.awt.Color(25, 35, 66));
        jlcontrasena.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlcontrasena.setText("Contraseña");
        jlcontrasena.setPreferredSize(new java.awt.Dimension(51, 17));

        jtcontrasena.setBackground(new java.awt.Color(198, 212, 255));
        jtcontrasena.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        jtcontrasena.setForeground(new java.awt.Color(153, 153, 153));
        jtcontrasena.setText("********");
        jtcontrasena.setToolTipText("Introduce una contraseña entre 8 y 10 caracteres");
        jtcontrasena.setPreferredSize(new java.awt.Dimension(335, 50));
        jtcontrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtcontrasenaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpanelContrasenaLayout = new javax.swing.GroupLayout(jpanelContrasena);
        jpanelContrasena.setLayout(jpanelContrasenaLayout);
        jpanelContrasenaLayout.setHorizontalGroup(
            jpanelContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelContrasenaLayout.createSequentialGroup()
                .addGroup(jpanelContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelContrasenaLayout.createSequentialGroup()
                        .addComponent(jlcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelContrasenaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpanelContrasenaLayout.setVerticalGroup(
            jpanelContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelContrasenaLayout.createSequentialGroup()
                .addComponent(jlcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRoundFondoLayout = new javax.swing.GroupLayout(panelRoundFondo);
        panelRoundFondo.setLayout(panelRoundFondoLayout);
        panelRoundFondoLayout.setHorizontalGroup(
            panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jltitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRoundFondoLayout.createSequentialGroup()
                .addGroup(panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundFondoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLlogoParking, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundFondoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundFondoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpanelContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jbrecuperar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRoundFondoLayout.createSequentialGroup()
                                    .addComponent(jbiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbregistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRoundFondoLayout.setVerticalGroup(
            panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundFondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLlogoParking, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jltitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpanelContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelRoundFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbregistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbrecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(panelRoundFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 760));

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
        jLsignal.setPreferredSize(new java.awt.Dimension(17, 13));

        jLwifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Wifi.png"))); // NOI18N
        jLwifi.setText("jLabel2");
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

        jLtime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLtime.setForeground(new java.awt.Color(0, 0, 0));
        jLtime.setPreferredSize(new java.awt.Dimension(17, 13));

        jlingles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlingles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/ingles.png"))); // NOI18N
        jlingles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlinglesMouseClicked(evt);
            }
        });

        jlespana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlespana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/espana.png"))); // NOI18N
        jlespana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlespanaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRoundBarraFondoLayout = new javax.swing.GroupLayout(panelRoundBarraFondo);
        panelRoundBarraFondo.setLayout(panelRoundBarraFondoLayout);
        panelRoundBarraFondoLayout.setHorizontalGroup(
            panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBarraFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLtime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jlespana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlingles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jLsignal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLwifi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLiconoBateria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLporcentajeBateria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRoundFondoCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRoundBarraFondoLayout.setVerticalGroup(
            panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundFondoCierre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRoundBarraFondoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlespana, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlingles, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRoundBarraFondoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLporcentajeBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRoundBarraFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLiconoBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLwifi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLsignal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(panelRoundBarraFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 41));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLcierreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLcierreMouseMoved
        panelRoundFondoCierre.setBackground(Color.lightGray);
    }//GEN-LAST:event_jLcierreMouseMoved

    private void jLcierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLcierreMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLcierreMouseClicked
    
    private void jLcierreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLcierreMouseExited
        panelRoundFondoCierre.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLcierreMouseExited

    private void panelRoundBarraFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoundBarraFondoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_panelRoundBarraFondoMouseDragged
    /** Evento en el que devuelve la posicion cada vez que se mueve y se establece */
    private void panelRoundBarraFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoundBarraFondoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelRoundBarraFondoMousePressed
    /** Metodo visulaizacion del jTextField nombre*/
    private void jtnombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtnombreMousePressed
       if ( jtnombre.getText().equals("Nombre")){
        
          jtnombre.setText("");
          jtnombre.setForeground(Color.black);
          
      }
      if (String.valueOf(jtcontrasena.getPassword()).isEmpty()){
          jtcontrasena.setText("********");
          jtcontrasena.setForeground(Color.gray);
      }   
    }//GEN-LAST:event_jtnombreMousePressed

   /** Metodo comprobacion que no estan vacios los campos datos nombre y contraseña*/
    private void jbiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbiniciarActionPerformed
       String nombre = jtnombre.getText();
       String contraseña = String.valueOf(jtcontrasena.getPassword());

    if (nombre.isEmpty() || nombre.equals("Nombre") || contraseña.isEmpty() || contraseña.equals("********")) {
        JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos", "Error", JOptionPane.WARNING_MESSAGE);
    } else if (!validarNombre(nombre)) {
        JOptionPane.showMessageDialog(null, "El nombre debe contener al menos tres letras", "Error", JOptionPane.WARNING_MESSAGE);
    } else if (!validarContraseña(contraseña)) {
        JOptionPane.showMessageDialog(null, "La contraseña debe contener entre 8 y 10 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
    } else {
        jtnombre.setText("");
        jtnombre.setEnabled(false);
        jtcontrasena.setText("");
        jtcontrasena.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Se han introducido los datos", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        
    } 

    }//GEN-LAST:event_jbiniciarActionPerformed
    /** Evento cuanto se selecciona el texto se pone en negrita y si no esta selecciado lo deja como estaba al inicio */
    private void jtcontrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtcontrasenaMousePressed
    if ( String.valueOf(jtcontrasena.getPassword()).equals("********")){
          jtcontrasena.setText("");
          jtcontrasena.setForeground(Color.black);
          
      } else {
          jtcontrasena.setForeground(new Color (0,0,0)); 
      }
          
      if (jtnombre.getText().isEmpty()){
          jtnombre.setText("Nombre");
          jtnombre.setForeground(Color.gray);
      } else {
          jtnombre.setForeground(new Color (0,0,0)); 
      }  
    }//GEN-LAST:event_jtcontrasenaMousePressed

    private void jlinglesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlinglesMouseClicked
      // Cambia por defecto a ingles
      Locale defaultLocale = new Locale("en");
      // Cargar el idioma ingles
      resourceBundle = ResourceBundle.getBundle("mensajes/messages_en", defaultLocale);

      // Obtener las cadenas de texto en ingles
      String titulo1 = resourceBundle.getString("buscasPlazasDeAparcamiento");
      String titulo2 = resourceBundle.getString("InicieSesionOregistrarse");
      String lNombre = resourceBundle.getString("nombre");
      String lContrasena = resourceBundle.getString("contrasena");

      String bInciar = resourceBundle.getString("iniciarSesion");
      String bRegistro = resourceBundle.getString("registrarse");
      String bRecuperar = resourceBundle.getString("recuperarContrasena");

      // Establecer el texto en los componentes
      jltitulo1.setText(titulo1);
      jltitulo2.setText(titulo2);
      jlnombre.setText(lNombre);
      jtnombre.setText(lNombre);
      jlcontrasena.setText(lContrasena);
      jbiniciar.setText(bInciar);
      jbregistrarse.setText(bRegistro);
      jbrecuperar.setText(bRecuperar);
      
       
       // Llama al método cambiarIdioma de la instancia de RecuperarContrasena si es necesario
    if (recuperarContrasena != null) {
        recuperarContrasena.cambiarIdioma();
    }
    
        
    }//GEN-LAST:event_jlinglesMouseClicked

    private void jlespanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlespanaMouseClicked
      // Cambia por defecto a ingles
      Locale defaultLocale = new Locale("es");
      // Cargar el idioma ingles
      resourceBundle = ResourceBundle.getBundle("mensajes/messages_es", defaultLocale);
      // Obtener las traducciones en español de las cadenas de texto en ingles
      String titulo1 = resourceBundle.getString("AreYouLookingForParkingSpaces?");
      String titulo2 = resourceBundle.getString("LogInOrRegister");
      String lNombre = resourceBundle.getString("Name");
      String lContrasena = resourceBundle.getString("Password");
      String bInciar = resourceBundle.getString("LogIn");
      String bRegistro = resourceBundle.getString("Register");
      String bRecuperar = resourceBundle.getString("RecoverPassword");

      // Establecer el texto en los componentes
      jltitulo1.setText(titulo1);
      jltitulo2.setText(titulo2);
      jlnombre.setText(lNombre);
      jtnombre.setText(lNombre);
      jlcontrasena.setText(lContrasena);
      jbiniciar.setText(bInciar);
      jbregistrarse.setText(bRegistro);
      jbrecuperar.setText(bRecuperar);

    }//GEN-LAST:event_jlespanaMouseClicked

    private void jbrecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbrecuperarActionPerformed
                                      
    // Crear una nueva instancia de RecuperarContraseña
    RecuperarContrasena recuperarContraseña = new RecuperarContrasena();  
    // Hacer visible el nuevo JFrame de RecuperarContraseña
    recuperarContraseña.setVisible(true);

    }//GEN-LAST:event_jbrecuperarActionPerformed

    private void jbregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbregistrarseActionPerformed
      
     RegistroCuenta panelRegistroCuenta = new RegistroCuenta();
     mostrarPanel( panelRegistroCuenta );

     HibernateUtil hibernate = new HibernateUtil();
     hibernate.conectar();
     hibernate.mostrarDatosUsuarios();
     hibernate.desconectar();
    
    }//GEN-LAST:event_jbregistrarseActionPerformed

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }
    /**Metodo  verifica que el nombre tenga al menos tres letras*/
    private boolean validarNombre(String nombre) {
    return nombre.length() >= 3;
}
    /**Metodo verifica que la contraseña tenga al menos 8 caracteres y como máximo 10 caracteres*/
    private boolean validarContraseña(String contraseña) {
    return contraseña.length() >= 8 && contraseña.length() <= 10;
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLcierre;
    private javax.swing.JLabel jLiconoBateria;
    private javax.swing.JLabel jLlogoParking;
    private javax.swing.JLabel jLporcentajeBateria;
    private javax.swing.JLabel jLsignal;
    private javax.swing.JLabel jLtime;
    private javax.swing.JLabel jLwifi;
    private javax.swing.JPanel jPanelNombre;
    private javax.swing.JButton jbiniciar;
    private javax.swing.JButton jbrecuperar;
    private javax.swing.JButton jbregistrarse;
    private javax.swing.JLabel jlcontrasena;
    private javax.swing.JLabel jlespana;
    private javax.swing.JLabel jlingles;
    private javax.swing.JLabel jlnombre;
    private javax.swing.JLabel jlo;
    private javax.swing.JLabel jltitulo1;
    private javax.swing.JLabel jltitulo2;
    private javax.swing.JPanel jpanelContrasena;
    private javax.swing.JPasswordField jtcontrasena;
    private javax.swing.JTextField jtnombre;
    private vista.PanelRound panelRoundBarraFondo;
    private vista.PanelRound panelRoundFondo;
    private vista.PanelRound panelRoundFondoCierre;
    // End of variables declaration//GEN-END:variables

    private void mostrarPanel(JPanel panel) {
       panel.setSize(428, 800);
       panel.setLocation(0,0);  
       
       panelRoundFondo.removeAll();
       panelRoundFondo.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
       panelRoundFondo.revalidate();
       panelRoundFondo.repaint();
    }

   

}
