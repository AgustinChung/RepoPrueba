package vista;
import javax.swing.*;
import controlador.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame {

    private JTextField campoNombre;
    private JButton botonMago;
    private JButton botonGuerrero;
    private JButton botonArquero;

    public PantallaInicio() {
        setTitle("Selecciona tu Héroe");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        try {
            ImageIcon backgroundImageIcon = new ImageIcon("src/images/FondoInicio.png");
            Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(750, 600, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(backgroundImage));
            background.setLayout(new BorderLayout());
            panelPrincipal.add(background);

            // Panel para el nombre de usuario - Ahora con espacio arriba
            JPanel panelNombre = new JPanel();
            panelNombre.setOpaque(false);
            panelNombre.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0)); // 100px de margen arriba
            JLabel labelNombre = new JLabel("NOMBRE DE USUARIO:");
            labelNombre.setForeground(Color.WHITE);
            labelNombre.setFont(new Font("Arial", Font.BOLD, 14));
            campoNombre = new JTextField(15);
            panelNombre.add(labelNombre);
            panelNombre.add(campoNombre);

            // Panel central para los héroes
            JPanel panelCentral = new JPanel(new BorderLayout());
            panelCentral.setOpaque(false);

            // Panel para los botones
            JPanel panelBotones = new JPanel(new GridLayout(1, 3, 30, 0));
            panelBotones.setOpaque(false);
            panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));

            // Crear paneles individuales para cada héroe (botón + etiqueta)
            JPanel panelMago = crearPanelHeroe("src/images/Mago.png", "MAGO");
            JPanel panelGuerrero = crearPanelHeroe("src/images/Guerrero.png", "GUERRERO");
            JPanel panelArquero = crearPanelHeroe("src/images/Arquero.png", "ARQUERO");

            // Obtener los botones de los paneles
            botonMago = (JButton) panelMago.getComponent(0);
            botonGuerrero = (JButton) panelGuerrero.getComponent(0);
            botonArquero = (JButton) panelArquero.getComponent(0);

            // Añadir action listeners
            botonMago.addActionListener(new HandlerBotonMago());
            botonGuerrero.addActionListener(new HandlerBotonGuerrero());
            botonArquero.addActionListener(new HandlerBotonArquero());

            // Añadir paneles de héroes al panel de botones
            panelBotones.add(panelMago);
            panelBotones.add(panelGuerrero);
            panelBotones.add(panelArquero);

            // Añadir todo al fondo
            background.add(panelNombre, BorderLayout.NORTH);
            background.add(panelBotones, BorderLayout.CENTER);

        } catch (Exception e) {
            System.out.println("Error al cargar las imágenes: " + e.getMessage());
        }

        add(panelPrincipal);
    }

    private JPanel crearPanelHeroe(String rutaImagen, String nombreHeroe) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        // Crear botón con imagen
        JButton boton = new JButton();
        try {
            ImageIcon icono = new ImageIcon(rutaImagen);
            Image imagen = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            boton.setIcon(new ImageIcon(imagen));
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
            boton.setFocusPainted(false);
            boton.setOpaque(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + rutaImagen);
        }

        // Crear etiqueta con el nombre del héroe
        JLabel etiqueta = new JLabel(nombreHeroe);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 16));
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir componentes al panel
        panel.add(boton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botón y etiqueta
        panel.add(etiqueta);

        return panel;
    }

    private boolean validarNombre() {
        String nombre = campoNombre.getText().trim();
        if(nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese un nombre de usuario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            campoNombre.requestFocus();
            return false;
        }
        return true;
    }

    class HandlerBotonMago implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(validarNombre()) {
                String nombreUsuario = campoNombre.getText().trim();
                Controlador.crearMago("Mago", 200, 70, 30, nombreUsuario);
                JOptionPane.showMessageDialog(null, nombreUsuario + " eligió un Mago ");
                dispose();
            }
        }
    }

    class HandlerBotonGuerrero implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(validarNombre()) {
                String nombreUsuario = campoNombre.getText().trim();
                Controlador.crearGuerrero("Guerrero", 200, 70, 80, nombreUsuario);
                JOptionPane.showMessageDialog(null, nombreUsuario + " eligió un Guerrero");
                dispose();
            }
        }
    }

    class HandlerBotonArquero implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(validarNombre()) {
                String nombreUsuario = campoNombre.getText().trim();
                Controlador.crearArquero("Arquero", 250, 60, 40, nombreUsuario, 60, 20);
                JOptionPane.showMessageDialog(null, nombreUsuario + " eligió un Arquero");
                dispose();
            }
        }
    }
}