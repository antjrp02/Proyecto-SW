package pantallas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import elementosvisuales.Boton1;
import elementosvisuales.Boton2;
import elementosvisuales.BotonMenu;
import elementosvisuales.ElementoListaEjercicios;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
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

import clases.Ejercicio;

import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

/**
 * Clase PantallaInformacionEjercicios que mostrará una pantalla los campos mas
 * informativos de los ejercicios insertados en la base de datos
 * 
 * @author Antonio Jesus
 *
 */
public class PantallaInformacionEjercicios extends JPanel {
	//Ventana que mostrará la pantalla
	private Ventana ventana;
	
	/**
	 * Constructor que creará la ventana para ver todos los ejercicios de la base de datos.
	 * @param v Ventana para mostrar la pantalla.
	 */
	public PantallaInformacionEjercicios(Ventana v) {
		setBorder(null);
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setSize(800, 500);
		setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 59, 189, 441);
		add(scrollPane);

		JPanel panelDerecha = new JPanel();
		panelDerecha.setBorder(new LineBorder(Color.WHITE, 2));
		panelDerecha.setBackground(new Color(37, 42, 52));
		scrollPane.setViewportView(panelDerecha);

		JButton botonSNivel = new BotonMenu("Seleccionar Nivel");
		botonSNivel.addActionListener(new ActionListener() {
			// Funcion que al hacer clic en el botonSNivel nos llevará a la ventana para
			// seleccionarNivel
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("nivel");
			}
		});

		JButton botonSEntrenamiento = new BotonMenu("Entrenamientos");
		botonSEntrenamiento.setSize(180, 29);
		botonSEntrenamiento.addActionListener(new ActionListener() {
			// Funcion que al hacer clic en el botonSEntrenamiento nos llevará a la ventana
			// para seleccionar Entrenamiento
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("entrenamiento");
			}
		});

		JButton botonCrearRutinas = new BotonMenu("Crear Rutinas");
		botonCrearRutinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boton que si el entrenamiento y el nivel están seleccionados, nos llevará a
				// la pantalla para crear las rutinas,
				// si no, saldra una ventana de error referenciando a que no se han seleccionado
				// los campos nivel y o entrenamiento
				if (ventana.usuarioLogeado.getEntrenamiento() == null || ventana.usuarioLogeado.getNivel() == 0) {
					JOptionPane.showMessageDialog(ventana, "Nivel o entrenamiento no seleccionados", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					ventana.cambiarAPantalla("crearRutina");
				}
			}
		});
		botonCrearRutinas.setSize(180, 29);

		JButton botonMostrarRutinas = new BotonMenu("Mis rutinas");
		botonMostrarRutinas.addActionListener(new ActionListener() {
			// Funcion que al hacer clic en el boton botonMostrarRutina nos llevará a la
			// pantalla para mostrar las rutinas
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("mostrarRutinas");
			}
		});

		BotonMenu botonCerrar = new BotonMenu("Salir");
		botonCerrar.addActionListener(new ActionListener() {
			// Boton que al hacer clic sbre el botonCerrar nos llevará a la pantilla crear
			// rutinas.
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("crearRutina");
			}
		});
		botonCerrar.setVerticalAlignment(SwingConstants.TOP);
		botonCerrar.setText("Cerrar");
		GroupLayout gl_panelDerecha = new GroupLayout(panelDerecha);
		gl_panelDerecha.setHorizontalGroup(gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDerecha.createSequentialGroup().addGroup(gl_panelDerecha
						.createParallelGroup(Alignment.LEADING)
						.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonCrearRutinas, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonMostrarRutinas, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonCerrar, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)).addContainerGap()));
		gl_panelDerecha.setVerticalGroup(gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDerecha.createSequentialGroup()
						.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonCrearRutinas, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonMostrarRutinas, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
						.addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(41)));
		panelDerecha.setLayout(gl_panelDerecha);

		JList lista = new JList();
		lista.setBounds(0, 500, 800, 0);
		lista.setBackground(Color.BLACK);
		add(lista);

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

		JScrollPane scrollPaneEjercicios = new JScrollPane();
		scrollPaneEjercicios.setBounds(0, 59, 611, 441);
		add(scrollPaneEjercicios);

		JLabel lblInformacion = new JLabel("Informacion Ejercicios");
		lblInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		scrollPaneEjercicios.setColumnHeaderView(lblInformacion);

		JPanel listaEjercicios = new JPanel();
		scrollPaneEjercicios.setViewportView(listaEjercicios);
		listaEjercicios.setLayout(new BoxLayout(listaEjercicios, BoxLayout.Y_AXIS));
		Ejercicio ej = new Ejercicio();

		try {
			//Recorre un arrayList de ejercicio para irlos añadiendo uno a uno por su ToString() 
			ArrayList<Ejercicio> ejercicios = ej.todos();
			for (byte i = 0; i < ejercicios.size(); i++) {
				listaEjercicios.add(new ElementoListaEjercicios(ventana, ejercicios.get(i).toString()));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
