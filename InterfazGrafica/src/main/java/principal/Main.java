package principal;

import interfaz.PantallaLogin;
import interfaz.Ventana;

public class Main {

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		PantallaLogin pantalla = new PantallaLogin(ventana);
		
	}

}
