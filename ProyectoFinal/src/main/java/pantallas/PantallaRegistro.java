package pantallas;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import elementosvisuales.boton1;
import elementosvisuales.boton2;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import clases.Usuario;

public class PantallaRegistro extends JPanel {
	private JTextField campoUsario;
	private JPasswordField campoContraseña;
	private JTextField campoUbicacion;
	private Ventana ventana;
	public PantallaRegistro(Ventana v) {
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("HARD WORKOUT");
		lblNewLabel_2.setBounds(203, 50, 338, 47);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(8, 217, 214));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 40));
		add(lblNewLabel_2);
		
		JLabel lbUsuario = new JLabel("Usuario: ");
		lbUsuario.setBounds(60, 186, 69, 19);
		lbUsuario.setVerticalAlignment(SwingConstants.TOP);
		lbUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lbUsuario.setForeground(new Color(255, 46, 99));
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		add(lbUsuario);
		
		campoUsario = new JTextField();
		campoUsario.setBounds(202, 186, 285, 19);
		add(campoUsario);
		campoUsario.setColumns(10);
		
		JLabel lbContraseña = new JLabel("Contrase\u00F1a:");
		lbContraseña.setBounds(60, 214, 93, 19);
		lbContraseña.setForeground(new Color(255, 46, 99));
		lbContraseña.setFont(new Font("Arial", Font.BOLD, 16));
		add(lbContraseña);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(202, 214, 285, 19);
		add(campoContraseña);
		
		JLabel lblNivel = new JLabel("Nivel: ");
		lblNivel.setBounds(60, 238, 47, 19);
		lblNivel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNivel.setForeground(new Color(255, 46, 99));
		lblNivel.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNivel);
		
		JComboBox nivelBox = new JComboBox();
		nivelBox.setBounds(202, 238, 52, 19);
		nivelBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		add(nivelBox);
		
		JLabel lblUbicacion = new JLabel("Ubicacion: ");
		lblUbicacion.setBounds(60, 262, 85, 19);
		lblUbicacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblUbicacion.setForeground(new Color(255, 46, 99));
		lblUbicacion.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblUbicacion);
		
		campoUbicacion = new JTextField();
		campoUbicacion.setBounds(202, 262, 285, 19);
		add(campoUbicacion);
		campoUbicacion.setColumns(10);
		
		JLabel yerayPinito = new JLabel("");
		yerayPinito.setBounds(0, 0, 0, 0);
		add(yerayPinito);
		
		JLabel lbAyuda = new JLabel("No se que nivel escoger");
		lbAyuda.setBounds(60, 301, 182, 19);
		lbAyuda.setHorizontalAlignment(SwingConstants.LEFT);
		lbAyuda.setForeground(new Color(255, 46, 99));
		lbAyuda.setFont(new Font("Arial", Font.BOLD, 16));
		add(lbAyuda);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(259, 300, 61, 21);
		add(btnNewButton);
		
		JButton botonRegistro = new boton2("Registrarme");
		botonRegistro.setBounds(60, 372, 130, 21);
		add(botonRegistro);
		JLabel yerayPinito_1 = new JLabel("");
		yerayPinito_1.setBounds(452, 10, 338, 565);
		yerayPinito_1.setIcon(new ImageIcon("C:\\Users\\antjr\\Downloads\\yerai_pino-removebg-preview.png"));
		add(yerayPinito_1);
		
		JPanel borde = new JPanel();
		borde.setBounds(38, 135, 503, 290);
		borde.setLayout(null);
		borde.setBorder(new LineBorder(new Color(255, 46, 99), 4, true));
		borde.setBackground(new Color(37, 42, 52));
		add(borde);
		
		JButton botonAtras = new boton1("Atrás");
		botonAtras.setBounds(416, 259, 77, 21);
		borde.add(botonAtras);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("login");
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.EAST;
		gbc_botonAtras.gridx = 5;
		gbc_botonAtras.gridy = 10;
		
		
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String nombre = campoUsuario.getText();
					String contraseña = new String(campoContraseña.getPassword());
					Byte nivel = (Byte) nivelBox.getSelectedItem();

					new Usuario(nombre, contraseña, (short) fechaNacimiento.getYear(), fechaNacimiento,
							LocalDateTime.now(), LocalTime.now());
				} catch (DateTimeException | SQLException
						| ContraseñaVaciaException|
						EmailValidoException | AñoInvalidoException e1) {
					JOptionPane.showMessageDialog(
					ventana,e1.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					
					//TODO METER EL ERROR DEL SPLIT DE LA CONTRASEÑA
				} 
			}
		});
		
	}
}
