package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.ldap.Control;
import javax.swing.*;

import controlador.Controlador;
import modelo.HeroeView;
import modelo.UbicacionView;


public class PantallaUbicacionNeutral extends JFrame {
    private JButton botonVolverMapa;
    private JButton botonDescansar;
    private JButton botonReclamarRecompensas;
    UbicacionView ubicacionView = Controlador.viajar("Ubicacion Neutral");


    public PantallaUbicacionNeutral() {


        // Configuración básica de la ventana
        setTitle("UBICACION NEUTRAL");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un contenedor personalizado
        Container customContainer = new Container();
        customContainer.setLayout(new BorderLayout());

        // Cargar y redimensionar la imagen de fondo
        ImageIcon backgroundImageIcon = new ImageIcon("src/images/FondoNeutral.png");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setLayout(new BorderLayout());

        // Panel central para los botones con GridLayout (5 filas, 1 columna, espacio vertical 20)
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 0, 20));
        panelBotones.setOpaque(false);

        // Crear la fuente para los botones
        Font buttonFont = new Font("Arial", Font.BOLD, 20); // Puedes ajustar el tamaño (20) según necesites

        // Crear los botones
        botonVolverMapa = new JButton("VOLVER AL MAPA");
        botonDescansar = new JButton("DESCANSAR");
        botonReclamarRecompensas = new JButton("RECLAMAR RECOMPENSAS");

        // Aplicar la fuente a los botones
        botonVolverMapa.setFont(buttonFont);
        botonDescansar.setFont(buttonFont);
        botonReclamarRecompensas.setFont(buttonFont);

        // Configurar tamaño preferido para los botones
        Dimension buttonSize = new Dimension(200, 40);
        botonVolverMapa.setPreferredSize(buttonSize);
        botonDescansar.setPreferredSize(buttonSize);
        botonReclamarRecompensas.setPreferredSize(buttonSize);

        // Paneles vacíos para espaciado
        JPanel espacioSuperior = new JPanel();
        JPanel espacioInferior = new JPanel();
        espacioSuperior.setOpaque(false);
        espacioInferior.setOpaque(false);

        // Agregar componentes al panel de botones
        panelBotones.add(espacioSuperior);
        panelBotones.add(botonDescansar);
        panelBotones.add(botonReclamarRecompensas);
        panelBotones.add(botonVolverMapa);
        panelBotones.add(espacioInferior);

        // Agregar ActionListeners
        botonVolverMapa.addActionListener(new HandlerBotonVolverMapa());
        botonDescansar.addActionListener(new HandlerBotonDescansar());
        botonReclamarRecompensas.addActionListener(new HandlerBotonReclamarRecompensas());

        // Agregar el panel de botones al centro del background
        background.add(panelBotones, BorderLayout.CENTER);

        // Agregar el background al contenedor y el contenedor al frame
        customContainer.add(background);
        this.add(customContainer);
    }


    class HandlerBotonVolverMapa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PantallaUbicaciones pantallaUbi = new PantallaUbicaciones();
            pantallaUbi.setVisible(true);
            dispose();
        }
    }

    class HandlerBotonDescansar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controlador.curarHeroe(ubicacionView);
            JOptionPane.showMessageDialog(null,"Descansaste");
            botonDescansar.setVisible(false);
        }
    }

    class HandlerBotonReclamarRecompensas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controlador.reclamarRecompensaHeroe(ubicacionView);
            JOptionPane.showMessageDialog(null,"Reclamaste tus recompensas");
            botonReclamarRecompensas.setVisible(false);
        }
    }
}