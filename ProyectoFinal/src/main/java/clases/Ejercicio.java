package clases;

import Enums.GruposMusculares;
import Enums.TipoEjercicio;
import superClases.EntidadConDificultad;

public class Ejercicio extends EntidadConDificultad {
	private GruposMusculares gruposMusculares;
	private TipoEjercicio tipoEjercicio;
	private boolean usaGoma;
	private boolean realizado;
	
	
	
	public Ejercicio(String nombre, String dificultad, GruposMusculares gruposMusculares, TipoEjercicio tipoEjercicio,
			boolean usaGoma, boolean realizado) {
		super(nombre, dificultad);
		this.gruposMusculares = gruposMusculares;
		this.tipoEjercicio = tipoEjercicio;
		this.usaGoma = usaGoma;
		this.realizado = realizado;
	}
	
	public GruposMusculares getGruposMusculares() {
		return gruposMusculares;
	}
	public void setGruposMusculares(GruposMusculares gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}
	public TipoEjercicio getTipoEjercicio() {
		return tipoEjercicio;
	}
	public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}
	public boolean isUsaGoma() {
		return usaGoma;
	}
	public void setUsaGoma(boolean usaGoma) {
		this.usaGoma = usaGoma;
	}
	public boolean isRealizado() {
		return realizado;
	}
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	
}
