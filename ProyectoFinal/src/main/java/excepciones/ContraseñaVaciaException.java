package excepciones;
/**
 * Excepcion creada que extiende de Excepcion que salta cuando un usuario
 * inserta una contrase�a vacia
 * @author Antonio Jesus
 */
public class Contrase�aVaciaException extends Exception {
	
	public Contrase�aVaciaException(String msg) {
		super(msg);
	}
}
