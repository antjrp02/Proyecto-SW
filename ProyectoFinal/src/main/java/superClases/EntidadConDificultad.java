package superClases;

import Enums.Dificultad;
/**
 * 
 * @author Antonio Jesus 
 * De la clase entidadconDificultad, directa o indirectamente(si hereda de otra clase que herede de esta) heredarán todas las clases que contengan ejercicios.
 *
 */
public class EntidadConDificultad extends EntidadConNombre{
	//Enum de Dificultad para poder asignar la dificultad de los ejercicios y de todas las clases que hereden de esta.
	protected Dificultad dificultad;

	
	public EntidadConDificultad() {
		super();
	}
	/**
	 * 
	 * @param nombre de tipo String, el cual está vacio porque se ha necesitado asi.
	 */
	public EntidadConDificultad(String nombre) {
		super(nombre);
	}
	/**
	 * 
	 * @param nombre de tipo String
	 * @param dificultad dificultad que es un enum de Dificultad
	 * Esta funcion hace posible que todas las clases que necesiten el campo dificultad puedan heredarlo de aquí.
	 */
	public EntidadConDificultad(String nombre, Dificultad dificultad) {
		super(nombre);
		this.dificultad = dificultad;
	}
	/**
	 * 
	 * @return dificultad de tipo Dificultad
	 * Esta funcion sive para poder ver la dificultad de un ejercicio y o modificarlo.
	 */
	public Dificultad getDificultad() {
		return dificultad;
	}
	/**
	 * 
	 * @param dificultad de tipo Dificultad
	 * con esta funcion cualquier clase que erede de esta puede añadir la dificultad para su objeto.
	 */
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	
	
}
