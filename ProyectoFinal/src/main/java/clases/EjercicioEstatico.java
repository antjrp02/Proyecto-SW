package clases;

import java.sql.SQLException;
import java.sql.Statement;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;
import utilsDB.UtilsDB;

public class EjercicioEstatico extends Ejercicio {
	private byte aguanteSg;
	
	
	public EjercicioEstatico(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series, byte aguanteSg) {
		super(nombre, dificultad, gruposMusculares, tipoEjercicio, usaGoma, realizado, series);
		this.aguanteSg = aguanteSg;
	}
	
	

	public EjercicioEstatico(String nombre,  byte series, byte aguanteSg) throws SQLException {
		super(nombre,series);
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"Update ejercicio_estatico set aguanteSg = '" + aguanteSg + "' where nombre = '" + nombre + "';");
		
		UtilsDB.desconectarBD();
		this.nombre=nombre;
		
		this.aguanteSg = aguanteSg;
	}
	
	public byte getAguanteSg() {
		return aguanteSg;
	}

	public void setAguanteSg(byte aguanteSg) {
		this.aguanteSg = aguanteSg;
	}


	
	
	
}
