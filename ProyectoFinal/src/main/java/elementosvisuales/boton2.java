package elementosvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class boton2 extends boton1 {
	public boton2(String m) {
		super(m);
		estiloPorDefecto();

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				setBackground(new Color(255, 46, 99));
				setSize(190, 21);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}
		});
	}
	private void estiloPorDefecto() {
		this.setBackground(new Color(8, 217, 214));
		this.setForeground(new Color(37, 42, 52));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Source Sans Pro", Font.PLAIN, 19));
		this.setSize(130, 21);
	}

}
