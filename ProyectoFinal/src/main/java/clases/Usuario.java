package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Enums.TipoEntrenamiento;
import excepciones.Contrase�aIncorrectaException;
import excepciones.NivelVacioException;
import excepciones.UbicacionVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import excepciones.Contrase�aVaciaException;
import superClases.EntidadConNombre;
import utilsDB.UtilsDB;
/**
 * Clase usuario que extiende de entidad con nombre
 * @author Antonio Jesus
 */
public class Usuario extends EntidadConNombre {
	//Contrase�a del usuario, la cual usara para loguearse en la base de datos
	private String contrase�a;
	//nivel del 1 al 10 que tendra el usuario
	private byte nivel;// Del 1 al 10, 1 mas novato, 10 mas avanzado.1 principiante,2 y 3 principiante-intermedio, 4,5 intermedio 6-7 intermedio-avanzado 8 y 9 avanzado y nivel 10 Kamenov
	//Ubicacion donde entrena el usuario
	private String UbicacionEntrenamiento;
	//Enum Tipo de entrenamiento que ha seleccionado el usuario, antes de seleccionaro en el programa, ser� null
	private TipoEntrenamiento entrenamiento;
	//ArrayList de Rutina con las rutinas que tiene el usuario
	private ArrayList<Rutina> rutinas;
	/**
	 * Constructor para registrar el usuario.
	 * 
	 * @param nombre String con el nomnbre de usuario
	 * @param contrase�a String con la contrase�a del usuario
	 * @param ubicacionEntrenamiento String con el nombre de la ciudad donde entrena el usuario
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 * @throws Contrase�aVaciaException Excepcion que saltar� si la contrase�a est� vacia
	 * @throws UsuarioVacioException Excepcion que saltar� si el usuario est� vacio
	 * @throws UbicacionVaciaException Excepcion que saltar� si se ha seleccionado "..." en la ubicacion
	 */
	public Usuario(String nombre, String contrase�a, String ubicacionEntrenamiento)
			throws SQLException, Contrase�aVaciaException, UsuarioVacioException, UbicacionVaciaException {
		super(nombre);
		if (contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}
		if (!this.UsuarioValido(nombre)) {
			throw new UsuarioVacioException("El usuario no puede estar vacio");
		}
		if (ubicacionEntrenamiento.equals("...")) {
			throw new UbicacionVaciaException("Porfavor, selecciona una Ubicacion");
		}

		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate("insert into usuario values('" + nombre + "','" + contrase�a + "'," + nivel + ",'"
				+ UbicacionEntrenamiento + "','" + entrenamiento + "')") > 0) {

			this.contrase�a = contrase�a;
			this.UbicacionEntrenamiento = ubicacionEntrenamiento;
			this.nivel = 0;
			this.rutinas = new ArrayList<Rutina>();
			this.entrenamiento = entrenamiento;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();
	}
	
	/**
	 * Constructor para hacer login en el programa.
	 * @param nombre String con el nomnbre de usuario
	 * @param contrase�a String con la contrase�a del usuario
	 * @throws SQLException excepcion que salta cuando hay algun problema al hacer una operacion en la base de datos.
	 * @throws Contrase�aIncorrectaException excepcion que salta cuando se introduce mal la conrrase�a en la pantalla de login
	 * @throws UsuarioNoExisteException excepcion que salta cuando el nombre de usuario insertado en la pantalla Login es incorrecto.
	 * @throws UsuarioVacioException excepcion que salta cuando el nombre de usuario se inserta en blanco en la pantalla de registro
	 * @throws Contrase�aVaciaException excepcion que salta cuando la contrase�a de usuario se inserta en blanco en la pantalla de registro.
	 */
	public Usuario(String nombre, String contrase�a) throws SQLException, Contrase�aIncorrectaException,
			UsuarioNoExisteException, UsuarioVacioException, Contrase�aVaciaException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();

		ResultSet cursor = smt.executeQuery("select * from usuario where nombre='" +

				nombre + "'");
		if (nombre.isBlank()) {
			throw new UsuarioVacioException("El usuario no puede estar vacio");
		}
		if (contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}
		if (cursor.next()) {

			this.contrase�a = cursor.getString("contrase�a");

			if (!this.contrase�a.equals(contrase�a)) {

				UtilsDB.desconectarBD();

				throw new Contrase�aIncorrectaException("La contrase�a no es correcta");

			}

			if (!this.getNombre().equals(nombre)) {
				throw new UsuarioNoExisteException("No existe ese nombre de usuario en la BD");
			}
			nombre = cursor.getString("Nombre");
			this.nivel = cursor.getByte("Nivel");
			this.UbicacionEntrenamiento = cursor.getString("UbicacionEntrenamiento");

		} else {

			UtilsDB.desconectarBD();

			throw new UsuarioNoExisteException("El nombre de usuario no existe");

		}

		UtilsDB.desconectarBD();

	}
	//Constructor de Usuario solo con el nombre.
	public Usuario(String nombre) {
		super(nombre);
	}
	/**
	 * Constructor para seleccionar el nivel del usario en el programa.
	 * @param nombre String con el nomnbre de usuario
	 * @param nivel Byte va a ser del 1 al 10, dependiendo el nivel del usuario
	 * @throws SQLException excepcion que salta cuando hay algun problema al hacer una operacion en la base de datos.
	 * @throws NivelVacioException Excepcion que saltar� si se ha seleccionado "..." en el nivel
	 */
	public Usuario(String nombre, byte nivel) throws SQLException, NivelVacioException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();
		if (nivel == 0) {
			throw new NivelVacioException("Nivel no valido");
		}
		smt.executeUpdate("Update usuario set nivel = " + nivel + " where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		this.nivel = nivel;
	}
	/**
	 * Constructor para seleccionar el Tipo de entrenamiento en el programa
	 * @param nombre String con el nomnbre de usuario
	 * @param entrenamiento Enum de TipoEntrenamiento para seleccionar el entrenamiento deseado del usuario
	 * @throws SQLException excepcion que salta cuando hay algun problema al hacer una operacion en la base de datos.
	 */
	public Usuario(String nombre, TipoEntrenamiento entrenamiento) throws SQLException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"Update usuario set entrenamiento = '" + entrenamiento + "' where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		this.entrenamiento = entrenamiento;
	}
	
	

	
	/**
	 * getter de contrase�a
	 * @return String
	 */
	public String getContrase�a() {
		return contrase�a;
	}
	/**
	 * setter de contrase�a
	 * @param contrase�a String
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	/**
	 * getter de nivel
	 * @return byte
	 */
	public byte getNivel() {
		return nivel;
	}
	/**
	 * Setter de nivel
	 * @param nivel byte
	 */
	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}
	/**
	 * getter de ubicacionEntrenamiento
	 * @return String
	 */
	public String getUbicacionEntrenamiento() {
		return UbicacionEntrenamiento;
	}
	/**
	 * setter de ubicacionEntrenamiento
	 * @param ubicacionEntrenamiento String
	 */
	public void setUbicacionEntrenamiento(String ubicacionEntrenamiento) {
		UbicacionEntrenamiento = ubicacionEntrenamiento;
	}
	/**
	 * getter de entrenamiento
	 * @return TipoEntrenamiento
	 */
	public TipoEntrenamiento getEntrenamiento() {
		return entrenamiento;
	}
	/**
	 * setter de entrenamiento
	 * @param entrenamiento TipoEntrenamiento
	 */
	public void setEntrenamiento(TipoEntrenamiento entrenamiento) {
		this.entrenamiento = entrenamiento;
	}
	/**
	 * getter de rutinas
	 * @return ArrayList<Rutina>
	 */
	public ArrayList<Rutina> getRutinas() {
		return rutinas;
	}
	/**
	 * setter de rutinas
	 * @param rutinas ArrayList<Rutina>
	 */
	public void setRutinas(ArrayList<Rutina> rutinas) {
		this.rutinas = rutinas;
	}
	/**
	 * La funcion principal de esta funcion es a�adir en un ArrayList de Rutina todas las rutinas del usuario
	 * @param r Rutina
	 * @return ArrayList<Rutina>  
	 */
	public ArrayList<Rutina> rutinas(Rutina r) {

		ArrayList<Rutina> rutinas = new ArrayList<Rutina>();
		rutinas.add(r);
		
		return rutinas;

	}
	
	
	
}
