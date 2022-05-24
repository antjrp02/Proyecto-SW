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
import excepciones.ContraseñaVaciaException;
import excepciones.UbicacionVaciaException;
import excepciones.UsuarioVacioException;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import clases.Usuario;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class PantallaRegistro extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
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
		
		
		JButton botonRegistro = new boton2("Registrarme");
		botonRegistro.setBounds(60, 372, 130, 21);
		add(botonRegistro);
		JLabel yerayPinito_1 = new JLabel("");
		yerayPinito_1.setBounds(452, 10, 338, 565);
		yerayPinito_1.setIcon(new ImageIcon("C:\\Users\\antjr\\Downloads\\yerai_pino-removebg-preview.png"));
		add(yerayPinito_1);
		
		JPanel borde = new JPanel();
		borde.setBounds(38, 135, 503, 290);
		borde.setBorder(new LineBorder(new Color(255, 46, 99), 4, true));
		borde.setBackground(new Color(37, 42, 52));
		add(borde);
		borde.setLayout(null);
		
		JButton botonAtras = new boton1("Atrás");
		botonAtras.setBounds(416, 259, 77, 21);
		borde.add(botonAtras);
		
		
		JLabel lblUbicacion = new JLabel("Ubicacion: ");
		lblUbicacion.setBounds(23, 109, 85, 19);
		borde.add(lblUbicacion);
		lblUbicacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblUbicacion.setForeground(new Color(255, 46, 99));
		lblUbicacion.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lbContraseña = new JLabel("Contrase\u00F1a:");
		lbContraseña.setBounds(23, 80, 93, 19);
		borde.add(lbContraseña);
		lbContraseña.setForeground(new Color(255, 46, 99));
		lbContraseña.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lbUsuario = new JLabel("Usuario: ");
		lbUsuario.setBounds(23, 51, 69, 19);
		borde.add(lbUsuario);
		lbUsuario.setVerticalAlignment(SwingConstants.TOP);
		lbUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lbUsuario.setForeground(new Color(255, 46, 99));
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(167, 82, 285, 19);
		borde.add(campoContraseña);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(167, 53, 285, 19);
		borde.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		final JComboBox listaUbicacion = new JComboBox();
		listaUbicacion.setModel(new DefaultComboBoxModel(new String[] {"...", "Madrid\t", "Barcelona\t", "Valencia\t", "Sevilla\t", "Alicante\t", "M\u00E1laga\t", "Murcia\t", "C\u00E1diz\t", "Vizcaya\t", "La Coru\u00F1a\t", "Las Palmas\t", "Baleares\t", "Asturias\t", "Tenerife", "Zaragoza\t", "Pontevedra\t", "Granada\t", "Tarragona\t", "C\u00F3rdoba\t", "Gerona\t", "Guip\u00FAzcoa\t", "Almer\u00EDa\t", "Toledo\t", "Badajoz\t", "Ja\u00E9n\t", "Navarra\t", "Cantabria\t", "Castell\u00F3n\t", "Valladolid\t", "Ciudad Real\t", "Huelva\t", "Le\u00F3n\t", "L\u00E9rida\t", "C\u00E1ceres\t", "Albacete\t", "Burgos\t", "Lugo\t", "Salamanca\t", "Orense\t", "\u00C1lava\t", "La Rioja\t", "Guadalajara\t", "Huesca\t", "Cuenca\t", "Zamora", "Palencia\t", "\u00C1vila\t", "Segovia\t", "Teruel\t", "Soria\t", "Ceuta\t", "Melilla"}));
		
		
		listaUbicacion.setBounds(167, 113, 285, 21);
		borde.add(listaUbicacion);
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
				
					
					String nombre = new String(campoUsuario.getText());
					String contraseña = new String(campoContraseña.getPassword());
					String ubicacion = (String) listaUbicacion.getSelectedItem();
					System.out.println(ubicacion);

					try {
						Usuario u = new Usuario(nombre, contraseña, ubicacion);
						JOptionPane.showMessageDialog(
								ventana,"Usuario "+nombre+" registrado con exito","Registrado con exito",
								JOptionPane.INFORMATION_MESSAGE);
							ventana.cambiarAPantalla("login");
						
					} catch (SQLException|ContraseñaVaciaException | UsuarioVacioException | UbicacionVaciaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(
								ventana,e1.getMessage(),"Error",
								JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		
	}
}
