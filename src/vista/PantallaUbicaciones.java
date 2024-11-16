package vista;

import javax.swing.*;

import modelo.UbicacionView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class PantallaUbicaciones extends JFrame {
    
    private static final String RUTA_BASE = "/Users/nicolasdamm/Desktop/Working Directory/POO_24C2_TPO_Grupo5/src/images/";
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

        // Panel principal con GridLayout 5x5
        JPanel panelPrincipal = new JPanel(new GridLayout(5, 5, 10, 10));
        panelPrincipal.setOpaque(false);
        
        // Crear paneles vacíos para el diseño
        for (int i = 0; i < 25; i++) {
            panelPrincipal.add(new JPanel() {{
                setOpaque(false);
            }});
        }

        // Crear cada botón individualmente y reemplazar los paneles vacíos correspondientes
        JButton botonPantano = crearBotonUbicacion("Pantano Oscuro", "pantano_oscuro.png");
        JButton botonMontanas = crearBotonUbicacion("Montañas Heladas", "montanas_heladas.png");
        JButton botonBosque = crearBotonUbicacion("Bosque de los Susurros", "bosque_de_los_susurros.png");
        JButton botonAldea = crearBotonUbicacion("Aldea de los Sirith", "aldea_de_los_sirith.png");
        JButton botonParamo = crearBotonUbicacion("Páramo Brumoso", "paramo_brumoso.png");
        JButton botonRuinas = crearBotonUbicacion("Ruinas de Lyrath", "ruinas_de_lyrath.png");
        JButton botonNeutral = crearBotonUbicacion("Ubicacion Neutral", "ubicacion_neutral.png");

        // Configurar ActionListener específico para cada botón
        botonPantano.addActionListener(e -> abrirPanelPantano());
        botonMontanas.addActionListener(e -> abrirPanelMontanas());
        botonBosque.addActionListener(e -> abrirPanelBosque());
        botonAldea.addActionListener(e -> abrirPanelAldea());
        botonParamo.addActionListener(e -> abrirPanelParamo());
        botonRuinas.addActionListener(e -> abrirPanelRuinas());
        botonNeutral.addActionListener(e -> abrirPanelNeutral());

        // Colocar los botones en el grid (posiciones específicas)
        panelPrincipal.remove(6);  // Fila 2, Columna 2
        panelPrincipal.add(botonPantano, 6);
        
        panelPrincipal.remove(7);  // Fila 2, Columna 3
        panelPrincipal.add(botonMontanas, 7);
        
        panelPrincipal.remove(8);  // Fila 2, Columna 4
        panelPrincipal.add(botonBosque, 8);
        
        panelPrincipal.remove(11);  // Fila 3, Columna 2
        panelPrincipal.add(botonAldea, 11);
        
        panelPrincipal.remove(12);  // Fila 3, Columna 3
        panelPrincipal.add(botonParamo, 12);
        
        panelPrincipal.remove(13);  // Fila 3, Columna 4
        panelPrincipal.add(botonRuinas, 13);
        
        panelPrincipal.remove(17);  // Fila 4, Columna 3 (centro)
        panelPrincipal.add(botonNeutral, 17);

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
                    
                    // Usar negro para todos los botones
                    Color fondoColor = new Color(0, 0, 0, 150);
                    
                    g.setColor(fondoColor);
                    g.fillRect(0, getHeight() - 25, getWidth(), 25);
                    
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
        
        int size = 120;
        boton.setPreferredSize(new Dimension(size, size));
        boton.setText(nombre);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBorderPainted(true);
        boton.setContentAreaFilled(false);
        
        return boton;
    }

    // Métodos para abrir los diferentes paneles
    private void abrirPanelPantano() {
        JFrame frame = new JFrame("Pantano Oscuro");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(50, 50, 50));
        panel.add(new JLabel("Panel del Pantano Oscuro") {{
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.BOLD, 20));
        }});
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void abrirPanelMontanas() {
        JFrame frame = new JFrame("Montañas Heladas");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(200, 220, 255));
        panel.add(new JLabel("Panel de las Montañas Heladas") {{
            setForeground(Color.BLACK);
            setFont(new Font("Arial", Font.BOLD, 20));
        }});
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void abrirPanelBosque() {
        JFrame frame = new JFrame("Bosque de los Susurros");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(34, 139, 34));
        panel.add(new JLabel("Panel del Bosque de los Susurros") {{
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.BOLD, 20));
        }});
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void abrirPanelAldea() {
        JFrame frame = new JFrame("Aldea de los Sirith");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(210, 180, 140));
        panel.add(new JLabel("Panel de la Aldea de los Sirith") {{
            setForeground(Color.BLACK);
            setFont(new Font("Arial", Font.BOLD, 20));
        }});
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void abrirPanelParamo() {
        JFrame frame = new JFrame("Páramo Brumoso");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 128));
        panel.add(new JLabel("Panel del Páramo Brumoso") {{
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.BOLD, 20));
        }});
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void abrirPanelRuinas() {
        JFrame frame = new JFrame("Ruinas de Lyrath");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(139, 69, 19));
        panel.add(new JLabel("Panel de las Ruinas de Lyrath") {{
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.BOLD, 20));
        }});
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void abrirPanelNeutral() {
        JFrame frame = new JFrame("Ubicación Neutral");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.add(new JLabel("Panel de la Ubicación Neutral") {{
            setForeground(Color.BLACK);
            setFont(new Font("Arial", Font.BOLD, 20));
        }});
        
        frame.add(panel);
        frame.setVisible(true);
    }   
}