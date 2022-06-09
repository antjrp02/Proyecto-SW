package clases;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;
import superClases.EntidadConDificultad;

public class Ejercicio extends EntidadConDificultad {
	private GruposMusculares gruposMusculares;
	private TipoEjercicio tipoEjercicio;
	private boolean usaGoma;
	private boolean realizado;
	private byte series;
	
	
	
	
	public Ejercicio(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares, TipoEjercicio tipoEjercicio,
			boolean usaGoma, boolean realizado,byte series) {
		super(nombre, dificultad);
		this.gruposMusculares = gruposMusculares;
		this.tipoEjercicio = tipoEjercicio;
		this.usaGoma = usaGoma;
		this.realizado = realizado;
		this.series = series;
	}
	public Ejercicio(String nombre, byte series) {
		super(nombre);
		this.series = series;
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
