package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PantallaDerrota extends JFrame {

    private JButton botonSalir;

    public PantallaDerrota() {
        // Configuración básica de la ventana
        setTitle("GAME OVER");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un contenedor personalizado
        Container customContainer = new Container();
        customContainer.setLayout(new BorderLayout());

        // Cargar y redimensionar la imagen de fondo
        ImageIcon backgroundImageIcon = new ImageIcon("src/images/GameOver.png");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setLayout(new BorderLayout());

        // Panel para el mensaje
        JPanel panelMensaje = new JPanel();
        panelMensaje.setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar el contenido
        panelMensaje.setOpaque(false); // Hacer el panel transparente

        // Crear el mensaje
        JLabel mensaje = new JLabel("DERROTA");
        mensaje.setFont(new Font("Arial", Font.BOLD, 60));
        mensaje.setForeground(Color.WHITE);

        // Agregar el mensaje al panel
        panelMensaje.add(mensaje);

        // Panel para el botón
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setOpaque(false); // Hacer el panel transparente

        // Crear el botón y configurar su fuente
        botonSalir = new JButton("SALIR");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 20));
        botonSalir.setPreferredSize(new Dimension(300, 50));
        panelBoton.add(botonSalir);

        // Agregar los paneles al fondo
        background.add(panelMensaje, BorderLayout.CENTER); // Panel del mensaje en el centro
        background.add(panelBoton, BorderLayout.SOUTH);    // Panel del botón en la parte inferior

        // Agregar el fondo al contenedor personalizado
        customContainer.add(background);
        this.add(customContainer);

        // Acción para el botón "SALIR"
        botonSalir.addActionListener(new HandlerBotonSalir());
    }

    // Manejo del botón "SALIR"
    class HandlerBotonSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // Cerrar la ventana
        }
    }

    // Método principal para ejecutar la ventana
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PantallaDerrota pantalla = new PantallaDerrota();
            pantalla.setVisible(true);
        });
    }
}
