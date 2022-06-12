package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;
import utilsDB.UtilsDB;

public class EjercicioDinamico extends Ejercicio {
	private byte repeticiones;
	private String nombreEjercicio;

	public EjercicioDinamico(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series, byte repeticiones) throws SQLException {
		super(nombre, dificultad, gruposMusculares, tipoEjercicio, usaGoma, realizado, series);
		this.repeticiones = repeticiones;
		
		
	}
	
	public EjercicioDinamico(String nombre,  byte series, byte repeticiones) throws SQLException {
		super(nombre,series);
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"Update ejercicio_dinamico set repeticiones = '" + repeticiones + "' where nombre = '" + nombre + "';");
		
		UtilsDB.desconectarBD();
		this.nombreEjercicio=nombre;
		
		this.repeticiones = repeticiones;
	}

	
	public EjercicioDinamico() {
		super();
	}

	public byte getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(byte repeticiones) {
		this.repeticiones = repeticiones;
	}
	
	
	
	@Override
	public String toString() {
		return "Ejercicio: "+nombre+" series: " + series + " repeticiones:  " + repeticiones ;
	}

}
