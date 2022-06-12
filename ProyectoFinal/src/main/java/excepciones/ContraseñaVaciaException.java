package excepciones;
/**
 * Excepcion creada que extiende de Excepcion que salta cuando un usuario
 * inserta una contraseña vacia
 * @author Antonio Jesus
 */
public class ContraseñaVaciaException extends Exception {
	
	public ContraseñaVaciaException(String msg) {
		super(msg);
	}
}
