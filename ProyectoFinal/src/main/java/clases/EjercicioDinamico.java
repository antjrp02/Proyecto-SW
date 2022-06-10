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
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"Update ejercicio_dinamico set repeticiones = '" + repeticiones + "' where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		
	}
	
	public EjercicioDinamico(String nombre,  byte series, byte repeticiones) {
		super(nombre,series);
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
	
	public ArrayList<String> nombreEjercicio() throws SQLException{
		ArrayList<String> nombreEjercicio = new ArrayList<String>();
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos=smt.executeQuery("Select nombre from ejercicio_Dinamico ;");
		while (devuelveDatos.next()) {
			this.nombreEjercicio=devuelveDatos.getString("nombre");
			nombreEjercicio.add(this.nombreEjercicio);
		}
		UtilsDB.desconectarBD();
		return nombreEjercicio;
	}
}
