package clases;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;

public class EjercicioEstatico extends Ejercicio {
	private byte aguanteSg;

	
	public EjercicioEstatico(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series, byte aguanteSg) {
		super(nombre, dificultad, gruposMusculares, tipoEjercicio, usaGoma, realizado, series);
		this.aguanteSg = aguanteSg;
	}
	
	
	public byte getAguanteSg() {
		return aguanteSg;
	}

	public void setAguanteSg(byte aguanteSg) {
		this.aguanteSg = aguanteSg;
	}


	
	
	
}
