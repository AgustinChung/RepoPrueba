package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaEstadoPersonaje extends JFrame {

    private JPanel panelAtaque;
    private JPanel panelDefensa;

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
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS)); // Organizar componentes en una columna
        customContainer.add(background);

        // Panel para mostrar el ataque del personaje
        panelAtaque = new JPanel();
        panelAtaque.setOpaque(false); // Hacer transparente para mostrar el fondo
        JLabel labelAtaque = new JLabel("Puntos de ataque: " + heroe.getAtaque());
        labelAtaque.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        panelAtaque.add(labelAtaque);

        // Panel para mostrar la defensa del personaje
        panelDefensa = new JPanel();
        panelDefensa.setOpaque(false); // Hacer transparente para mostrar el fondo
        JLabel labelDefensa = new JLabel("Puntos de defensa: " + heroe.getDefensa());
        labelDefensa.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        panelDefensa.add(labelDefensa);

        // Añadir los paneles de ataque y defensa al fondo
        background.add(panelAtaque);
        background.add(panelDefensa);

        // Añadir el contenedor al JFrame
        this.add(customContainer);
    }
}