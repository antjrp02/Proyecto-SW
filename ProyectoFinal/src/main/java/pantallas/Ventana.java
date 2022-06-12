package pantallas;

import java.awt.Color;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;
import excepciones.ContraseñaIncorrectaException;
import excepciones.ContraseñaVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
/**
 * 
 * @author Antonio Jesus Rodriguez Pérez
 * La clase ventana,hereda de JFrame, es la encargada de crear todas las pantallas que se utilizaran en el programa.
 *
 */
public class Ventana extends JFrame {
	//JPanel que mostrara la pantalla que hayamos seleccionado
	private JPanel pantallaActual;
	//Usuario que ha iniciado sesion.
	public Usuario usuarioLogeado;
	/**
	 * 
	 * @param usuario de tipo String, es el nombre del usuario, se le pasa por parametros para poder llamarlo por argumentos en el main.
	 * @param contrasena de tipo String, es la contraseña del usuario, se le pasa por parametros para poder llamarlo por argumentos en el main.
	 * @throws SQLException excepcion que salta cuando hay algun problema al hacer una operacion en la base de datos.
	 * @throws ContraseñaIncorrectaException excepcion que salta cuando se introduce mal la conrraseña en la pantalla de login
	 * @throws UsuarioNoExisteException excepcion que salta cuando el nombre de usuario insertado en la pantalla Login es incorrecto.
	 * @throws UsuarioVacioException excepcion que salta cuando el nombre de usuario se inserta en blanco en la pantalla de registro
	 * @throws ContraseñaVaciaException excepcion que salta cuando la contraseña de usuario se inserta en blanco en la pantalla de registro.
	 */
	public Ventana(String usuario, String contrasena) throws SQLException,ContraseñaIncorrectaException,UsuarioNoExisteException,UsuarioVacioException 
	,ContraseñaVaciaException{

		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./logo.jpg").getImage());
		this.setTitle("App Street Workout");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pantallaActual = new PantallaLogin(this);
		this.setContentPane(pantallaActual);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	

		
	/**
	 * 
	 * @param nombrePantalla se le pasa el nombre de pantalla de la pantalla actual, esta funcion sirve para cambiar entre pantallas mientra se ejecuta la aplicacion.
	 */
	public void cambiarAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;

		switch (nombrePantalla) {
		case "login":
			this.pantallaActual = new PantallaLogin(this);
			break;
		case "registro":
			this.pantallaActual = new PantallaRegistro(this);
			break;
		case "menu":
			this.pantallaActual = new PantallaMenu(this);
			break;
		case "nivel":
			this.pantallaActual = new PantallaMenuNivel(this);
			break;
		case "entrenamiento":
			this.pantallaActual = new PantallaMenuEntrenamiento(this);
			break;
		case "crearRutina":
			this.pantallaActual = new PantallaMenuCrearRutina(this);
			break;
		case "perfil":
			this.pantallaActual = new PantallaPerfil(this);
			break;
		case "mostrarRutinas":
			this.pantallaActual= new PantallaMostrarRutinas(this);
			break;
		case "infoEj":
			this.pantallaActual= new PantallaInformacionEjercicios(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);

	}
}
