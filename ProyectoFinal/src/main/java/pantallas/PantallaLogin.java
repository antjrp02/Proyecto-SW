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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField textField;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;

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

		JLabel lblNewLabel_2 = new JLabel("HARD WORKOUT");
		lblNewLabel_2.setForeground(new Color(8, 217, 214));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel_2.setBounds(53, 77, 520, 66);
		add(lblNewLabel_2);

		JLabel yerayPinito = new JLabel("New label");
		yerayPinito.setIcon(new ImageIcon("./yerai.png"));
		yerayPinito.setBounds(483, -23, 365, 539);
		add(yerayPinito);

		JButton botonLogin = new Boton2("Iniciar Sesion");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nombre = campoUsuario.getText();
				String contraseña = new String(campoContraseña.getPassword());

				try {
					Usuario u = new Usuario(nombre, contraseña);

					JOptionPane.showMessageDialog(ventana, "Bienvenido " + nombre, "Inicio de sesion correcto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException | ContraseñaIncorrectaException | UsuarioNoExisteException | UsuarioVacioException
						| ContraseñaVaciaException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				ventana.cambiarAPantalla("menu");
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
