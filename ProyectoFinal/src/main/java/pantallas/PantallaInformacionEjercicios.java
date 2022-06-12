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

public class PantallaInformacionEjercicios extends JPanel{
	private Ventana ventana;
	
	
	public PantallaInformacionEjercicios(Ventana v) {
		setBorder(null);
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setSize(800, 500);
		setLayout(null);
		
		System.out.println(ventana.usuarioLogeado.getEntrenamiento());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 59, 189, 441);
		add(scrollPane);
		
		JPanel panelDerecha = new JPanel();
		panelDerecha.setBorder(new LineBorder(Color.WHITE, 2));
		panelDerecha.setBackground(new Color(37, 42, 52));
		scrollPane.setRowHeaderView(panelDerecha);
		
		JButton botonSNivel = new BotonMenu("Seleccionar Nivel");
		botonSNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("nivel");
			}
		});
		
		JButton botonSEntrenamiento = new BotonMenu("Entrenamientos");
		botonSEntrenamiento.setSize(180,29);
		botonSEntrenamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("entrenamiento");
			}
		});
		
		JButton botonOp4 = new BotonMenu("Crear Rutinas");
		botonOp4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ventana.usuarioLogeado.getEntrenamiento()==null||ventana.usuarioLogeado.getNivel()==0) {
					JOptionPane.showMessageDialog(ventana,"Nivel o entrenamiento no seleccionados","Error",JOptionPane.ERROR_MESSAGE);
				}else {
				ventana.cambiarAPantalla("crearRutina");
				}
				}
		});
		botonOp4.setSize(180,29);
		
		JButton botonOp3 = new BotonMenu("Mis rutinas");
		botonOp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("mostrarRutinas");
			}
		});
		
		BotonMenu botonCerrar = new BotonMenu("Salir");
		botonCerrar.setVerticalAlignment(SwingConstants.TOP);
		botonCerrar.setText("Cerrar");
		GroupLayout gl_panelDerecha = new GroupLayout(panelDerecha);
		gl_panelDerecha.setHorizontalGroup(
			gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDerecha.createSequentialGroup()
					.addGroup(gl_panelDerecha.createParallelGroup(Alignment.LEADING)
						.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonOp4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonOp3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonCerrar, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelDerecha.setVerticalGroup(
			gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDerecha.createSequentialGroup()
					.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(botonOp4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(botonOp3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
					.addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		panelDerecha.setLayout(gl_panelDerecha);
		
		JList list = new JList();
		list.setBounds(0, 500, 800, 0);
		list.setBackground(Color.BLACK);
		add(list);
		
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
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(87)
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMenu, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPaneEjercicios = new JScrollPane();
		scrollPaneEjercicios.setBounds(0, 59, 611, 441);
		add(scrollPaneEjercicios);
		
		JLabel lblNewLabel = new JLabel("Informacion Ejercicios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		scrollPaneEjercicios.setColumnHeaderView(lblNewLabel);
		
		JPanel listaEjercicios = new JPanel();
		scrollPaneEjercicios.setViewportView(listaEjercicios);
		listaEjercicios.setLayout(new BoxLayout(listaEjercicios, BoxLayout.Y_AXIS));
		Ejercicio ej = new Ejercicio();
		
		try {
			ArrayList<Ejercicio>ejercicios=ej.todos();
			for(byte i=0;i<ejercicios.size();i++) {
				listaEjercicios.add(new ElementoListaEjercicios(ventana,ejercicios.get(i).toString()));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	
		
	}
}
