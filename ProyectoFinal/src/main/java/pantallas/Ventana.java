package pantallas;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	private JPanel pantallaActual;
	
	public Ventana(){
		
		
		
		this.setSize(800,500);
		this.setLocationRelativeTo(null); 
		this.setIconImage(new ImageIcon("./logo.jpg").getImage());
		this.setTitle("App Street Workout");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(pantallaActual);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void cambiarAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		
		switch(nombrePantalla) {
		case "login":
			this.pantallaActual=new PantallaLogin(this);
			break;
		case "registro":
			this.pantallaActual=new PantallaRegistro(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
				
	}
}
