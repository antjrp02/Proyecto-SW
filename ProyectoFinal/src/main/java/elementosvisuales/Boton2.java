package elementosvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
/**
 * Constructor que le da las caracteristicas al boton
 * @param m String para el mensaje que queramos dentro
 */
public class Boton2 extends Boton1 {
	public Boton2(String m) {
		super(m);
		estiloPorDefecto();
		//Esta funcion se encarga de que si el cursor está encima del boton, este cambie
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Y una vez que ya no está el cursor encima del boton,lo devuelve por defecto
				setBackground(new Color(255, 46, 99));
				setSize(190, 21);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}
		});
	}
	/**
	 * Esta funcion devuelde por defecto los valores del boton
	 */
	private void estiloPorDefecto() {
		this.setBackground(new Color(8, 217, 214));
		this.setForeground(new Color(37, 42, 52));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Source Sans Pro", Font.PLAIN, 19));
		this.setSize(130, 21);
	}

}
