package elementosvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
/**
 * Boton 1 creado para usarse en la pantalla de login
 * @author Antonio Jesus
 */
public class Boton1 extends JButton {
	/**
	 * Constructor que le da las caracteristicas al botom¡n
	 * @param m String para el mensaje que queramos dentro
	 */
	public Boton1(String m) {
		super(m);
		estiloPorDefecto();

		this.addMouseListener(new MouseAdapter() {
			@Override
			//Esta funcion se encarga de que si el cursor está encima del boton, este cambie
			public void mouseEntered(MouseEvent e) {

				setBackground(new Color(255, 46, 99));
				setSize(190, 21);

			}

			@Override
			//Y una vez que ya no está el cursor encima del boton,lo devuelve por defecto
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}
		});
	}
	/**
	 * Esta funcion devuelde por defecto los valores del boton
	 */
	private void estiloPorDefecto() {
		this.setBackground(new Color(204, 255, 204));
		this.setForeground(new Color(37, 42, 52));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Source Sans Pro", Font.PLAIN, 19));
		this.setSize(130, 21);
	}
}
