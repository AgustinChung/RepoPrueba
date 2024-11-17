package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.ldap.Control;
import javax.swing.*;

import controlador.Controlador;
import modelo.HeroeView;
import modelo.UbicacionView;


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

        // Panel para el botón
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setOpaque(false);  // Hacer el panel transparente

        // Crear el botón y configurar su fuente
        botonSalir = new JButton("SALIR");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 20));
        botonSalir.setPreferredSize(new Dimension(300, 50));

        panelBoton.add(botonSalir);

        // Agregar el panel al background en la parte inferior
        background.add(panelBoton, BorderLayout.SOUTH);

        customContainer.add(background);
        this.add(customContainer);

        botonSalir.addActionListener(new HandlerBotonSalir());

    }

    class HandlerBotonSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

}