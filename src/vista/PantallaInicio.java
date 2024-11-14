package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonWritableChannelException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;


// Extiende de JFRAME, entonces va a ser una pantalla
public class PantallaInicio extends JFrame{
	
	//me lo guardo como atributo porque esta es la manera en la que el listener va a tener acceso al componente para obtener el valor de adentro
	private JTextField campoNombre;
	
	//Constructor
	public PantallaInicio() {
		super("Pantalla de inicio");           //titulo
		this.setLayout(new BorderLayout());   //la pantalla en si tiene un layout
		
		//se crea un panel
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1,2,2));   //rows,cols,hgap,vgap. El panel va a tener otro layout
		
		//adentro del panel un container
		Container contNombre = new Container();
		contNombre.setLayout(new GridLayout(1,2,2,2));
		
		//dentro del container
		JLabel labelNombre = new JLabel("Nombre");
		campoNombre = new JTextField();
		contNombre.add(labelNombre);
		contNombre.add(campoNombre);
		panel1.add(contNombre);
		
		
		
		//Creo un container para los botones
		Container contBotones = new Container();
		contBotones.setLayout(new GridLayout(1,2,2,2));
		
		//Construccion del boton aceptar
		JButton botonAceptar = new JButton("Aceptar");
		
		//Clase interna		
		class HandlerBotonAceptar implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.crearGuerrero("Guerrero", 100, 60, 50, campoNombre.getText());
				JOptionPane.showMessageDialog(null, "Guerrero creado correctamente");
			}
			
		}
		// creo un objeto de la clase interna y al jbutton le agrego un action listener que va a ser ese objeto
		HandlerBotonAceptar handlerBotonAceptar = new HandlerBotonAceptar();
		botonAceptar.addActionListener(handlerBotonAceptar);
		
		
		//Lo mismo para el boton de borrar
		JButton botonBorrar = new JButton("Borrar");
		class HandlerBotonBorrar implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				campoNombre.setText("");
			}
		}
		
		HandlerBotonBorrar handlerBotonBorrar = new HandlerBotonBorrar();
		botonBorrar.addActionListener(handlerBotonBorrar);
		
		contBotones.add(botonAceptar);
		contBotones.add(botonBorrar);
		
		panel1.add(contBotones);
		this.add(panel1,BorderLayout.CENTER);

			
	}

}



