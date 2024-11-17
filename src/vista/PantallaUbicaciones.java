package vista;

import controlador.Controlador;
import modelo.UbicacionView;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class PantallaUbicaciones extends JFrame {

    private static final String RUTA_BASE = "src/images/";

    public PantallaUbicaciones() {
        // Configuración básica de la ventana
        setTitle("Selecciona tu Destino");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear contenedor personalizado para el fondo
        Container contenedor = new Container();
        contenedor.setLayout(new BorderLayout());

        // Configurar imagen de fondo
        ImageIcon iconoFondo = new ImageIcon(RUTA_BASE + "mapaUbicaciones.png");
        Image imagenFondo = iconoFondo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel fondo = new JLabel(new ImageIcon(imagenFondo));
        fondo.setLayout(new BorderLayout());
        contenedor.add(fondo);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(false); // Panel transparente

        JLabel labelTitulo = new JLabel("Elige tu próximo destino");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        labelTitulo.setForeground(Color.BLACK);
        labelTitulo.setBackground(new Color(255, 255, 255, 190)); // Fondo blanco con 50% de opacidad
        labelTitulo.setOpaque(true); // Activar el fondo del JLabel
        labelTitulo.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16)); // Agregar padding al texto

        panelTitulo.add(labelTitulo); // Añadir el JLabel al panel





        // Panel principal que contendrá todos los paneles de ubicaciones
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setOpaque(false);

        // Obtener ubicaciones del controlador
        List<UbicacionView> listaUbicaciones = Controlador.mostrarMapa();
        List<Boolean> ubicacionActiva = new ArrayList<>();

        // Llenar la lista de booleanos
        for (UbicacionView ubicacion : listaUbicaciones) {
            ubicacionActiva.add(ubicacion.getEstaActivo());
        }

        try {
            // Aldea de los Sirith
            if (ubicacionActiva.get(0)) {
                JPanel panelAldea = new JPanel();
                panelAldea.setLayout(new BorderLayout());
                panelAldea.setOpaque(false);

                JButton botonAldea = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        try {
                            Image img = new ImageIcon(RUTA_BASE + "aldea_de_los_sirith.png").getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                            Color fondoColor = new Color(0, 0, 0, 150);
                            g.setColor(fondoColor);
                            g.fillRect(0, getHeight() - 25, getWidth(), 25);

                            g.setColor(Color.WHITE);
                            FontMetrics fm = g.getFontMetrics();
                            int textWidth = fm.stringWidth(getText());
                            g.drawString(getText(), (getWidth() - textWidth) / 2,
                                    getHeight() - (25 - fm.getHeight()) / 2);
                        } catch (Exception e) {
                            System.out.println("Error al cargar: aldea_de_los_sirith.png");
                            e.printStackTrace();
                        }
                    }
                };

                botonAldea.setPreferredSize(new Dimension(120, 120));
                botonAldea.setText("Aldea de los Sirith");
                botonAldea.setFont(new Font("Arial", Font.BOLD, 12));
                botonAldea.setBorderPainted(true);
                botonAldea.setContentAreaFilled(false);

                botonAldea.addActionListener(e -> {
                    PantallaPelea pantallaPelea = new PantallaPelea(listaUbicaciones.get(0));
                    pantallaPelea.setVisible(true);
                    this.dispose();
                });

                panelAldea.add(botonAldea, BorderLayout.CENTER);
                panelPrincipal.add(panelAldea);
            }

            // Ruinas de Lyrath
            if (ubicacionActiva.get(1)) {
                JPanel panelRuinas = new JPanel();
                panelRuinas.setLayout(new BorderLayout());
                panelRuinas.setOpaque(false);

                JButton botonRuinas = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        try {
                            Image img = new ImageIcon(RUTA_BASE + "ruinas_de_lyrath.png").getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                            Color fondoColor = new Color(0, 0, 0, 150);
                            g.setColor(fondoColor);
                            g.fillRect(0, getHeight() - 25, getWidth(), 25);

                            g.setColor(Color.WHITE);
                            FontMetrics fm = g.getFontMetrics();
                            int textWidth = fm.stringWidth(getText());
                            g.drawString(getText(), (getWidth() - textWidth) / 2,
                                    getHeight() - (25 - fm.getHeight()) / 2);
                        } catch (Exception e) {
                            System.out.println("Error al cargar: ruinas_de_lyrath.png");
                            e.printStackTrace();
                        }
                    }
                };

                botonRuinas.setPreferredSize(new Dimension(120, 120));
                botonRuinas.setText("Ruinas de Lyrath");
                botonRuinas.setFont(new Font("Arial", Font.BOLD, 12));
                botonRuinas.setBorderPainted(true);
                botonRuinas.setContentAreaFilled(false);

                botonRuinas.addActionListener(e -> {
                    PantallaPelea pantallaPelea = new PantallaPelea(listaUbicaciones.get(1));
                    pantallaPelea.setVisible(true);
                    this.dispose();
                });

                panelRuinas.add(botonRuinas, BorderLayout.CENTER);
                panelPrincipal.add(panelRuinas);
            }

            // Pantano Oscuro
            if (ubicacionActiva.get(2)) {
                JPanel panelPantano = new JPanel();
                panelPantano.setLayout(new BorderLayout());
                panelPantano.setOpaque(false);

                JButton botonPantano = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        try {
                            Image img = new ImageIcon(RUTA_BASE + "pantano_oscuro.png").getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                            Color fondoColor = new Color(0, 0, 0, 150);
                            g.setColor(fondoColor);
                            g.fillRect(0, getHeight() - 25, getWidth(), 25);

                            g.setColor(Color.WHITE);
                            FontMetrics fm = g.getFontMetrics();
                            int textWidth = fm.stringWidth(getText());
                            g.drawString(getText(), (getWidth() - textWidth) / 2,
                                    getHeight() - (25 - fm.getHeight()) / 2);
                        } catch (Exception e) {
                            System.out.println("Error al cargar: pantano_oscuro.png");
                            e.printStackTrace();
                        }
                    }
                };

                botonPantano.setPreferredSize(new Dimension(120, 120));
                botonPantano.setText("Pantano Oscuro");
                botonPantano.setFont(new Font("Arial", Font.BOLD, 12));
                botonPantano.setBorderPainted(true);
                botonPantano.setContentAreaFilled(false);

                botonPantano.addActionListener(e -> {
                    PantallaPelea pantallaPelea = new PantallaPelea(listaUbicaciones.get(2));
                    pantallaPelea.setVisible(true);
                    this.dispose();
                });

                panelPantano.add(botonPantano, BorderLayout.CENTER);
                panelPrincipal.add(panelPantano);
            }

            // Bosque de los Susurros
            if (ubicacionActiva.get(3)) {
                JPanel panelBosque = new JPanel();
                panelBosque.setLayout(new BorderLayout());
                panelBosque.setOpaque(false);

                JButton botonBosque = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        try {
                            Image img = new ImageIcon(RUTA_BASE + "bosque_de_los_susurros.png").getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                            Color fondoColor = new Color(0, 0, 0, 150);
                            g.setColor(fondoColor);
                            g.fillRect(0, getHeight() - 25, getWidth(), 25);

                            g.setColor(Color.WHITE);
                            FontMetrics fm = g.getFontMetrics();
                            int textWidth = fm.stringWidth(getText());
                            g.drawString(getText(), (getWidth() - textWidth) / 2,
                                    getHeight() - (25 - fm.getHeight()) / 2);
                        } catch (Exception e) {
                            System.out.println("Error al cargar: bosque_de_los_susurros.png");
                            e.printStackTrace();
                        }
                    }
                };

                botonBosque.setPreferredSize(new Dimension(120, 120));
                botonBosque.setText("Bosque de los Susurros");
                botonBosque.setFont(new Font("Arial", Font.BOLD, 12));
                botonBosque.setBorderPainted(true);
                botonBosque.setContentAreaFilled(false);

                botonBosque.addActionListener(e -> {
                    PantallaPelea pantallaPelea = new PantallaPelea(listaUbicaciones.get(3));
                    pantallaPelea.setVisible(true);
                    this.dispose();
                });

                panelBosque.add(botonBosque, BorderLayout.CENTER);
                panelPrincipal.add(panelBosque);
            }

            // Páramo Brumoso
            if (ubicacionActiva.get(4)) {
                JPanel panelParamo = new JPanel();
                panelParamo.setLayout(new BorderLayout());
                panelParamo.setOpaque(false);

                JButton botonParamo = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        try {
                            Image img = new ImageIcon(RUTA_BASE + "paramo_brumoso.png").getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                            Color fondoColor = new Color(0, 0, 0, 150);
                            g.setColor(fondoColor);
                            g.fillRect(0, getHeight() - 25, getWidth(), 25);

                            g.setColor(Color.WHITE);
                            FontMetrics fm = g.getFontMetrics();
                            int textWidth = fm.stringWidth(getText());
                            g.drawString(getText(), (getWidth() - textWidth) / 2,
                                    getHeight() - (25 - fm.getHeight()) / 2);
                        } catch (Exception e) {
                            System.out.println("Error al cargar: paramo_brumoso.png");
                            e.printStackTrace();
                        }
                    }
                };

                botonParamo.setPreferredSize(new Dimension(120, 120));
                botonParamo.setText("Páramo Brumoso");
                botonParamo.setFont(new Font("Arial", Font.BOLD, 12));
                botonParamo.setBorderPainted(true);
                botonParamo.setContentAreaFilled(false);

                botonParamo.addActionListener(e -> {
                    PantallaPelea pantallaPelea = new PantallaPelea(listaUbicaciones.get(4));
                    pantallaPelea.setVisible(true);
                    this.dispose();
                });

                panelParamo.add(botonParamo, BorderLayout.CENTER);
                panelPrincipal.add(panelParamo);
            }

            // Montañas Heladas
            if (ubicacionActiva.get(5)) {
                JPanel panelMontanas = new JPanel();
                panelMontanas.setLayout(new BorderLayout());
                panelMontanas.setOpaque(false);

                JButton botonMontanas = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        try {
                            Image img = new ImageIcon(RUTA_BASE + "montanas_heladas.png").getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                            Color fondoColor = new Color(0, 0, 0, 150);
                            g.setColor(fondoColor);
                            g.fillRect(0, getHeight() - 25, getWidth(), 25);

                            g.setColor(Color.WHITE);
                            FontMetrics fm = g.getFontMetrics();
                            int textWidth = fm.stringWidth(getText());
                            g.drawString(getText(), (getWidth() - textWidth) / 2,
                                    getHeight() - (25 - fm.getHeight()) / 2);
                        } catch (Exception e) {
                            System.out.println("Error al cargar: montanas_heladas.png");
                            e.printStackTrace();
                        }
                    }
                };

                botonMontanas.setPreferredSize(new Dimension(120, 120));
                botonMontanas.setText("Montañas Heladas");
                botonMontanas.setFont(new Font("Arial", Font.BOLD, 12));
                botonMontanas.setBorderPainted(true);
                botonMontanas.setContentAreaFilled(false);

                botonMontanas.addActionListener(e -> {
                    PantallaPelea pantallaPelea = new PantallaPelea(listaUbicaciones.get(5));
                    pantallaPelea.setVisible(true);
                    this.dispose();
                });

                panelMontanas.add(botonMontanas, BorderLayout.CENTER);
                panelPrincipal.add(panelMontanas);
            }

            // Ubicación Neutral
            if (ubicacionActiva.get(6)) {
                JPanel panelNeutral = new JPanel();
                panelNeutral.setLayout(new BorderLayout());
                panelNeutral.setOpaque(false);

                JButton botonNeutral = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        try {
                            Image img = new ImageIcon(RUTA_BASE + "ubicacion_neutral.png").getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                            Color fondoColor = new Color(0, 0, 0, 150);
                            g.setColor(fondoColor);
                            g.fillRect(0, getHeight() - 25, getWidth(), 25);

                            g.setColor(Color.WHITE);
                            FontMetrics fm = g.getFontMetrics();
                            int textWidth = fm.stringWidth(getText());
                            g.drawString(getText(), (getWidth() - textWidth) / 2,
                                    getHeight() - (25 - fm.getHeight()) / 2);
                        } catch (Exception e) {
                            System.out.println("Error al cargar: ubicacion_neutral.png");
                            e.printStackTrace();
                        }
                    }
                };

                botonNeutral.setPreferredSize(new Dimension(120, 120));
                botonNeutral.setText("Ubicación Neutral");
                botonNeutral.setFont(new Font("Arial", Font.BOLD, 12));
                botonNeutral.setBorderPainted(true);
                botonNeutral.setContentAreaFilled(false);


                //CAMBIAR A UBICACION NEUTRAL
                botonNeutral.addActionListener(e -> {
                    PantallaPelea pantallaPelea = new PantallaPelea(listaUbicaciones.get(6));
                    pantallaPelea.setVisible(true);
                    this.dispose();
                });

                panelNeutral.add(botonNeutral, BorderLayout.CENTER);
                panelPrincipal.add(panelNeutral);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: No hay suficientes ubicaciones en la lista");
            e.printStackTrace();
        }

        // Agregar título y panel principal al fondo
        fondo.add(panelTitulo, BorderLayout.NORTH);
        fondo.add(panelPrincipal, BorderLayout.CENTER);

        // Agregar el contenedor a la ventana
        add(contenedor);
    }
}