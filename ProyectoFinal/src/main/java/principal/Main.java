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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usuario = null;
		String contraseña = null;

		for (byte i = 0; i < args.length; i++) {

			if (args[i].equals("-usuario")) {
				usuario = args[i ];

			}
			if (args[i].equals("-contraseña")) {
				contraseña = args[i + 1];
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