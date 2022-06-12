package elementosvisuales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;

import Enums.TipoEntrenamiento;
import clases.Ejercicio;
import clases.EjercicioDinamico;
import clases.Rutina;
import pantallas.Ventana;
import utilsDB.UtilsDB;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class FormularioAñadirEjercicio extends JPanel{
	public static ArrayList<Ejercicio> ejercicios;
	private Ventana ventana;
	private Ejercicio ejercicio;
	private String nombre;
	private Byte series;
	private Byte repeticiones;
	private Byte segundos;
	public FormularioAñadirEjercicio(Ventana v) {
		setBorder(new LineBorder(new Color(255, 46, 99), 4));
		setBackground(new Color(37, 42, 52));
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ejercicios");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(43, 22, 211, 13);
		add(lblNewLabel_3);
		
		
		
		final JComboBox comboEjercicios = new JComboBox();
		comboEjercicios.setBounds(43, 45, 211, 21);
		add(comboEjercicios);
		
		final JComboBox comboRepeticiones = new JComboBox();
		comboRepeticiones.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboRepeticiones.setBounds(310, 45, 46, 21);
		add(comboRepeticiones);
		
		repeticiones= Byte.parseByte((String) comboRepeticiones.getSelectedItem());
		
		if((ventana.usuarioLogeado.getEntrenamiento()).equals(TipoEntrenamiento.RESISTENCIA)) {
			
			
			comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {}));
			EjercicioDinamico ejercicio = new EjercicioDinamico();
			try {
				ArrayList<String>nombreEjercicio=ejercicio.nombreEjercicio();
				for(byte i=0;i<nombreEjercicio.size();i++) {
					comboEjercicios.addItem(nombreEjercicio.get(i).toString());
				}
				nombre=(String) comboEjercicios.getSelectedItem();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			add(comboEjercicios);
			}
		JLabel lblNewLabel_4 = new JLabel("Repeticiones");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(264, 10, 147, 37);
		add(lblNewLabel_4);
		
		JLabel lblSeries = new JLabel("Series");
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setForeground(Color.WHITE);
		lblSeries.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeries.setBounds(421, 21, 107, 15);
		add(lblSeries);
		
		
		final JComboBox comboSeries = new JComboBox();
		comboSeries.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboSeries.setBounds(445, 45, 41, 21);
		add(comboSeries);
		final Rutina rutina=new Rutina();
		final ArrayList<Ejercicio>ejercicios = new ArrayList<Ejercicio>();
		series = Byte.parseByte((String) comboSeries.getSelectedItem());
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//EjercicioDinamico ejD = new EjercicioDinamico(nombre,series,repeticiones);
				
				//ejercicios.add(ejD);
				//rutina.añadirEjercicio(ejD);
				
				//Rutina r =new Rutina(rutina(ejercicios));
				
				
				
			}
		});
		btnGuardar.setBounds(401, 142, 85, 21);
		add(btnGuardar);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(ejercicios.size());
			}
		});
		btnNewButton.setBounds(69, 143, 85, 21);
		add(btnNewButton);
		
		
		
		
	}
}
