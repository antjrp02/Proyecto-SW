package principal;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Enums.TipoEntrenamiento;
import clases.Entrenamiento;
import clases.Usuario;
import excepciones.ContraseñaIncorrectaException;
import excepciones.ContraseñaVaciaException;
import excepciones.NivelVacioException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import pantallas.Ventana;
import utilsDB.UtilsDB;
/**
 * Clase principal donde se desarrollara la aplicacion
 * @author Antonio Jesus
 *
 */
public class Main {
/**
 * 
 * @param args en uso, se le pasa por parametros el nombre de usuario y la contraseña para que inicie sesion automaticamente, si no se le pasan argumentos por parametros,se iniciara sesion de forma normal
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usuario = null;
		String contraseña = null;

		for (byte i = 0; i < args.length; i++) {

			if (args[i].equals("-usuario")) {
				usuario = args[i ];

			}
			if (args[i].equals("-contraseña")) {
				contraseña = args[i ];
			}
		}
		try {
			Ventana v = new Ventana(usuario, contraseña);
		} catch (SQLException | ContraseñaIncorrectaException | UsuarioNoExisteException | UsuarioVacioException
				| ContraseñaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}