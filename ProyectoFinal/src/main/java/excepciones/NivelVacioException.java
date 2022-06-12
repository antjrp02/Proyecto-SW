package excepciones;
/**
 * Excepcion creada que extiende de Excepcion que salta cuando un usuario
 * selecciona un nivel invalido"..."
 * @author Antonio Jesus
 */
public class NivelVacioException extends Exception {

	public NivelVacioException(String msg) {
		super(msg);
	}

}
