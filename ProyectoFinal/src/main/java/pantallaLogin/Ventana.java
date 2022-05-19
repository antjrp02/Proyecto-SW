package pantallaLogin;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana(){
		getContentPane().setBackground(new Color(37, 42, 52));
		
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./logo.jpg").getImage());
		this.setTitle("App Street Workout");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
