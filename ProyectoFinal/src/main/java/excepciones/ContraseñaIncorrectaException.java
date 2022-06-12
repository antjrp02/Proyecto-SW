package excepciones;

/**
 * Excepcion creada que extiende de Excepcion que salta cuando un usuario
 * intenta hacer login con una contraseña que no es correcta
 * @author Antonio Jesus
 */
public class ContraseñaIncorrectaException extends Exception {

	public ContraseñaIncorrectaException(String msg) {
		super(msg);
	}

}
