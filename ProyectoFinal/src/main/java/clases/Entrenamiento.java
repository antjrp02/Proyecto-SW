package clases;

import java.util.ArrayList;

import Enums.TipoEntrenamiento;

public class Entrenamiento {
	private ArrayList<Rutina>rutinas;
	private TipoEntrenamiento tipoEntrenamiento;
	
	
	public Entrenamiento(ArrayList<Rutina> rutinas, TipoEntrenamiento tipoEntrenamiento) {
		super();
		this.rutinas = rutinas;
		this.tipoEntrenamiento = tipoEntrenamiento;
	}
	
	public ArrayList<Rutina> getRutinas() {
		return rutinas;
	}
	public void setRutinas(ArrayList<Rutina> rutinas) {
		this.rutinas = rutinas;
	}
	public TipoEntrenamiento getTipoEntrenamiento() {
		return tipoEntrenamiento;
	}
	public void setTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento) {
		this.tipoEntrenamiento = tipoEntrenamiento;
	}
	
	
	
}
