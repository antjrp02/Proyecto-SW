package pantallas;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	private HashMap<String,JPanel> pantallas;
	public Ventana(){
		pantallas=new HashMap<String,JPanel>();
		pantallas.put("login",new PantallaLogin(this));
		pantallas.put("registro",new PantallaRegistro(this));
		
		
		this.setSize(800,500);
		this.setLocationRelativeTo(null); 
		this.setIconImage(new ImageIcon("./logo.jpg").getImage());
		this.setTitle("App Street Workout");
		this.setContentPane(this.pantallas.get("login"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void cambiarAPantalla(String nombrePantalla) {
		Iterator it=this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual=(JPanel)it.next();
			actual.setVisible(false);
		}
		
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
	}
}
