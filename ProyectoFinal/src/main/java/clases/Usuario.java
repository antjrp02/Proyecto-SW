package clases;

import superClases.EntidadConNombre;

public class Usuario extends EntidadConNombre{
	private String contraseña;
	private byte nivel;
	private String UbicacionEntrenamiento;
	private Entrenamiento entrenamiento;
	
	public Usuario(String nombre, String contraseña, byte nivel, String ubicacionEntrenamiento,
			Entrenamiento entrenamiento) {
		super(nombre);
		this.contraseña = contraseña;
		this.nivel = nivel;
		UbicacionEntrenamiento = ubicacionEntrenamiento;
		this.entrenamiento = entrenamiento;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public byte getNivel() {
		return nivel;
	}
	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}
	public String getUbicacionEntrenamiento() {
		return UbicacionEntrenamiento;
	}
	public void setUbicacionEntrenamiento(String ubicacionEntrenamiento) {
		UbicacionEntrenamiento = ubicacionEntrenamiento;
	}
	public Entrenamiento getEntrenamiento() {
		return entrenamiento;
	}
	public void setEntrenamiento(Entrenamiento entrenamiento) {
		this.entrenamiento = entrenamiento;
	}
	
	
	
	
	
	
}
