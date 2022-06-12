package excepciones;

/**
 * Excepcion creada que extiende de Excepcion que salta cuando un usuario
 * intenta hacer login con un usuario que no está registrado en la base de datps
 * 
 * @author Antonio Jesus
 *
 */
public class UsuarioNoExisteException extends Exception {

	public UsuarioNoExisteException(String msg) {
		super(msg);
	}

}
