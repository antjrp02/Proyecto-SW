package superClases;

import excepciones.UsuarioVacioException;

public class EntidadConNombre {
	private String nombre;

	
	
	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws UsuarioVacioException {
		if (!this.UsuarioValido(nombre)) {
			throw new UsuarioVacioException("La contraseņa no puede estar vacia.");
		}
		this.nombre = nombre;
	}
	protected boolean UsuarioValido(String usuario) {
		return !usuario.isBlank();
	}
	
}
