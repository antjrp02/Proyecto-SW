package excepciones;

/**
 * Excepcion creada que extiende de Excepcion que salta cuando un usuario
 * intenta hacer login con una contrase�a que no es correcta
 * @author Antonio Jesus
 */
public class Contrase�aIncorrectaException extends Exception {

	public Contrase�aIncorrectaException(String msg) {
		super(msg);
	}

}
