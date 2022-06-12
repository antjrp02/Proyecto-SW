package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;
import utilsDB.UtilsDB;
/**
 * Clase EjercicioDinamico que extiende de ejercicio
 * @author Antonio Jesus
 */
public class EjercicioDinamico extends Ejercicio {
	//byte con el numero de repeticiones por ejercicioDinamico
	private byte repeticiones;

	/**
	 * @param nombre String es el nombre del ejercicio
	 * @param dificultad EnumDificultad es la dificultad del ejercicio
	 * @param gruposMusculares EnumGruoMuscular Grupo Muscular mas trabajado por el ejercicio
	 * @param tipoEjercicio enum TipoEjercicio para saber de que tipo es el ejercicio
	 * @param usaGoma bolean para saber si usa goma o no
	 * @param realizado boolean para saber si se ha realizado o no
	 * @param series byte con el numero de series que se realizan del ejercicio
	 * @param repeticiones byte con el numero de repeticiones por ejercicio dinamico
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
	public EjercicioDinamico(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series, byte repeticiones) throws SQLException {
		super(nombre, dificultad, gruposMusculares, tipoEjercicio, usaGoma, realizado, series);
		this.repeticiones = repeticiones;
		
		
	}
	/**
	 * 
	 * @param nombre String es el nombre del ejercicio
	 * @param series byte con el numero de series que se realizan del ejercicio
	 * @param repeticiones byte con el numero de repeticiones por ejercicio dinamico
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
	public EjercicioDinamico(String nombre,  byte series, byte repeticiones) throws SQLException {
		super(nombre,series);
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"Update ejercicio_dinamico set repeticiones = '" + repeticiones + "' where nombre = '" + nombre + "';");
		
		UtilsDB.desconectarBD();
		this.nombre=nombre;
		this.series=series;
		this.repeticiones = repeticiones;
	}

	//Constructor vacio
	public EjercicioDinamico() {
		super();
	}
	
	/**
	 * getter de repeticiones
	 * @return byte
	 */
	public byte getRepeticiones() {
		return repeticiones;
	}
	/**
	 * Setter de repeticiones
	 * @param repeticiones byte
	 */
	public void setRepeticiones(byte repeticiones) {
		this.repeticiones = repeticiones;
	}
	
	
	
	@Override
	public String toString() {
		return "Ejercicio: "+nombre+" series: " + series + " repeticiones:  " + repeticiones ;
	}

}
