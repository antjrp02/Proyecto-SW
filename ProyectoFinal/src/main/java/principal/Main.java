package principal;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
		Ventana v = new Ventana();
		Scanner sc = new Scanner(System.in);

		System.out.println("Buenas, selecciona 1 para iniciar sesion o 2 para registrarte:");
		byte inicio = Byte.parseByte(sc.nextLine());
		while (inicio < 1 || inicio > 2) {
			System.out.println("Opcion erronea, vuelve a elegir");
			inicio = Byte.parseByte(sc.nextLine());
		}
		if (inicio == 1) {
			System.out.println("Nombre:");
			String nombre = sc.nextLine();
			System.out.println("Contraseña:");
			String contraseña = sc.nextLine();
			try {
				Usuario u = new Usuario(nombre, contraseña);

				System.out.println("Bienvenido, elige una opcion\n" + "-1 Seleccionar nivel\n"
						+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n" + "-4 Hacer mi propia rutina\n"
						+ "-5 Modificar datos de usuario\n" + "-6 Salir");

				byte opcion = Byte.parseByte(sc.nextLine());

				while (opcion < 1 || opcion > 6) {
					System.out.println("Opcion erronea, vuelve a elegir");
					opcion = Byte.parseByte(sc.nextLine());
				}
				do {
					switch (opcion) {

					case 1:// Seleccionar nivel
						if (u.getNivel() == 0) {
							System.out.println("Seleciona un nivel entre 1 y 10");
							byte nivel = Byte.parseByte(sc.nextLine());
							while (nivel < 0 || nivel > 10) {
								System.out.println("Nivel no valido, vuelve a seleccionar");
								nivel = Byte.parseByte(sc.nextLine());
							}

							u = new Usuario(nombre, nivel);

							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
						} else {
							System.out.println("Tu nivel actual es " + u.getNivel() + "\n¿Deseas modificarlo?");
							char respuesta = sc.nextLine().toLowerCase().charAt(0);
							while (respuesta != ('s') && (respuesta != ('n'))) {
								System.out.println("Respuesta incorrecta, vuelve a seleccionar");
								respuesta = sc.nextLine().toLowerCase().charAt(0);
							}

							if (respuesta == 's') {
								System.out.println("Seleciona un nivel entre 1 y 10");
								byte nivel = Byte.parseByte(sc.nextLine());
								u = new Usuario(nombre, nivel);
								System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
										+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
										+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n"
										+ "-6 Salir");
								opcion = Byte.parseByte(sc.nextLine());
							} else {
								System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
										+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
										+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n"
										+ "-6 Salir");
								opcion = Byte.parseByte(sc.nextLine());
							}

						}
						break;
					case 2:
						if (u.getEntrenamiento() != null) {
							System.out.println("Tu entrenamiento seleccionado es de: " + u.getEntrenamiento()
									+ " deseas cambiarlo?");
							char respuesta = sc.nextLine().toLowerCase().charAt(0);
							while (respuesta != ('s') && (respuesta != ('n'))) {
								System.out.println("Respuesta incorrecta, vuelve a seleccionar");
								respuesta = sc.nextLine().toLowerCase().charAt(0);
							}

							if (respuesta == 's') {
								System.out.println("Selecciona entrenamiento\n" + "1- TENSION,\r\n"
										+ "2- HIPERTROFIA,\r\n" + "3- RESISTENCIA,\r\n" + "4- AUMENTOREPETICIONES,\r\n"
										+ "5- FREESTYLE,\r\n" + "6- MIXTO,//(Mixto entre Resistencia y Tension).\r\n"
										+ "7- MOVILIDAD,\r\n" + "8- LASTRE");
								byte nEntrenamiento = Byte.parseByte(sc.nextLine());
								while (nEntrenamiento < 0 || nEntrenamiento > 8) {
									System.out.println("Nivel no valido, vuelve a seleccionar");
									nEntrenamiento = Byte.parseByte(sc.nextLine());
								}
							} else {
								System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
										+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
										+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n"
										+ "-6 Salir");
								opcion = Byte.parseByte(sc.nextLine());
							}
						}

						System.out.println("Selecciona entrenamiento\n" + "1- TENSION,\r\n" + "2- HIPERTROFIA,\r\n"
								+ "3- RESISTENCIA,\r\n" + "4- AUMENTOREPETICIONES,\r\n" + "5- FREESTYLE,\r\n"
								+ "6- MIXTO,//(Mixto entre Resistencia y Tension).\r\n" + "7- MOVILIDAD,\r\n"
								+ "8- LASTRE\r\n" + "9- Salir");
						byte nEntrenamiento = Byte.parseByte(sc.nextLine());
						while (nEntrenamiento < 0 || nEntrenamiento > 9) {
							System.out.println("Nivel no valido, vuelve a seleccionar");
							nEntrenamiento = Byte.parseByte(sc.nextLine());
						}
						switch (nEntrenamiento) {
						case 1:
							Usuario uT = new Usuario(nombre, TipoEntrenamiento.TENSION);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 2:
							Usuario uH = new Usuario(nombre, TipoEntrenamiento.HIPERTROFIA);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 3:
							Usuario uR = new Usuario(nombre, TipoEntrenamiento.RESISTENCIA);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 4:
							Usuario uAR = new Usuario(nombre, TipoEntrenamiento.AUMENTOREPETICIONES);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 5:
							Usuario uF = new Usuario(nombre, TipoEntrenamiento.FREESTYLE);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 6:
							Usuario uMi = new Usuario(nombre, TipoEntrenamiento.MIXTO);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 7:
							Usuario uMo = new Usuario(nombre, TipoEntrenamiento.MOVILIDAD);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 8:
							Usuario uL = new Usuario(nombre, TipoEntrenamiento.LASTRE);
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;
						case 9:
							System.out.println("Elige una opcion\n" + "-1 Seleccionar nivel\n"
									+ "-2 Seleccionar Entrenamiento\n" + "-3 Hazme una rutina\n "
									+ "-4 Hacer mi propia rutina\n" + "-5 Modificar datos de usuario\n" + "-6 Salir");
							opcion = Byte.parseByte(sc.nextLine());
							break;

						}

						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;

					}
				} while (opcion != 6);
			} catch (SQLException | ContraseñaIncorrectaException | UsuarioNoExisteException | UsuarioVacioException
					| ContraseñaVaciaException | NivelVacioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
