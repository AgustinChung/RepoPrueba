package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import controlador.Controlador;
import modelo.HeroeView;
import modelo.RecompensaView;
import modelo.UbicacionView;

public class PantallaRecompensas extends JFrame {
    private JButton botonVerRecompensas;
    private JButton botonReclamarRecompensas;
    private JButton botonVolver;
    private UbicacionView ubicacionView;

    // Definir los handlers como clases internas
    private class HandlerBotonVerRecompensas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Controlador.getNombresRecompensas().size() == 0) {
                JOptionPane.showMessageDialog(null, "No tenes recompensas disponibles para reclamar");
            } else {
                JOptionPane.showMessageDialog(null, "Tus recompensas son: " + Controlador.getNombresRecompensas());
            }
            botonVerRecompensas.setVisible(false);
        }
    }

    private class HandlerBotonReclamarRecompensas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Controlador.getNombresRecompensas().size() == 0) {
                JOptionPane.showMessageDialog(null, "No tenes recompensas disponibles para reclamar");
            } else {
                Controlador.reclamarRecompensaHeroe(ubicacionView);
                JOptionPane.showMessageDialog(null, "Reclamaste tus recompensas");
            }
            botonReclamarRecompensas.setVisible(false);
        }
    }

    private class HandlerBotonVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PantallaUbicacionNeutral pantallaNeutral = new PantallaUbicacionNeutral();
            pantallaNeutral.setVisible(true);
            dispose();
        }
    }


    public PantallaRecompensas(UbicacionView ubicacionView) {
        this.ubicacionView = ubicacionView;
        HeroeView heroeView = Controlador.getHeroe();

        // Configuración básica de la ventana
        setTitle("RECOMPENSAS");
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

        // Panel central para los botones con GridLayout
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 0, 20));
        panelBotones.setOpaque(false);

        // Crear la fuente para los botones
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        // Crear los botones
        botonVerRecompensas = new JButton("VER RECOMPENSAS");
        botonReclamarRecompensas = new JButton("RECLAMAR RECOMPENSAS");
        botonVolver = new JButton("VOLVER A UBICACION NEUTRAL");

        // Aplicar la fuente a los botones
        botonVerRecompensas.setFont(buttonFont);
        botonReclamarRecompensas.setFont(buttonFont);
        botonVolver.setFont(buttonFont);

        // Configurar tamaño preferido para los botones
        Dimension buttonSize = new Dimension(200, 40);
        botonVerRecompensas.setPreferredSize(buttonSize);
        botonReclamarRecompensas.setPreferredSize(buttonSize);
        botonVolver.setPreferredSize(buttonSize);

        // Paneles vacíos para espaciado
        JPanel espacioSuperior = new JPanel();
        JPanel espacioInferior = new JPanel();
        espacioSuperior.setOpaque(false);
        espacioInferior.setOpaque(false);

        // Agregar componentes al panel de botones
        panelBotones.add(espacioSuperior);
        panelBotones.add(botonVerRecompensas);
        panelBotones.add(botonReclamarRecompensas);
        panelBotones.add(botonVolver);
        panelBotones.add(espacioInferior);

        // Agregar ActionListeners
        botonVerRecompensas.addActionListener(new HandlerBotonVerRecompensas());
        botonReclamarRecompensas.addActionListener(new HandlerBotonReclamarRecompensas());
        botonVolver.addActionListener(new HandlerBotonVolver());

        // Agregar el panel de botones al centro del background
        background.add(panelBotones, BorderLayout.CENTER);

        // Agregar el background al contenedor y el contenedor al frame
        customContainer.add(background);
        this.add(customContainer);
    }
}