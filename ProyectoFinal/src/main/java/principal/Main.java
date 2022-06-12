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
import excepciones.Contrase�aIncorrectaException;
import excepciones.Contrase�aVaciaException;
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
 * @param args en uso, se le pasa por parametros el nombre de usuario y la contrase�a para que inicie sesion automaticamente, si no se le pasan argumentos por parametros,se iniciara sesion de forma normal
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usuario = null;
		String contrase�a = null;

		for (byte i = 0; i < args.length; i++) {

			if (args[i].equals("-usuario")) {
				usuario = args[i ];

			}
			if (args[i].equals("-contrase�a")) {
				contrase�a = args[i ];
			}
		}
		try {
			Ventana v = new Ventana(usuario, contrase�a);
		} catch (SQLException | Contrase�aIncorrectaException | UsuarioNoExisteException | UsuarioVacioException
				| Contrase�aVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}