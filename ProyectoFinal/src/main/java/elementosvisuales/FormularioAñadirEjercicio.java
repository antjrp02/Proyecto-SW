package elementosvisuales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;

import Enums.TipoEntrenamiento;
import clases.Ejercicio;
import clases.EjercicioDinamico;
import pantallas.Ventana;
import utilsDB.UtilsDB;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FormularioAñadirEjercicio extends JPanel{
	private Ventana ventana;
	private Ejercicio ejercicio;
	public FormularioAñadirEjercicio(Ventana v,Ejercicio e) {
		this.ventana=v;
		this.ejercicio=e;
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ejercicios");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 23, 211, 13);
		add(lblNewLabel_3);
		
		final JComboBox comboEjercicios = new JComboBox();
		comboEjercicios.setBounds(10, 46, 211, 21);
		add(comboEjercicios);
		
		final JComboBox comboRepeticiones = new JComboBox();
		comboRepeticiones.setBounds(287, 46, 46, 21);
		add(comboRepeticiones);
		
		if((ventana.usuarioLogeado.getEntrenamiento()+"").equals(TipoEntrenamiento.RESISTENCIA+"")) {
			
			comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {"dominada prona con goma", "2", "3", "4"}));
			
			add(comboEjercicios);
			}
		JLabel lblNewLabel_4 = new JLabel("Repeticiones");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(231, 11, 147, 37);
		add(lblNewLabel_4);
		
		JLabel lblSeries = new JLabel("Series");
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setForeground(Color.WHITE);
		lblSeries.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeries.setBounds(394, 23, 107, 15);
		add(lblSeries);
		
		final JComboBox comboSeries = new JComboBox();
		comboSeries.setBounds(425, 46, 41, 21);
		add(comboSeries);
		
		JButton btGuardar = new JButton("Guardar");
		
		btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement smt = UtilsDB.conectarBD();
				
				try {
					smt.executeUpdate(
							"Update Ejercicio_Dinamico set repeticiones = " + comboRepeticiones.getSelectedItem() + ",series ="+comboSeries.getSelectedItem()+" where nombre = '" + comboEjercicios.getSelectedItem() + "';");
					
					EjercicioDinamico ejD = new EjercicioDinamico((String) comboEjercicios.getSelectedItem(), Byte.parseByte((String)comboSeries.getSelectedItem()),Byte.parseByte((String)comboRepeticiones.getSelectedItem()));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				UtilsDB.desconectarBD();
				JOptionPane.showMessageDialog(ventana,comboSeries.getSelectedItem()+" series de "+comboRepeticiones.getSelectedItem()+" repeticiones"+" de " +comboEjercicios.getSelectedItem(), "Ejercicio Seleccionado: ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btGuardar.setBounds(388, 354, 94, 21);
		add(btGuardar);
		
		
	}
}
