package pantallas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import clases.Usuario;
import elementosvisuales.Boton2;
import excepciones.ContraseñaIncorrectaException;
import excepciones.ContraseñaVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import elementosvisuales.Boton1;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

/**
 * Clase pantallagin es la forma de que un usuario de la base de datos pueda
 * acceder de forma rapida al programa
 * 
 * @author Antonio Jesus
 *
 */
public class PantallaLogin extends JPanel {
	// Ventana donde se mostrará la pantalla
	private Ventana ventana;
	// TextField dodne se escribirá el nombre del usuario
	private JTextField campoUsuario;
	// JPasswordFile donde se escribirá la contraseña del usuario
	private JPasswordField campoContraseña;

	/**
	 * Constructor que crea la pantalla donde el usuario podrá iniciar sesion
	 * 
	 * @param v Ventana que mostrará la pantalla de Login
	 */
	public PantallaLogin(Ventana v) {
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setLayout(null);
		setSize(800, 500);

		JLabel labelContraseña = new JLabel("Contrase\u00F1a:");
		labelContraseña.setFont(new Font("Arial", Font.BOLD, 16));
		labelContraseña.setForeground(new Color(255, 46, 99));
		labelContraseña.setBounds(88, 249, 111, 28);
		add(labelContraseña);

		JLabel labelTitulo = new JLabel("Usuario:");
		labelTitulo.setForeground(new Color(255, 46, 99));
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		labelTitulo.setBounds(88, 169, 92, 28);
		add(labelTitulo);

		JLabel lbTitulo = new JLabel("HARD WORKOUT");
		lbTitulo.setForeground(new Color(8, 217, 214));
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lbTitulo.setBounds(53, 77, 520, 66);
		add(lbTitulo);

		JLabel yerayPinito = new JLabel("");
		yerayPinito.setIcon(new ImageIcon("./yerai.png"));
		yerayPinito.setBounds(483, -23, 365, 539);
		add(yerayPinito);

		JButton botonLogin = new Boton2("Iniciar Sesion");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			// Funcion que al hacer clic sobre el botonLogin se intentará iniciar sesión con
			// los datos insertados en sus respectivos campos;
			public void mouseClicked(MouseEvent e) {

				String nombre = campoUsuario.getText();
				String contraseña = new String(campoContraseña.getPassword());
				try {
					ventana.usuarioLogeado = new Usuario(nombre, contraseña);
					JOptionPane.showMessageDialog(ventana, "Bienvenido, " + ventana.usuarioLogeado.getNombre(),
							"Logeado Correctamente", JOptionPane.PLAIN_MESSAGE);
					ventana.cambiarAPantalla("menu");
				} catch (SQLException | ContraseñaIncorrectaException | UsuarioNoExisteException | UsuarioVacioException
						| ContraseñaVaciaException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		botonLogin.setBounds(88, 392, 130, 21);
		add(botonLogin);

		campoUsuario = new JTextField();
		campoUsuario.setBackground(new Color(234, 234, 234));
		campoUsuario.setBounds(88, 207, 398, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		campoContraseña = new JPasswordField();
		campoContraseña.setBackground(new Color(234, 234, 234));
		campoContraseña.setBounds(88, 287, 398, 20);
		add(campoContraseña);
		JButton botonRegistro = new Boton1("Registrarme");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			//Funcion que al hacer clic en el botonRegistro, nos manda a la pantalla para registrar un usuario
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("registro");
			}
		});
		botonRegistro.setBounds(275, 392, 130, 21);
		add(botonRegistro);

		JPanel borde = new JPanel();
		borde.setBorder(new LineBorder(new Color(255, 46, 99), 4, true));
		borde.setBackground(new Color(37, 42, 52));
		borde.setBounds(54, 145, 503, 290);
		add(borde);
		borde.setLayout(null);

	}
}
