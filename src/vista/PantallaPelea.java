package vista;

import controlador.Controlador;
import modelo.CriaturaView;
import modelo.HeroeView;
import modelo.UbicacionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPelea extends JFrame {
    private JButton botonPelear;

    public PantallaPelea(UbicacionView ubicacionView) {
        // Configuración básica de la ventana
        setTitle("PELEA - " + ubicacionView.getNombre());
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear contenedor personalizado para el fondo
        Container customContainer = new Container();
        customContainer.setLayout(new BorderLayout());

        // Configurar imagen de fondo
        ImageIcon backgroundImageIcon = new ImageIcon("src/images/Pelea.png");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setLayout(new BorderLayout());

        // Panel para las imágenes superiores
        JPanel panelImagenes = new JPanel(new GridLayout(1, 2, 10, 10));  // 1 fila, 2 columnas, gap 10
        panelImagenes.setOpaque(false);  // Hacer transparente

        // Panel para el Arquero
        JPanel panelArquero = new JPanel();
        panelArquero.setOpaque(false);
        ImageIcon iconoArquero = new ImageIcon(new ImageIcon("src/images/Arquero.png")
                .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel imagenArquero = new JLabel(iconoArquero);
        panelArquero.add(imagenArquero);

        // Panel para el Dragón
        JPanel panelDragon = new JPanel();
        panelDragon.setOpaque(false);
        ImageIcon iconoDragon = new ImageIcon(new ImageIcon("src/images/Dragon.png")
                .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel imagenDragon = new JLabel(iconoDragon);
        panelDragon.add(imagenDragon);

        // Agregar los paneles de imágenes al panel principal
        panelImagenes.add(panelArquero);
        panelImagenes.add(panelDragon);

        // Panel para el botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setOpaque(false);  // Hacer transparente
        botonPelear = new JButton("Pelear");
        botonPelear.setPreferredSize(new Dimension(120, 40));
        botonPelear.setFont(new Font("Arial", Font.BOLD, 19));
        panelBoton.add(botonPelear);

        // Agregar los paneles al fondo
        background.add(panelImagenes, BorderLayout.NORTH);
        background.add(panelBoton, BorderLayout.SOUTH);

        // Agregar el fondo al contenedor
        customContainer.add(background);

        // Agregar el contenedor al frame
        this.add(customContainer);
    }
}