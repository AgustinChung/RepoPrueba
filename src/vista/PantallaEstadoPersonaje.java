package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.HeroeView;


public class PantallaEstadoPersonaje extends JFrame {

    private JButton botonVerMapa;

    public PantallaEstadoPersonaje(HeroeView heroe) {
        // Configuración básica de la ventana
        setTitle("Estado del Héroe");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un contenedor personalizado
        Container customContainer = new Container();
        customContainer.setLayout(new BorderLayout());

        // Cargar y redimensionar la imagen de fondo
        ImageIcon backgroundImageIcon = new ImageIcon("../fondo1.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setLayout(new BorderLayout());
        customContainer.add(background);

        // Crear un panel para los datos del héroe
        JPanel panelDatos = new JPanel();
        panelDatos.setOpaque(false); // Hacer transparente para mostrar el fondo
        panelDatos.setLayout(new GridLayout(5, 1)); // 5 filas, 1 columna

        // Añadir los datos del héroe al panel
        JLabel labelNombre = new JLabel("Heroe elegido: " + heroe.getNombre(), JLabel.CENTER);
        JLabel labelUsuario = new JLabel("Nombre de usuario: " + heroe.getNombreUsuario(), JLabel.CENTER);
        JLabel labelVida = new JLabel("Puntos de vida: " + heroe.getPuntosVida(), JLabel.CENTER);
        JLabel labelAtaque = new JLabel("Nivel de ataque: " + heroe.getNivelAtaque(), JLabel.CENTER);
        JLabel labelDefensa = new JLabel("Nivel de defensa: " + heroe.getNivelDefensa(), JLabel.CENTER);

        // Configurar texto en negro
        labelNombre.setForeground(Color.BLACK);
        labelUsuario.setForeground(Color.BLACK);
        labelVida.setForeground(Color.BLACK);
        labelAtaque.setForeground(Color.BLACK);
        labelDefensa.setForeground(Color.BLACK);

        // Agregar las etiquetas al panel
        panelDatos.add(labelNombre);
        panelDatos.add(labelUsuario);
        panelDatos.add(labelVida);
        panelDatos.add(labelAtaque);
        panelDatos.add(labelDefensa);

        // Centrar el panel en el fondo
        background.add(panelDatos, BorderLayout.CENTER);

        // Crear el botón y su panel
        botonVerMapa = new JButton("VER MAPA");
        JPanel panelBoton = new JPanel();
        panelBoton.setOpaque(false);
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(botonVerMapa);

        // Agregar el panel del botón al fondo
        background.add(panelBoton, BorderLayout.SOUTH);

        // Añadir el contenedor al JFrame
        this.add(customContainer);

        botonVerMapa.addActionListener(new HandlerBotonVerMapa());
    }

    class HandlerBotonVerMapa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PantallaUbicaciones pantallaUbi = new PantallaUbicaciones();
            pantallaUbi.setVisible(true);
            dispose();
        }
    }
}