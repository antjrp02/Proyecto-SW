package excepciones;

/**
 * Excepcion creada que extiende de Excepcion que salta cuando un usuario
 * es creado con una ubicacion invalida "..."
 * @author Antonio Jesus
 */
public class UbicacionVaciaException extends Exception {
	public UbicacionVaciaException(String msg) {
		super(msg);
	}
}
