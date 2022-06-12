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


import elementosvisuales.Boton1;
import elementosvisuales.Boton2;
import elementosvisuales.Boton3;
import excepciones.Contrase�aVaciaException;
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
/**
 * 
 * @author Antonio Jesus
 * La clase PantallaRegistro creara la pantalla con la cual podremos insertar usuarios en la base de datos y poder registrarnos con el en la app
 *
 */
public class PantallaRegistro extends JPanel {
	//campoUsuario es un textField, en el cual insertaremos el nombre de usuario
	private JTextField campoUsuario;
	//campoContrase�a es el campo donde insertaremos la contrase�a, la diferencia entre JTextField y un JPasswordField es que este no mostrara el contenido al escribirlo
	private JPasswordField campoContrase�a;
	//ventana de Tipo Venntana, en la cual aparecera la pantalla de registro
	private Ventana ventana;
	/**
	 * Constructor que crea la pantalla de registro, en la cual insertaremos los datos que nos pide e insertar� el usuario en la base de dato y 
	 * ya podremo iniciar sesion con el.
	 * 
	 * @param v es la Ventana en la cual apareceran todos los campos de la pantalla.
	 */
	public PantallaRegistro(Ventana v) {
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("HARD WORKOUT");
		lblNewLabel_2.setBounds(38, 77, 503, 47);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(8, 217, 214));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 40));
		add(lblNewLabel_2);
		JLabel yerayPinito = new JLabel("New label");
		yerayPinito.setIcon(new ImageIcon("./yerai.png"));
		yerayPinito.setBounds(483, -23, 365, 539);
		add(yerayPinito);

		JPanel borde = new JPanel();
		borde.setBounds(38, 135, 503, 290);
		borde.setBorder(new LineBorder(new Color(255, 46, 99), 4, true));
		borde.setBackground(new Color(37, 42, 52));
		add(borde);
		borde.setLayout(null);
		
		JButton botonAtras = new Boton3("Atr�s");
		botonAtras.setBounds(393, 259, 100, 21);
		borde.add(botonAtras);
		
		
		JLabel lblUbicacion = new JLabel("Ubicacion: ");
		lblUbicacion.setBounds(23, 109, 108, 19);
		borde.add(lblUbicacion);
		lblUbicacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblUbicacion.setForeground(new Color(255, 46, 99));
		lblUbicacion.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lbContrase�a = new JLabel("Contrase\u00F1a:");
		lbContrase�a.setBounds(23, 80, 108, 19);
		borde.add(lbContrase�a);
		lbContrase�a.setForeground(new Color(255, 46, 99));
		lbContrase�a.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lbUsuario = new JLabel("Usuario: ");
		lbUsuario.setBounds(23, 51, 108, 19);
		borde.add(lbUsuario);
		lbUsuario.setVerticalAlignment(SwingConstants.TOP);
		lbUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lbUsuario.setForeground(new Color(255, 46, 99));
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		
		campoContrase�a = new JPasswordField();
		campoContrase�a.setBounds(167, 82, 285, 19);
		borde.add(campoContrase�a);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(167, 53, 285, 19);
		borde.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		final JComboBox listaUbicacion = new JComboBox();
		listaUbicacion.setModel(new DefaultComboBoxModel(new String[] {"...", "Madrid\t", "Barcelona\t", "Valencia\t", "Sevilla\t", "Alicante\t", "M\u00E1laga\t", "Murcia\t", "C\u00E1diz\t", "Vizcaya\t", "La Coru\u00F1a\t", "Las Palmas\t", "Baleares\t", "Asturias\t", "Tenerife", "Zaragoza\t", "Pontevedra\t", "Granada\t", "Tarragona\t", "C\u00F3rdoba\t", "Gerona\t", "Guip\u00FAzcoa\t", "Almer\u00EDa\t", "Toledo\t", "Badajoz\t", "Ja\u00E9n\t", "Navarra\t", "Cantabria\t", "Castell\u00F3n\t", "Valladolid\t", "Ciudad Real\t", "Huelva\t", "Le\u00F3n\t", "L\u00E9rida\t", "C\u00E1ceres\t", "Albacete\t", "Burgos\t", "Lugo\t", "Salamanca\t", "Orense\t", "\u00C1lava\t", "La Rioja\t", "Guadalajara\t", "Huesca\t", "Cuenca\t", "Zamora", "Palencia\t", "\u00C1vila\t", "Segovia\t", "Teruel\t", "Soria\t", "Ceuta\t", "Melilla"}));
		
		
		listaUbicacion.setBounds(167, 113, 285, 21);
		borde.add(listaUbicacion);
		
		
		JButton botonRegistro = new Boton2("Registrarme");
		botonRegistro.setBounds(23, 259, 130, 21);
		borde.add(botonRegistro);
		
		
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion, la cual al hacer clic sobre el botonRegistro, almacenara los datos del usuario en la base de datos.
			 */
			public void mouseClicked(MouseEvent e) {
				
					
					String nombre = new String(campoUsuario.getText());
					String contrase�a = new String(campoContrase�a.getPassword());
					String ubicacion = (String) listaUbicacion.getSelectedItem();
					

					try {
						Usuario u = new Usuario(nombre, contrase�a, ubicacion);
						JOptionPane.showMessageDialog(
								ventana,"Usuario "+nombre+" registrado con exito","Registrado con exito",
								JOptionPane.INFORMATION_MESSAGE);
							ventana.cambiarAPantalla("login");
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(
								ventana,"Usuario ya existente","Error",
								JOptionPane.ERROR_MESSAGE);
					}catch(Contrase�aVaciaException | UsuarioVacioException | UbicacionVaciaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(
								ventana,e1.getMessage(),"Error",
								JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion, la cual al hacer clic sobre el botonAtras, nos llevar� a la pantalla de login.
			 */
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("login");
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.EAST;
		gbc_botonAtras.gridx = 5;
		gbc_botonAtras.gridy = 10;
		
	}
}
