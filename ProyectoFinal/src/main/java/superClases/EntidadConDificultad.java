package superClases;

import Enums.Dificultad;

public class EntidadConDificultad extends EntidadConNombre{
	private Dificultad dificultad;

	
	public EntidadConDificultad(String nombre, Dificultad dificultad) {
		super(nombre);
		this.dificultad = dificultad;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	
	
}
