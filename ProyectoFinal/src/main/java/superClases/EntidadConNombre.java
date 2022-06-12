package superClases;

import excepciones.UsuarioVacioException;
/**
 * 
 * @author Antonio Jesus
 * Clase EntidadConNombre, de la cual heredan otras clases para no repetir variables.
 *
 */
public class EntidadConNombre {
	//String nombre con el cual le daremos nombre a todos los objetos que lo necsiten
	protected String nombre;

	
	/**
	 * 
	 * @param nombre Se le pasa un String el cual servirá como nombre para todas las demas clases que hereden de esta
	 */
	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return de tipo String, esta funcion sirve principalmente para poder ver el nombre de un objeto y o modificarlo.
	 */
	public String getNombre() {
		return nombre;
	}
/**
 * 
 * @param nombre de tipo String
 * @throws UsuarioVacioException  esta excepcion saltará cada vez que se inserte un nombre de usuario no valido en el programa.
 */
	public void setNombre(String nombre) throws UsuarioVacioException {
		if (!this.UsuarioValido(nombre)) {
			throw new UsuarioVacioException("El usuario no es valido.");
		}
		this.nombre = nombre;
	}
	public EntidadConNombre() {
		super();
	}
	/**
	 * 
	 * @param usuario de tipo String
	 * @return un String que no estará vacio, esta funcion se utiliza para comprobar que el usuario no se inserta vacio en el programa.
	 */
	protected boolean UsuarioValido(String usuario) {
		return !usuario.isBlank();
	}
	
}
