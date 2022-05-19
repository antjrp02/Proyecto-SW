package superClases;

public class EntidadConDificultad extends EntidadConNombre{
	private String dificultad;

	
	public EntidadConDificultad(String nombre, String dificultad) {
		super(nombre);
		this.dificultad = dificultad;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	
	
}
