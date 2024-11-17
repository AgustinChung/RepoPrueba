package vista;

import controlador.Controlador;
import modelo.UbicacionView;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class PantallaUbicaciones extends JFrame {

    private static final String RUTA_BASE = "../images/";

    public PantallaUbicaciones() {
        // Configuración básica de la ventana
        setTitle("Selecciona tu Destino");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear contenedor personalizado para el fondo
        Container contenedor = new Container();
        contenedor.setLayout(new BorderLayout());

        // Configurar imagen de fondo
        ImageIcon iconoFondo = new ImageIcon(RUTA_BASE + "fondo.png");
        Image imagenFondo = iconoFondo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel fondo = new JLabel(new ImageIcon(imagenFondo));
        fondo.setLayout(new BorderLayout());
        contenedor.add(fondo);

        // Panel para el título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(false);
        JLabel labelTitulo = new JLabel("Elige tu próximo destino");
        labelTitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
        labelTitulo.setForeground(Color.BLACK);
        panelTitulo.add(labelTitulo);

        // Panel principal que contendrá todos los paneles de ubicaciones
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setOpaque(false);

        // Crear los paneles de cada ubicación con sus imágenes
        JPanel panelPantano = crearPanelUbicacion("Pantano Oscuro", "pantano_oscuro.png");
        JPanel panelMontanas = crearPanelUbicacion("Montañas Heladas", "montanas_heladas.png");
        JPanel panelBosque = crearPanelUbicacion("Bosque de los Susurros", "bosque_de_los_susurros.png");
        JPanel panelAldea = crearPanelUbicacion("Aldea de los Sirith", "aldea_de_los_sirith.png");
        JPanel panelParamo = crearPanelUbicacion("Páramo Brumoso", "paramo_brumoso.png");
        JPanel panelRuinas = crearPanelUbicacion("Ruinas de Lyrath", "ruinas_de_lyrath.png");
        JPanel panelNeutral = crearPanelUbicacion("Ubicacion Neutral", "ubicacion_neutral.png");

        // Hacer los paneles transparentes
        panelPantano.setOpaque(false);
        panelMontanas.setOpaque(false);
        panelBosque.setOpaque(false);
        panelAldea.setOpaque(false);
        panelParamo.setOpaque(false);
        panelRuinas.setOpaque(false);
        panelNeutral.setOpaque(false);

        // Usar ArrayList en lugar de List para la inicialización
        List<Boolean> ubicacionActiva = new ArrayList<>();

        // Obtener ubicaciones del controlador
        List<UbicacionView> listaUbicaciones = Controlador.mostrarMapa();

        // Llenar la lista de booleanos
        for (UbicacionView ubicacion : listaUbicaciones) {
            ubicacionActiva.add(ubicacion.getEstaActivo());
        }

        // Verificar que haya suficientes elementos antes de acceder a los índices
        try {
            if (ubicacionActiva.get(0)) panelPrincipal.add(panelAldea);
            if (ubicacionActiva.get(1)) panelPrincipal.add(panelRuinas);
            if (ubicacionActiva.get(2)) panelPrincipal.add(panelPantano);
            if (ubicacionActiva.get(3)) panelPrincipal.add(panelBosque);
            if (ubicacionActiva.get(4)) panelPrincipal.add(panelParamo);
            if (ubicacionActiva.get(5)) panelPrincipal.add(panelMontanas);
            if (ubicacionActiva.get(6)) panelPrincipal.add(panelNeutral);
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

    private JPanel crearPanelUbicacion(String nombre, String rutaImagen) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear botón con imagen
        JButton boton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    Image img = new ImageIcon(RUTA_BASE + rutaImagen).getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                    // Agregar el texto sobre fondo semi-transparente
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

        // Configurar el botón
        boton.setPreferredSize(new Dimension(120, 120));
        boton.setText(nombre);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBorderPainted(true);
        boton.setContentAreaFilled(false);

        // Agregar action listener
        boton.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Has seleccionado: " + nombre,
                nombre,
                JOptionPane.INFORMATION_MESSAGE));

        // Agregar el botón al panel
        panel.add(boton, BorderLayout.CENTER);

        return panel;
    }
}