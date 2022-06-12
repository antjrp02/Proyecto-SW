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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usuario = null;
		String contrase�a = null;

		for (byte i = 0; i < args.length; i++) {

			if (args[i].equals("-usuario")) {
				usuario = args[i ];

			}
			if (args[i].equals("-contrase�a")) {
				contrase�a = args[i + 1];
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