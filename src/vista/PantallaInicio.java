package vista;
import javax.swing.*;
import controlador.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame {

	//Creamos un textfield para el nombre, un label para los heroes y un boton para cada uno
    private JTextField campoNombre;
    private JLabel labelElegirHeroe;
    private JButton botonMago;
    private JButton botonGuerrero;
    private JButton botonArquero;

    public PantallaInicio() {
        // Configuración básica de la ventana
        setTitle("Selecciona tu Héroe");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un nuevo Container en lugar de usar getContentPane()
        Container customContainer = new Container();
        customContainer.setLayout(new BorderLayout());

        // Cargar y redimensionar la imagen de fondo
        ImageIcon backgroundImageIcon = new ImageIcon("src/images/FondoInicio.png");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setLayout(new BorderLayout());
        customContainer.add(background);

        // Panel para el nombre de usuario
        JPanel panelNombre = new JPanel();
        panelNombre.setOpaque(false); // Hacer transparente para mostrar el fondo
        JLabel labelNombre = new JLabel("Nombre de Usuario:");
        labelNombre.setForeground(Color.WHITE); // Cambia el color del texto a blanco
        campoNombre = new JTextField(15);  //15 columnas
        panelNombre.add(labelNombre);
        panelNombre.add(campoNombre);

        // Panel para los héroes
        JPanel panelHeroes = new JPanel();
        panelHeroes.setOpaque(false); // Hacer transparente para mostrar el fondo
        panelHeroes.setLayout(new GridLayout(3, 1, 10, 10)); // Organiza en una cuadrícula de 3 filas, 1 columna

        // Configuración del botón y la imagen del héroe "Mago"
        botonMago = new JButton("Mago");
        ImageIcon iconoMago = new ImageIcon(new ImageIcon("src/images/Mago.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel imagenMago = new JLabel(iconoMago);
        JPanel panelMago = new JPanel();
        panelMago.setOpaque(false);
        panelMago.add(botonMago);
        panelMago.add(imagenMago);
        botonMago.addActionListener(new HandlerBotonMago());

        // Configuración del botón y la imagen del héroe "Guerrero"
        botonGuerrero = new JButton("Guerrero");
        ImageIcon iconoGuerrero = new ImageIcon(new ImageIcon("src/images/Guerrero.png")
                            .getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel imagenGuerrero = new JLabel(iconoGuerrero);
        JPanel panelGuerrero = new JPanel();
        panelGuerrero.setOpaque(false);
        panelGuerrero.add(botonGuerrero);
        panelGuerrero.add(imagenGuerrero);
        botonGuerrero.addActionListener(new HandlerBotonGuerrero());

        // Configuración del botón y la imagen del héroe "Arquero"
        botonArquero = new JButton("Arquero");
        ImageIcon iconoArquero = new ImageIcon(new ImageIcon("src/images/Arquero.png")
                            .getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel imagenArquero = new JLabel(iconoArquero);
        JPanel panelArquero = new JPanel();
        panelArquero.setOpaque(false);
        panelArquero.add(botonArquero);
        panelArquero.add(imagenArquero);
        botonArquero.addActionListener(new HandlerBotonArquero());

        // Añadir los paneles de héroes al panel de héroes
        panelHeroes.add(panelMago);
        panelHeroes.add(panelGuerrero);
        panelHeroes.add(panelArquero);

        // Añadir paneles al fondo
        background.add(panelNombre, BorderLayout.NORTH);
        background.add(panelHeroes, BorderLayout.CENTER);

        // Añadir el Container al JFrame
        this.add(customContainer);
        
        JButton BotonMostrarUbicaciones = new JButton("VER MAPA");
        
    }
    
    
    

    // Clase para manejar los eventos de los botones de héroe
    class HandlerBotonMago implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
			Controlador.crearMago("Mago", 10, 60, 50, campoNombre.getText());
	        String nombreUsuario = campoNombre.getText();
			JOptionPane.showMessageDialog(null, nombreUsuario + " eligió un Mago ");
			dispose();
			//Cada metodo ademas de cerrar la pantalla deberia mostrar la siguiente pantalla?

        }
    }
    
    class HandlerBotonGuerrero implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent e) {
			Controlador.crearGuerrero("Guerrero", 100000000, 60, 50, campoNombre.getText());
	        String nombreUsuario = campoNombre.getText();
			JOptionPane.showMessageDialog(null, nombreUsuario + " eligió un Guerrero");
			dispose(); 
        }
    }
    
    class HandlerBotonArquero implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
			Controlador.crearArquero("Arquero", 1000000000, 60, 50, campoNombre.getText(), 10, 10);
	        String nombreUsuario = campoNombre.getText();
			JOptionPane.showMessageDialog(null, nombreUsuario + " eligió un Arquero");
			dispose(); 
        }
    }
   
}