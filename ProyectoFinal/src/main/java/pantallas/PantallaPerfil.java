package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class PantallaPerfil extends JPanel{
	
	private Ventana ventana;

	public PantallaPerfil(Ventana v) {
		setBorder(null);
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setSize(800, 500);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE, 2));
		panel_1.setBackground(new Color(8, 217, 214));
		panel_1.setBounds(0, 0, 800, 59);
		add(panel_1);
		
		JLabel lblMenu_1 = new JLabel("HARD WORKOUT");
		lblMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu_1.setForeground(new Color(37, 42, 52));
		lblMenu_1.setFont(new Font("Arial", Font.BOLD, 40));
		lblMenu_1.setBackground(Color.BLACK);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 800, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(87)
					.addComponent(lblMenu_1, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 59, Short.MAX_VALUE)
				.addComponent(lblMenu_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel borde = new JPanel();
		borde.setBorder(new LineBorder(new Color(255, 46, 99), 4, true));
		borde.setBackground(new Color(37, 42, 52));
		borde.setBounds(54, 104, 725, 331);
		add(borde);
		borde.setLayout(null);
		
		JLabel lbUsuario = new JLabel("Usuario:");
		lbUsuario.setForeground(new Color(255, 46, 99));
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		
		lbUsuario.setBounds(46, 27, 117, 33);
		borde.add(lbUsuario);
		
		JLabel lbUbicacion = new JLabel("Ubicacion: ");
		lbUbicacion.setForeground(new Color(255, 46, 99));
		lbUbicacion.setFont(new Font("Arial", Font.BOLD, 15));
		lbUbicacion.setBounds(46, 71, 117, 43);
		borde.add(lbUbicacion);
		
		JLabel lbNivel = new JLabel("Nivel: ");
		lbNivel.setForeground(new Color(255, 46, 99));
		lbNivel.setFont(new Font("Arial", Font.BOLD, 15));
		lbNivel.setBounds(46, 125, 117, 43);
		borde.add(lbNivel);
		
		JLabel lbEntrenamiento = new JLabel("Entrenamiento: ");
		lbEntrenamiento.setForeground(new Color(255, 46, 99));
		lbEntrenamiento.setFont(new Font("Arial", Font.BOLD, 15));
		lbEntrenamiento.setBounds(46, 187, 117, 33);
		borde.add(lbEntrenamiento);
		
		JLabel lbRutinas = new JLabel("N\u00BA rutinas: ");
		lbRutinas.setForeground(new Color(255, 46, 99));
		lbRutinas.setFont(new Font("Arial", Font.BOLD, 15));
		lbRutinas.setBounds(46, 253, 117, 41);
		borde.add(lbRutinas);
	}
}
