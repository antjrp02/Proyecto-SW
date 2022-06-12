package clases;

import java.sql.SQLException;
import java.sql.Statement;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;
import utilsDB.UtilsDB;
/**
 * **
* Clase Estatico que extiende de ejercicio
* @author Antonio Jesus
*/
 
public class EjercicioEstatico extends Ejercicio {
	//aguanteSg byte numerod e segundos que se aguanta el ejercicio estatico
	private byte aguanteSg;
	
	/**
	 * @param nombre String es el nombre del ejercicio
	 * @param dificultad EnumDificultad es la dificultad del ejercicio
	 * @param gruposMusculares EnumGruoMuscular Grupo Muscular mas trabajado por el ejercicio
	 * @param tipoEjercicio enum TipoEjercicio para saber de que tipo es el ejercicio
	 * @param usaGoma bolean para saber si usa goma o no
	 * @param realizado boolean para saber si se ha realizado o no
	 * @param series byte con el numero de series que se realizan del ejercicio
	 * @param aguanteSg byte con el numero de segundos que se aguanta el ejercicio 
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
	public EjercicioEstatico(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series, byte aguanteSg) {
		super(nombre, dificultad, gruposMusculares, tipoEjercicio, usaGoma, realizado, series);
		this.aguanteSg = aguanteSg;
	}
	
	
	/**
	 * 
	 * @param nombre String es el nombre del ejercicio
	 * @param series byte con el numero de series que se realizan del ejercicio
	 * @param aguanteSg byte con el numero de segundos que se aguanta el ejercicio 
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
	public EjercicioEstatico(String nombre,  byte series, byte aguanteSg) throws SQLException {
		super(nombre,series);
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"Update ejercicio_estatico set aguanteSg = '" + aguanteSg + "' where nombre = '" + nombre + "';");
		
		UtilsDB.desconectarBD();
		this.nombre=nombre;
		
		this.aguanteSg = aguanteSg;
	}
	
	


	/**
	 * getter de aguanteSg
	 * @return byte
	 */
	public byte getAguanteSg() {
		return aguanteSg;
	}
	/**
	 * setter de aguanteSg
	 * @param aguanteSg byte
	 */
	public void setAguanteSg(byte aguanteSg) {
		this.aguanteSg = aguanteSg;
	}


	
	
	
}
