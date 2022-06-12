package clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import Enums.TipoEntrenamiento;
import excepciones.Contrase�aIncorrectaException;
import excepciones.Contrase�aVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import utilsDB.UtilsDB;

public class Rutina {
	private ArrayList<Ejercicio> ejercicios;
	private int descansoSg;
	private LocalDateTime fecha;
	private Usuario usuario;

	public Rutina(ArrayList<Ejercicio> ejercicios, int descansoSg, LocalDateTime fecha, Usuario usuario)
			throws SQLException {
		super();

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate(
				"insert into Rutina values('" + usuario.getNombre() + "'," + descansoSg + ",'" + fecha + "')") > 0) {

			this.ejercicios = ejercicios;
			this.descansoSg = descansoSg;
			this.fecha = fecha;
			this.usuario = usuario;
			System.out.println("Rutina creada");
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

		/**
		 * 
		 * Statement smt = UtilsDB.conectarBD(); ResultSet cursor;
		 * 
		 * try { cursor = smt.executeQuery("select * from rutina where usuario='" +
		 * 
		 * usuario.getNombre() + "'"); if (cursor.next()) {
		 * 
		 * 
		 * 
		 * UtilsDB.desconectarBD();
		 * 
		 * 
		 * 
		 * this.usuario= new Usuario(cursor.getString("Usuario")); this.descansoSg =
		 * cursor.getInt("descansoSg"); this.fecha =
		 * cursor.getTimestamp("fecha").toLocalDateTime();
		 * 
		 * } else {
		 * 
		 * UtilsDB.desconectarBD();
		 * 
		 * throw new UsuarioNoExisteException("El nombre de usuario no existe");
		 * 
		 * }
		 * 
		 * UtilsDB.desconectarBD(); } catch (SQLException | UsuarioNoExisteException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}

	public void imprimirEjercicios(ArrayList<Ejercicio> ejercicios) {
		for (int i = 0; i < ejercicios.size(); i++) {
			System.out.println(ejercicios.get(i));
		}

	}

	public Rutina() {
		// Genera rutina vac�a OJO: INICIALIZAR ARRAYLIST
	}

	public void a�adirEjercicio(Ejercicio e) {
		ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(e);
		System.out.println("Ejercicio a�adido al arrayList");

	}

	public boolean borrarEjercicio(Ejercicio e) {
		return this.ejercicios.remove(e);
	}

	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public int getDescansoSg() {
		return descansoSg;
	}

	public void setDescansoSg(byte descansoSg) {
		this.descansoSg = descansoSg;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Ejercicio> ejerciciosRutina(ArrayList<Ejercicio> ejercicios) {

		return ejercicios;

	}

	public Rutina(ArrayList<Ejercicio> ejercicios) {
		super();
		this.ejercicios = ejercicios;
	}
	
	public String mostrarRutinas(Usuario usu) throws SQLException {
		String ret = "";
	
		Statement smt = UtilsDB.conectarBD();
		ResultSet rutinasUsuario = smt.executeQuery("Select rutina from usuario where usuario ='"+usu.getNombre()+"' ;");
		while (rutinasUsuario.next()) {
			
			fecha = rutinasUsuario.getTimestamp("fecha").toLocalDateTime();
			System.out.println();
		}
		
		UtilsDB.desconectarBD();
		return fecha+"";

	}
	/**
		System.out.println("fuera");
		System.out.println(rutinas);
			for(byte i=0;i<rutinas.size();i++) {
				Rutina rutina = rutinas.get(i);
				System.out.println("Medio");
			for (byte j = 0; j < rutina.getEjercicios().size(); j++) {
				System.out.println("Dentro");
				Ejercicio ej = rutina.getEjercicios().get(j);

				ResultSet cursor = smt.executeQuery("select tipo from " + ej.getNombre());
				while (cursor.next()) {
					if (cursor.equals("dinamico")) {
						ret = "dinamico";
					}
				}
			}
			
		}
	*/
}
