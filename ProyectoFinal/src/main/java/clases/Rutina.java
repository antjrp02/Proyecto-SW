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
	private byte series;
	private byte repeticiones;

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

		
	}


	public Rutina() {
		// Genera rutina vacía OJO: INICIALIZAR ARRAYLIST
	}

	public void añadirEjercicio(Ejercicio e) {
		ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(e);

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
	
	
	
	public String pruebaQuery(Usuario usu) throws SQLException {
		String ret="";
		Statement smt = UtilsDB.conectarBD();
		ResultSet rutinasUsuario = smt.executeQuery("Select fecha from rutina where usuario ='"+usu.getNombre()+"';");
		ArrayList<LocalDateTime> fechaEjercicio = new ArrayList<LocalDateTime>();
		while (rutinasUsuario.next()) {
			
			this.fecha= rutinasUsuario.getTimestamp("fecha").toLocalDateTime();
			
			fechaEjercicio.add(fecha);
			
		}
		for(byte i=0;i<fechaEjercicio.size();i++) {
			ResultSet ejerciciosRutina = smt.executeQuery("select er.nombreEjercicio,e.series, ed.repeticiones \r\n"
					+ "from ejercicios_rutina er,ejercicios e,ejercicio_Dinamico ed,rutina r  \r\n"
					+ "where  r.fecha='"+fechaEjercicio.get(i)+"' and er.nombreEjercicio = e.nombre and ed.nombre=er.nombreEjercicio;\r\n"
					+ "");
			
			while (ejerciciosRutina.next()) {	
				this.nombreEjercicio = ejerciciosRutina.getString("nombreEjercicio");
				this.repeticiones = ejerciciosRutina.getByte("repeticiones");
				this.series = ejerciciosRutina.getByte("series");
				if(ret.contains(fechaEjercicio.get(i)+"")) {
				
				}
				else {
				ret+="Fecha de la rutina: "+fecha+"\n\n";
				}
				if(ret.contains(nombreEjercicio)) {
					
				}else {
				ret+=" Ejercicios: "+this.nombreEjercicio+" series: "+this.series+" repeticiones: "+this.repeticiones+"\n";
				}
				
			}
		
		}
		
		return ret;
	}
	
}
