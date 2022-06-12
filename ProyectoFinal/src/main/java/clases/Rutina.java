package clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import Enums.TipoEntrenamiento;
import excepciones.ContraseñaIncorrectaException;
import excepciones.ContraseñaVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import utilsDB.UtilsDB;

/**
 * Clase Rutina, en la que se almacenaran ejercicios tanto dinamicos como
 * estaticos
 * 
 * @author Antonio Jesus
 */
public class Rutina {
	// Array list de ejercicios tanto dinamicos como estaticos
	private ArrayList<Ejercicio> ejercicios;
	//int con el descanso en sg que se va a tener entre series
	private int descansoSg;
	//LocalDateTime de cuando se creo la rutina
	private LocalDateTime fecha;
	//Usario que creo la rutina
	private Usuario usuario;
	//Nombre de los  ejercicios de la rutina(solo se usa para el cursor)
	private String nombreEjercicio;
	//series del ejercicio de la rutina(Solo se usa para el  cursor)
	private byte series;
	//byte de repeticiones del ejercicio de la rutina(Solo se usa para el cursor)
	private byte repeticiones;
	/**
	 * Este constructor es el que crea las rutinas en la base de datos del programa.
	 * @param ejercicios ArrayList<Ejercicios>que almacena todos los ejercicios
	 * @param descansoSg int con el descanso entre series que va a tener la rutina
	 * @param fecha LocalDateTime para almacenar el dia la hora el minuto y los segundos de cuando se creo la rutina
	 * @param usuario Usuario que crea la rutina
	 * @throws SQLException
	 */
	public Rutina(ArrayList<Ejercicio> ejercicios, int descansoSg, LocalDateTime fecha, Usuario usuario)
			throws SQLException {
		super();

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate(
				"insert into Rutina values('" + usuario.getNombre() + "'," + descansoSg + ",'" + fecha + "')") > 0) {

			this.ejercicios = ejercicios;
			this.descansoSg = descansoSg;
			this.fecha = fecha;
			this.usuario = usuario;
			
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}

	public Rutina() {
		// Genera rutina vacía OJO: INICIALIZAR ARRAYLIST
	}
	
	/**
	 * Funcion con un arrayList de Ejercicio dentro que se encarga de almacenar los ejercicios en el arrayList
	 * @param e Ejercicio
	 */
	public void añadirEjercicio(Ejercicio e) {
		ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(e);

	}
	/**
	 * Funcion para borrar ejercicios del arrayList;
	 * @param e Ejercicio
	 * @return boolean que se refiere a que el ejercicio se ha borrado
	 */
	public boolean borrarEjercicio(Ejercicio e) {
		return this.ejercicios.remove(e);
	}
	/**
	 * getter de ejercicios 
	 * @return ArrayList<Ejercicio>
	 */
	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	/**
	 * setter de ejercicios
	 * @param ejercicios ArrayList<Ejercicio>
	 */
	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	/**
	 * getter de descansoSg
	 * @return int
	 */
	public int getDescansoSg() {
		return descansoSg;
	}
	/**
	 * setter de descansos
	 * @param descansoSg int
	 */
	public void setDescansoSg(int descansoSg) {
		this.descansoSg = descansoSg;
	}
	/**
	 * getter de fecha
	 * @return LocalDateTime
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}
	/**
	 * setter de fecha
	 * @param fecha LocalDateTime
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Comstructor de rutina que recibe por parametros en ArrayList de ejercicios
	 * @param ejercicios ArrayList<Ejercicio>
	 */
	public Rutina(ArrayList<Ejercicio> ejercicios) {
		super();
		this.ejercicios = ejercicios;
	}

	/**
	 * Prueba query es una funcion que se le pasa el usuario por argumento, obtiene
	 * todas las fechas en las que ha creado cada rutina y a partir de ellas muestra
	 * los ejercicios y los concatena en un String para que sea mas facil a la hra
	 * de mostrarlo
	 * 
	 * @param usu Usuario que tiene rutinas
	 * @return String con todos los ejercicios concatenados
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de
	 *                      insertar ejercicios en la base de datos
	 *
	 */
	public String pruebaQuery(Usuario usu) throws SQLException {
		String ret = "";
		Statement smt = UtilsDB.conectarBD();
		ResultSet rutinasUsuario = smt
				.executeQuery("Select fecha from rutina where usuario ='" + usu.getNombre() + "';");
		ArrayList<LocalDateTime> fechaEjercicio = new ArrayList<LocalDateTime>();
		while (rutinasUsuario.next()) {

			this.fecha = rutinasUsuario.getTimestamp("fecha").toLocalDateTime();

			fechaEjercicio.add(fecha);

		}
		for (byte i = 0; i < fechaEjercicio.size(); i++) {
			ResultSet ejerciciosRutina = smt.executeQuery("select er.nombreEjercicio,e.series, ed.repeticiones \r\n"
					+ "from ejercicios_rutina er,ejercicios e,ejercicio_Dinamico ed,rutina r  \r\n" + "where  r.fecha='"
					+ fechaEjercicio.get(i)
					+ "' and er.nombreEjercicio = e.nombre and ed.nombre=er.nombreEjercicio;\r\n" + "");

			while (ejerciciosRutina.next()) {
				this.nombreEjercicio = ejerciciosRutina.getString("nombreEjercicio");
				this.repeticiones = ejerciciosRutina.getByte("repeticiones");
				this.series = ejerciciosRutina.getByte("series");
				if (ret.contains(fechaEjercicio.get(i) + "")) {

				} else {
					ret += "Fecha de la rutina: " + fecha + "\n\n";
				}
				if (ret.contains(nombreEjercicio)) {

				} else {
					ret += " Ejercicios: " + this.nombreEjercicio + " series: " + this.series + " repeticiones: "
							+ this.repeticiones + "\n";
				}

			}

		}

		return ret;
	}

}
