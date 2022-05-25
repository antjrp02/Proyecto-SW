package principal;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import clases.Usuario;
import excepciones.ContraseñaIncorrectaException;
import excepciones.UsuarioNoExisteException;
import pantallas.Ventana;
import utilsDB.UtilsDB;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenido, elige una opcion");
		byte opcion = Byte.parseByte(sc.nextLine());
		byte nivel = 0;
		while (opcion < 1 || opcion > 6) {
			System.out.println("Opcion erronea, vuelve a elegir");
			opcion = Byte.parseByte(sc.nextLine());
		}
		do {
		switch (opcion) {

		case 1:// Seleccionar nivel
			if (nivel == 0) {
				System.out.println("Seleciona un nivel entre 1 y 10");
				nivel = Byte.parseByte(sc.nextLine());
				System.out.println("Elige una opcion");
				opcion = Byte.parseByte(sc.nextLine());
			} else {
				System.out.println("Tu nivel actual es " + nivel + "\n¿Deseas modificarlo?");
				char respuesta = sc.nextLine().toLowerCase().charAt(0);
				while (respuesta != ('s') && (respuesta != ('n'))) {
					System.out.println("Respuesta incorrecta, vuelve a seleccionar");
					respuesta = sc.nextLine().toLowerCase().charAt(0);
				}
				
				if(respuesta=='s') {
					System.out.println("Seleciona un nivel entre 1 y 10");
					nivel = Byte.parseByte(sc.nextLine());
					System.out.println("Elige una opcion");
					opcion = Byte.parseByte(sc.nextLine());
				}
				else {
					System.out.println("Elige una opcion");
					opcion = Byte.parseByte(sc.nextLine());
				}
				 
			}
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		
		}
		}while(opcion !=6);
	}

}
