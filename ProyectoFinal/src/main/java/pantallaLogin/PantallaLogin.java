package pantallaLogin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	public PantallaLogin(Ventana v) {
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(37, 42, 52));
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(234, 234, 234));
		textField_1.setBounds(219, 111, 133, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(234, 234, 234));
		passwordField.setBounds(219, 166, 133, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 46, 99));
		lblNewLabel.setBounds(64, 160, 111, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setForeground(new Color(255, 46, 99));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(64, 105, 92, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HARD WORKOUT");
		lblNewLabel_2.setForeground(new Color(8, 217, 214));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(10, 36, 430, 38);
		panel.add(lblNewLabel_2);
		
	}
}
