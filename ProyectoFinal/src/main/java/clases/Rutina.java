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
import excepciones.ContraseñaIncorrectaException;
import excepciones.ContraseñaVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import utilsDB.UtilsDB;

public class Rutina {
	private ArrayList<Ejercicio> ejercicios;
	private int descansoSg;
	private LocalDateTime fecha;
	private Usuario usuario;
	private String nombreEjercicio;

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
		// Genera rutina vacía OJO: INICIALIZAR ARRAYLIST
	}

	public void añadirEjercicio(Ejercicio e) {
		ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(e);
		System.out.println("Ejercicio añadido al arrayList");

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
		ResultSet rutinasUsuario = smt.executeQuery("Select fecha from rutina where usuario ='"+usu.getNombre()+"' ;");
		LocalDateTime fecha = null;
		while (rutinasUsuario.next()) {
			
			this.fecha = rutinasUsuario.getTimestamp("fecha").toLocalDateTime();
			System.out.println(fecha);
			ret+="------------------------------------";
			String select_query="Select usuario from rutina ;";
			ResultSet ejerciciosRutina = smt.executeQuery(select_query);
			
			while (ejerciciosRutina.next()) {	
				/**this.nombre = ejerciciosRutina.getString("nombre");
				this.repeticiones = ejerciciosRutina.getByte("repeticiones");
				this. series = ejerciciosRutina.getByte("series");
				this.eod = ejerciciosRutina.getString("estatico_o_dinamico");
				*/
				this.nombreEjercicio=ejerciciosRutina.getString("usuario");
				ret+=nombreEjercicio;
				//ret+= series+" series de "+repeticiones+" repeticiones de "+nombre+"\n";
			
		}
		}
		
		UtilsDB.desconectarBD();
		return fecha+"";

	
	}
	public void pruebaQuery() throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		ResultSet rutinasUsuario = smt.executeQuery("Select nombre from usuario;");
		
		while (rutinasUsuario.next()) {
			
			String nombre = rutinasUsuario.getString("nombre");
			System.out.println(nombre);
			
			
			ResultSet ejerciciosRutina = smt.executeQuery("Select usuario from rutina where usuario='"+nombre+"' ;");
			
			while (ejerciciosRutina.next()) {	
				/**this.nombre = ejerciciosRutina.getString("nombre");
				this.repeticiones = ejerciciosRutina.getByte("repeticiones");
				this. series = ejerciciosRutina.getByte("series");
				this.eod = ejerciciosRutina.getString("estatico_o_dinamico");
				*/
				this.nombreEjercicio=ejerciciosRutina.getString("usuario");
				
			}
		}
	}
}
