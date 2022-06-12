package pantallas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import elementosvisuales.Boton1;
import elementosvisuales.Boton2;
import elementosvisuales.BotonConSonido;
import elementosvisuales.BotonMenu;
import utilsDB.UtilsDB;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Enums.TipoEntrenamiento;
import clases.Ejercicio;
import clases.EjercicioDinamico;
import clases.Rutina;
import clases.Usuario;

import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;

public class PantallaMenuCrearRutina extends JPanel {
	private ArrayList<Ejercicio> ejercicios;
	private HashMap<TipoEntrenamiento, Rutina> rutinas;
	private Ventana ventana;
	private Ejercicio ejercicio;
	private String nombre;
	private Byte series;
	private Byte repeticiones;
	private Byte segundos;

	public PantallaMenuCrearRutina(Ventana v) {
		setBorder(null);
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setSize(708, 494);
		setLayout(null);

		final ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 59, 189, 441);
		add(scrollPane);

		JPanel panelDerecha = new JPanel();
		panelDerecha.setBorder(new LineBorder(Color.WHITE, 2));
		panelDerecha.setBackground(new Color(37, 42, 52));
		scrollPane.setViewportView(panelDerecha);

		JButton botonSNivel = new BotonMenu("Seleccionar Nivel");
		botonSNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("nivel");
			}
		});

		JButton botonSEntrenamiento = new BotonMenu("Entrenamientos");
		botonSEntrenamiento.setSize(180, 29);
		botonSEntrenamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("entrenamiento");
			}
		});

		JButton botonOp4 = new BotonMenu("Crear Rutinas");
		botonOp4.setSize(180, 29);

		JButton botonRutinas = new BotonMenu("Mis rutinas");
		botonRutinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Rutina rut = new Rutina();
					rut.pruebaQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panelDerecha = new GroupLayout(panelDerecha);
		gl_panelDerecha.setHorizontalGroup(gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonOp4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonRutinas, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE));
		gl_panelDerecha.setVerticalGroup(gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDerecha.createSequentialGroup()
						.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonOp4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonRutinas, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));
		panelDerecha.setLayout(gl_panelDerecha);

		JList list = new JList();
		list.setBounds(0, 500, 800, 0);
		list.setBackground(Color.BLACK);
		add(list);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 59, 94, 441);
		add(scrollPane_2);

		JPanel panelIzquierda = new JPanel();
		scrollPane_2.setRowHeaderView(panelIzquierda);
		panelIzquierda.setBorder(new LineBorder(Color.WHITE, 2));
		panelIzquierda.setBackground(new Color(37, 42, 52));

		JButton botonEditar = new BotonMenu("Editar");
		botonEditar.setVerticalAlignment(SwingConstants.TOP);

		BotonMenu botonPerfil = new BotonMenu("Perfil");

		botonPerfil.setVerticalAlignment(SwingConstants.TOP);

		BotonMenu botonSalir = new BotonMenu("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("menu");
			}
		});
		botonSalir.setVerticalAlignment(SwingConstants.TOP);
		botonSalir.setText("Salir");

		GroupLayout gl_panelIzquierda = new GroupLayout(panelIzquierda);
		gl_panelIzquierda.setHorizontalGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIzquierda.createSequentialGroup()
						.addGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
								.addComponent(botonPerfil, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGap(20)));
		gl_panelIzquierda.setVerticalGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIzquierda.createSequentialGroup()
						.addComponent(botonPerfil, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
						.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(37)));
		panelIzquierda.setLayout(gl_panelIzquierda);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 59);
		panel.setBorder(new LineBorder(Color.WHITE, 2));
		panel.setBackground(new Color(8, 217, 214));
		add(panel);

		JLabel lblMenu = new JLabel("HARD WORKOUT");
		lblMenu.setBackground(Color.BLACK);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(new Color(37, 42, 52));
		lblMenu.setFont(new Font("Arial", Font.BOLD, 40));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(87)
						.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(183, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblMenu,
				GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(93, 59, 517, 405);
		panel_1.setBorder(new LineBorder(Color.WHITE, 2));
		panel_1.setBackground(new Color(37, 42, 52));
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Crear Rutinas");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 517, 37);
		panel_1.add(lblNewLabel_1);

		final JComboBox comboDescanso = new JComboBox();
		comboDescanso.setModel(new DefaultComboBoxModel(new String[] { "0", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
				"61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77",
				"78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94",
				"95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109",
				"110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124",
				"125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
				"140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154",
				"155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169",
				"170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184",
				"185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199",
				"200" }));
		comboDescanso.setBounds(432, 85, 42, 21);
		panel_1.add(comboDescanso);

		final byte descansoSg = Byte.parseByte((String) comboDescanso.getSelectedItem());
		setOpaque(false);
		setSize(500, 300);

		JLabel lbSegundosDescanso = new JLabel("Selecciona los segundos de descanso");
		lbSegundosDescanso.setBackground(Color.WHITE);
		lbSegundosDescanso.setForeground(Color.WHITE);
		lbSegundosDescanso.setFont(new Font("Arial", Font.PLAIN, 18));
		lbSegundosDescanso.setBounds(69, 85, 325, 17);
		panel_1.add(lbSegundosDescanso);

		JButton btGuardarRutina = new JButton("Guardar Rutina");
		btGuardarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int segundos = Integer.parseInt((String) comboDescanso.getSelectedItem());

				try {
					Rutina rutina = new Rutina(ejercicios, segundos, LocalDateTime.now(), ventana.usuarioLogeado);
					ventana.usuarioLogeado.rutinas(rutina);
					// rutinas.put(ventana.usuarioLogeado.getEntrenamiento(), rutina);
					// ventana.usuarioLogeado.getRutinas();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(ventana, "Rutina creada ", "Rutina creada con exito",
						JOptionPane.PLAIN_MESSAGE);
				ventana.cambiarAPantalla("menu");
				// rutina.imprimirEjercicios(ejercicios);

			}

		});
		btGuardarRutina.setBounds(324, 360, 150, 21);
		panel_1.add(btGuardarRutina);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 2, 2);
		panel_1.add(scrollPane_1);

		JPanel panelSeleccionarEjercicios = new JPanel();
		panelSeleccionarEjercicios.setLayout(null);
		panelSeleccionarEjercicios.setBorder(new LineBorder(new Color(255, 46, 99), 4));
		panelSeleccionarEjercicios.setBackground(new Color(37, 42, 52));
		panelSeleccionarEjercicios.setBounds(0, 134, 517, 216);
		panel_1.add(panelSeleccionarEjercicios);

		JLabel lblNewLabel_3 = new JLabel("Ejercicios");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(43, 22, 211, 13);
		panelSeleccionarEjercicios.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Repeticiones");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(264, 10, 147, 37);
		panelSeleccionarEjercicios.add(lblNewLabel_4);

		JLabel lblSeries = new JLabel("Series");
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setForeground(Color.WHITE);
		lblSeries.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeries.setBounds(421, 21, 107, 15);
		panelSeleccionarEjercicios.add(lblSeries);

		final JComboBox comboRepeticiones = new JComboBox();
		comboRepeticiones.setModel(new DefaultComboBoxModel(
				new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }));
		comboRepeticiones.setBounds(312, 65, 46, 21);
		panelSeleccionarEjercicios.add(comboRepeticiones);

		final JComboBox comboEjercicios = new JComboBox();
		comboEjercicios.setBounds(43, 65, 211, 21);

		if ((ventana.usuarioLogeado.getEntrenamiento()).equals(TipoEntrenamiento.RESISTENCIA)
				|| (ventana.usuarioLogeado.getEntrenamiento()).equals(TipoEntrenamiento.AUMENTOREPETICIONES)
				|| (ventana.usuarioLogeado.getEntrenamiento()).equals(TipoEntrenamiento.HIPERTROFIA)) {

			comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {}));
			EjercicioDinamico ejercicio = new EjercicioDinamico();
			try {
				ArrayList<String> nombreEjercicio = ejercicio.nombreEjercicioTironOEmpuje();
				for (byte i = 0; i < nombreEjercicio.size(); i++) {
					comboEjercicios.addItem(nombreEjercicio.get(i).toString());
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			add(comboEjercicios);
		}
		if ((ventana.usuarioLogeado.getEntrenamiento()).equals(TipoEntrenamiento.FRONTLEVER)) {

			comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {}));
			EjercicioDinamico ejercicio = new EjercicioDinamico();
			try {
				ArrayList<String> nombreEjercicio = ejercicio.nombreEjercicioFront();
				for (byte i = 0; i < nombreEjercicio.size(); i++) {
					comboEjercicios.addItem(nombreEjercicio.get(i).toString());
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			add(comboEjercicios);
		}
		if ((ventana.usuarioLogeado.getEntrenamiento()).equals(TipoEntrenamiento.MIXTO)) {

			comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {}));
			EjercicioDinamico ejercicio = new EjercicioDinamico();
			try {
				ArrayList<String> nombreEjercicio = ejercicio.nombreEjercicio();
				for (byte i = 0; i < nombreEjercicio.size(); i++) {
					comboEjercicios.addItem(nombreEjercicio.get(i).toString());
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			add(comboEjercicios);
		}
		if ((ventana.usuarioLogeado.getEntrenamiento()).equals(TipoEntrenamiento.PLANCHA)) {

			comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {}));
			EjercicioDinamico ejercicio = new EjercicioDinamico();
			try {
				ArrayList<String> nombreEjercicio = ejercicio.nombreEjercicioPlancha();
				for (byte i = 0; i < nombreEjercicio.size(); i++) {
					comboEjercicios.addItem(nombreEjercicio.get(i).toString());
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			add(comboEjercicios);
		}

		panelSeleccionarEjercicios.add(comboEjercicios);

		final JComboBox comboSeries = new JComboBox();
		comboSeries.setModel(new DefaultComboBoxModel(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));

		comboSeries.setBounds(445, 65, 41, 21);
		panelSeleccionarEjercicios.add(comboSeries);

		final Rutina rutina = new Rutina();

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Ejercicio ejD = new Ejercicio((String) comboEjercicios.getSelectedItem(),
							(Byte) comboSeries.getSelectedItem());
					String estaticoOdinamico = ejD.estaticoODinamico();

					if (estaticoOdinamico.equals("dinamico")) {
						EjercicioDinamico ejDi = new EjercicioDinamico((String) comboEjercicios.getSelectedItem(),
								(Byte) comboSeries.getSelectedItem(), (Byte) comboRepeticiones.getSelectedItem());
					}
					if (estaticoOdinamico.equals("estatico")) {

					}
					Ejercicio ej = new Ejercicio(ejD.getNombre(), ventana.usuarioLogeado);
					ejercicios.add(ejD);
					rutina.añadirEjercicio(ejD);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnGuardar.setBounds(401, 159, 85, 21);
		panelSeleccionarEjercicios.add(btnGuardar);

	}
}
