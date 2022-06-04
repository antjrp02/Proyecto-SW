package clases;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;

public class EjercicioDinamico extends Ejercicio {
	private byte repeticiones;

	public EjercicioDinamico(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series, byte repeticiones) {
		super(nombre, dificultad, gruposMusculares, tipoEjercicio, usaGoma, realizado, series);
		this.repeticiones = repeticiones;
	}

	public byte getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(byte repeticiones) {
		this.repeticiones = repeticiones;
	}

}
