package vista;

import controlador.Controlador;
import modelo.CriaturaView;
import modelo.HeroeView;
import modelo.UbicacionView;

import javax.swing.*;
import java.awt.*;

public class PantallaPelea extends JFrame {
    private JButton botonPelear;
    private JButton botonVolverMapa;
    private JButton botonSalir;



    public PantallaPelea(UbicacionView ubicacionView) {
        // Configuración básica de la ventana
        HeroeView heroeView = Controlador.getHeroe();
        CriaturaView criaturaView = ubicacionView.getCriatura();

        String nombreHeroe = heroeView.getNombre();
        String nombreCriatura = criaturaView.getNombre();

        // Configurar el estilo de los labels
        Font labelFont = new Font("Times New Roman", Font.BOLD, 30);

        setTitle("PELEA - " + ubicacionView.getNombre());
        setSize(750, 600);
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

        // Panel superior que contendrá ambos personajes
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2, 10, 10));
        panelSuperior.setOpaque(false);

        // Panel izquierdo que contendrá el panel del arquero y el panel de datos
        JPanel panelIzquierdo = new JPanel(new GridLayout(2, 1, 0, 0));
        panelIzquierdo.setOpaque(false);

        // Panel para el Arquero
        JPanel panelHeroe = new JPanel();
        panelHeroe.setOpaque(false);
        ImageIcon iconoHeroe = new ImageIcon(new ImageIcon("src/images/"+nombreHeroe+".png")
                .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel imagenHeroe = new JLabel(iconoHeroe);
        panelHeroe.add(imagenHeroe);

        // Panel para los datos del héroe
        JPanel panelDatosHeroe = new JPanel(new GridLayout(3, 1, 0, 10));
        panelDatosHeroe.setOpaque(false);

        // Crear y estilizar los labels
        JLabel puntosVidaHeroe = new JLabel("Puntos de vida: " + heroeView.getPuntosVida(), SwingConstants.CENTER);
        JLabel puntosAtaqueHeroe = new JLabel("Puntos de ataque: " + heroeView.getNivelAtaque(), SwingConstants.CENTER);
        JLabel puntosDefensaHeroe = new JLabel("Puntos de defensa: " + heroeView.getNivelDefensa(), SwingConstants.CENTER);

        puntosVidaHeroe.setFont(labelFont);
        puntosAtaqueHeroe.setFont(labelFont);
        puntosDefensaHeroe.setFont(labelFont);

        puntosVidaHeroe.setForeground(Color.WHITE);
        puntosAtaqueHeroe.setForeground(Color.WHITE);
        puntosDefensaHeroe.setForeground(Color.WHITE);

        // Añadir labels al panel de datos
        panelDatosHeroe.add(puntosVidaHeroe);
        panelDatosHeroe.add(puntosAtaqueHeroe);
        panelDatosHeroe.add(puntosDefensaHeroe);

        // Añadir paneles de arquero y datos al panel izquierdo
        panelIzquierdo.add(panelHeroe);
        panelIzquierdo.add(panelDatosHeroe);

        // Panel izquierdo que contendrá el panel del arquero y el panel de datos
        JPanel panelDerecho = new JPanel(new GridLayout(2, 1, 0, 0));
        panelDerecho.setOpaque(false);

        // Panel para el Arquero
        JPanel panelCriatura = new JPanel();
        panelCriatura.setOpaque(false);
        ImageIcon iconoCriatura = new ImageIcon(new ImageIcon("src/images/"+nombreCriatura+".png")
                .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel imagenCriatura = new JLabel(iconoCriatura);
        panelCriatura.add(imagenCriatura);

        // Panel para los datos del héroe
        JPanel panelDatosCriatura = new JPanel(new GridLayout(3, 1, 0, 10));
        panelDatosCriatura.setOpaque(false);

        // Crear y estilizar los labels
        JLabel puntosVidaCriatura = new JLabel("Puntos de vida: " + criaturaView.getPuntosVida(), SwingConstants.CENTER);
        JLabel puntosAtaqueCriatura = new JLabel("Puntos de ataque: " + criaturaView.getNivelAtaque(), SwingConstants.CENTER);
        JLabel puntosDefensaCriatura = new JLabel("Puntos de defensa: " + criaturaView.getNivelDefensa(), SwingConstants.CENTER);

        // Configurar el estilo de los labels
        puntosVidaCriatura.setFont(labelFont);
        puntosAtaqueCriatura.setFont(labelFont);
        puntosDefensaCriatura.setFont(labelFont);

        puntosVidaCriatura.setForeground(Color.WHITE);
        puntosAtaqueCriatura.setForeground(Color.WHITE);
        puntosDefensaCriatura.setForeground(Color.WHITE);

        // Añadir labels al panel de datos
        panelDatosCriatura.add(puntosVidaCriatura);
        panelDatosCriatura.add(puntosAtaqueCriatura);
        panelDatosCriatura.add(puntosDefensaCriatura);

        // Añadir paneles de arquero y datos al panel izquierdo
        panelDerecho.add(panelCriatura);
        panelDerecho.add(panelDatosCriatura);

        // Agregar los paneles al panel superior
        panelSuperior.add(panelIzquierdo);
        panelSuperior.add(panelDerecho);

        JPanel panelBotonVolver = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonVolver.setOpaque(false);
        botonVolverMapa = new JButton("Volver al mapa");
        botonVolverMapa.setPreferredSize(new Dimension(200, 40));
        botonVolverMapa.setFont(new Font("Arial", Font.BOLD, 19));
        botonVolverMapa.setVisible(false);

        JPanel panelBotonSalir = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonSalir.setOpaque(false);
        botonSalir = new JButton("Salir");
        botonSalir.setPreferredSize(new Dimension(120, 40));
        botonSalir.setFont(new Font("Arial", Font.BOLD, 19));
        botonSalir.setVisible(false);

        // Panel para el botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setOpaque(false);
        botonPelear = new JButton("Pelear");
        botonPelear.setPreferredSize(new Dimension(120, 40));
        botonPelear.setFont(new Font("Arial", Font.BOLD, 19));

        botonPelear.addActionListener(e -> {
            HeroeView heroeViewPostPelea = Controlador.pelear(ubicacionView, criaturaView);
            panelDatosHeroe.setVisible(false);
            panelDatosCriatura.setVisible(false);
            if (heroeViewPostPelea.getPuntosVida() > 0) {
                botonPelear.setVisible(false);
                panelBoton.add(botonVolverMapa);
                botonVolverMapa.setVisible(true);
                JOptionPane.showMessageDialog(null, "GANASTE LA PELEA");
                botonVolverMapa.addActionListener(ev -> {
                    dispose();
                    PantallaUbicaciones pantallaUbi = new PantallaUbicaciones();
                    pantallaUbi.setVisible(true);
                });
            } else {

                botonPelear.setVisible(false);
                panelBoton.add(botonSalir);
                botonSalir.setVisible(true);
                JOptionPane.showMessageDialog(null,"PERDISTE LA PELEA");
                dispose();
            }



        });


        panelBoton.add(botonPelear);

        // Agregar los paneles al fondo
        background.add(panelSuperior, BorderLayout.NORTH);
        background.add(panelBoton, BorderLayout.SOUTH);

        // Agregar el fondo al contenedor
        customContainer.add(background);

        // Agregar el contenedor al frame
        this.add(customContainer);
    }
}