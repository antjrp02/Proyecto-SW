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

public class ElementoListaRutinas extends JPanel {
	
	private Ventana ventana;
	private String rutinas;
	
	
	public ElementoListaRutinas(Ventana v,String rutinas) {
		setBackground(Color.RED);
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.ventana=v;
		this.rutinas=rutinas;
		this.setMaximumSize(new Dimension(80000,70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{56, 0, 55, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JLabel labelNombre = new JLabel(ventana.usuarioLogeado.getNombre());
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 17));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.gridwidth = 3;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 0;
		add(labelNombre, gbc_labelNombre);
		
		
		JLabel labelFechaNacimiento = new JLabel(rutinas);
		GridBagConstraints gbc_labelFechaNacimiento = new GridBagConstraints();
		gbc_labelFechaNacimiento.gridheight = 2;
		gbc_labelFechaNacimiento.gridwidth = 4;
		gbc_labelFechaNacimiento.insets = new Insets(0, 0, 0, 5);
		gbc_labelFechaNacimiento.gridx = 1;
		gbc_labelFechaNacimiento.gridy = 1;
		add(labelFechaNacimiento, gbc_labelFechaNacimiento);
		
		
		
	}

}
