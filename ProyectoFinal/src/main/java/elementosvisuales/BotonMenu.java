package elementosvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BotonMenu extends JButton {
	public BotonMenu(String m) {
		super(m);
		estiloPorDefecto();

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				setBackground(new Color(150, 10, 30));
				

			}

			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}
		});
	}

	private void estiloPorDefecto() {
		this.setBackground(new Color(255, 46, 99));
		this.setForeground(new Color(255,255,255));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Source Sans Pro", Font.PLAIN, 19));
		
	}
}

