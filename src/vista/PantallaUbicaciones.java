package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaUbicaciones extends JFrame {
    
    private static final String RUTA_BASE = "/Users/nicolasdamm/Desktop/Working Directory/POO_24C2_TPO_Grupo5/FotosUbicaciones/";
    private JWindow notificacion;

    public PantallaUbicaciones() {
        setTitle("Selecciona tu Destino");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container customContainer = new Container();
        customContainer.setLayout(new BorderLayout());

        // Fondo
        ImageIcon backgroundImageIcon = new ImageIcon(RUTA_BASE + "fondo.png");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setLayout(new BorderLayout());
        customContainer.add(background);

        // Título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(false);
        JLabel labelTitulo = new JLabel("Elige tu próximo destino");
        labelTitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
        labelTitulo.setForeground(Color.BLACK);
        panelTitulo.add(labelTitulo);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new GridLayout(6, 4, 10, 10));
        panelPrincipal.setOpaque(false);

        // Array de información de ubicaciones
        String[][] ubicaciones = {
            {"Pantano Oscuro", "pantano_oscuro.png"},
            {"Montañas Heladas", "montanas_heladas.png"},
            {"Bosque de los Susurros", "bosque_de_los_susurros.png"},
            {"Aldea de los Sirith", "aldea_de_los_sirith.png"},
            {"Cañón del Crepúsculo", "canon_del_crepusculo.png"},
            {"Cueva de los Ecos", "cueva_de_los_ecos.png"},
            {"Páramo Brumoso", "paramo_brumoso.png"},
            {"Ruinas de Lyrath", "ruinas_de_lyrath.png"}
        };

        // Crear y colocar los botones en el grid
        int ubicacionIndex = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if ((j == 1 || j == 2) && (i >= 1 && i <= 4)) {
                    if (ubicacionIndex < ubicaciones.length) {
                        JButton boton = crearBotonUbicacion(
                            ubicaciones[ubicacionIndex][0], 
                            ubicaciones[ubicacionIndex][1]
                        );
                        panelPrincipal.add(boton);
                        ubicacionIndex++;
                    }
                } else {
                    JPanel panelVacio = new JPanel();
                    panelVacio.setOpaque(false);
                    panelPrincipal.add(panelVacio);
                }
            }
        }

        background.add(panelTitulo, BorderLayout.NORTH);
        background.add(panelPrincipal, BorderLayout.CENTER);
        this.add(customContainer);
    }

    private JButton crearBotonUbicacion(String nombre, String rutaImagen) {
        JButton boton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    Image img = new ImageIcon(RUTA_BASE + rutaImagen).getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                    
                    // Fondo semi-transparente para el texto con diferentes colores
                    Color fondoColor;
                    switch(nombre) {
                        case "Pantano Oscuro":
                        case "Cañón del Crepúsculo":
                        case "Ruinas de Lyrath":
                            fondoColor = new Color(139, 0, 0, 150); // Rojo oscuro semi-transparente
                            break;
                        case "Bosque de los Susurros":
                        case "Páramo Brumoso":
                        case "Cueva de los Ecos":
                            fondoColor = new Color(0, 100, 0, 150); // Verde oscuro semi-transparente
                            break;
                        default:
                            fondoColor = new Color(0, 0, 0, 150); // Negro semi-transparente
                    }
                    
                    g.setColor(fondoColor);
                    g.fillRect(0, getHeight() - 25, getWidth(), 25);
                    
                    // Dibujar el texto
                    g.setColor(Color.WHITE);
                    FontMetrics fm = g.getFontMetrics();
                    int textWidth = fm.stringWidth(getText());
                    g.drawString(getText(), (getWidth() - textWidth) / 2, 
                               getHeight() - (25 - fm.getHeight()) / 2);
                } catch (Exception e) {
                    System.out.println("Error al cargar: " + rutaImagen);
                    e.printStackTrace();
                }
            }
        };
        
        // Configuración del botón
        int size = 120;
        boton.setPreferredSize(new Dimension(size, size));
        boton.setText(nombre);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBorderPainted(true);
        boton.setContentAreaFilled(false);
        
        // ActionListener
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarNotificacion("Seleccionaste la ubicacion: " + nombre);
            }
        });
        
        return boton;
    }

    private void mostrarNotificacion(String mensaje) {
        notificacion = new JWindow();
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 200));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        JLabel texto = new JLabel(mensaje);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Arial", Font.BOLD, 14));
        texto.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        panel.add(texto);
        notificacion.add(panel);
        notificacion.pack();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        notificacion.setLocation(
            screenSize.width - notificacion.getWidth() - 20,
            20
        );
        
        notificacion.setVisible(true);
        
        Timer timer = new Timer(2000, e -> notificacion.dispose());
        timer.setRepeats(false);
        timer.start();
    }
}