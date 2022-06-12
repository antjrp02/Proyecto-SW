package elementosvisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Rutina;
import clases.Usuario;
import pantallas.Ventana;
import javax.swing.JScrollPane;

/**
 * Clase para mostrar las rutinasd del usuario por pantalla
 * 
 * @author Antonio Jesus
 */
public class ElementoListaRutinas extends JPanel {
	// ventana donde se mostraran todasd las rutinas
	private Ventana ventana;
	// String con todas las rutinas concatenadas
	private String rutinas;

	/**
	 * Este constructor funciona pasandole las rutinas ya concatenadas desde fuera,
	 * con un arrayList y este se encarga de imprimir la que le llega por parametros
	 * de String
	 * 
	 * @param v Ventana donde va a mostrar todas las rutinas
	 * @param rutinas String de rutinas concatenadas a mostrar
	 */
	public ElementoListaRutinas(Ventana v, String rutinas) {
		setBackground(new Color(37, 42, 52));
		setBorder(new LineBorder(new Color(255, 46, 99), 4, true));
		this.ventana = v;
		this.rutinas = rutinas;
		this.setMaximumSize(new Dimension(80000, 70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 0, 0, 330, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 154, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		JLabel labelFechaNacimiento = new JLabel(rutinas);
		scrollPane.setViewportView(labelFechaNacimiento);

	}

}
