package excepciones;

/**
 * Excepcion creada que extiende de excepcion, salt� cuando el usuario infrese
 * el usuario en blanco
 * 
 * @author Antonio Jesus
 *
 */
public class UsuarioVacioException extends Exception {
	public UsuarioVacioException(String msg) {
		super(msg);
	}
}
