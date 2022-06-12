package superClases;

import Enums.Dificultad;

public class EntidadConDificultad extends EntidadConNombre{
	protected Dificultad dificultad;

	
	public EntidadConDificultad() {
		super();
	}

	public EntidadConDificultad(String nombre) {
		super(nombre);
	}

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
