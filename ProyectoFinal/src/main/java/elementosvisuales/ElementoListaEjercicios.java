package elementosvisuales;

import javax.swing.JPanel;

import clases.Usuario;
import pantallas.Ventana;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElementoListaEjercicios extends JPanel{
	private Ventana ventana;
	private String ejercicios;
	private JButton botonScroll;
	
	public ElementoListaEjercicios(Ventana v,String ejercicios) {
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.ventana=v;
		this.ejercicios=ejercicios;
		this.setMaximumSize(new Dimension(80000,70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{435, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		setPreferredSize(new Dimension(900,200));
		
		
		
		
		
		JLabel lbEjercicios = new JLabel(ejercicios.toString());
		lbEjercicios.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lbEjercicios);
		lbEjercicios.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		botonScroll = new JButton("New button");
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		
		
		
		
		
	}

}
