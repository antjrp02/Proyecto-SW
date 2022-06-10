package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Rutina {
	private ArrayList<Ejercicio> ejercicios;
	private int descansoSg;
	private LocalDateTime fecha;
	
	
	public Rutina(ArrayList<Ejercicio> ejercicios, int descansoSg, LocalDateTime fecha) {
		super();
		this.ejercicios = ejercicios;
		this.descansoSg = descansoSg;
		this.fecha = fecha;
	}
	public void imprimirEjercicios(ArrayList<Ejercicio> ejercicios) {
		for(int i=0;i<ejercicios.size();i++) {
			System.out.println(ejercicios.get(i));
		}
		
	}
	
	public Rutina() {
		//Genera rutina vacía OJO: INICIALIZAR ARRAYLIST
	}

	public void añadirEjercicio(Ejercicio e) {
		ArrayList<Ejercicio> ejercicios=new ArrayList<Ejercicio>();
		ejercicios.add(e);
		System.out.println("Ejercicio añadido al arrayList");
		
	}
	
	

	public boolean borrarEjercicio(Ejercicio e) {
		return this.ejercicios.remove(e);
	}
	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	public int getDescansoSg() {
		return descansoSg;
	}
	public void setDescansoSg(byte descansoSg) {
		this.descansoSg = descansoSg;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	public ArrayList<Ejercicio> ejerciciosRutina(ArrayList<Ejercicio> ejercicios){
		
		return ejercicios;
		
	}
	public Rutina(ArrayList<Ejercicio> ejercicios) {
		super();
		this.ejercicios = ejercicios;
	}
}
