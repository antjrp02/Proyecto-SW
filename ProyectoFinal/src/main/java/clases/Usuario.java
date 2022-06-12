package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Enums.TipoEntrenamiento;
import excepciones.ContraseñaIncorrectaException;
import excepciones.NivelVacioException;
import excepciones.UbicacionVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import excepciones.ContraseñaVaciaException;
import superClases.EntidadConNombre;
import utilsDB.UtilsDB;

public class Usuario extends EntidadConNombre {
	private String contraseña;
	private byte nivel;// Del 1 al 10, 1 mas novato, 10 mas avanzado.
	// 1 principiante,2 y 3 principiante-intermedio, 4,5 intermedio 6-7
	// intermedio-avanzado 8 y 9 avanzado y nivel 10 Kamenov
	private String UbicacionEntrenamiento;
	private TipoEntrenamiento entrenamiento;
	private ArrayList<Rutina> rutinas;

	public Usuario(String nombre, String contraseña, String ubicacionEntrenamiento)
			throws SQLException, ContraseñaVaciaException, UsuarioVacioException, UbicacionVaciaException {
		super(nombre);
		if (contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}
		if (!this.UsuarioValido(nombre)) {
			throw new UsuarioVacioException("El usuario no puede estar vacio");
		}
		if (ubicacionEntrenamiento.equals("...")) {
			throw new UbicacionVaciaException("Porfavor, selecciona una Ubicacion");
		}

		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate("insert into usuario values('" + nombre + "','" + contraseña + "'," + nivel + ",'"
				+ UbicacionEntrenamiento + "','" + entrenamiento + "')") > 0) {

			this.contraseña = contraseña;
			this.UbicacionEntrenamiento = ubicacionEntrenamiento;
			this.nivel = 0;
			this.rutinas = new ArrayList<Rutina>();
			this.entrenamiento = entrenamiento;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();
	}

	public Usuario(String nombre, String contraseña) throws SQLException, ContraseñaIncorrectaException,
			UsuarioNoExisteException, UsuarioVacioException, ContraseñaVaciaException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();

		ResultSet cursor = smt.executeQuery("select * from usuario where nombre='" +

				nombre + "'");
		if (nombre.isBlank()) {
			throw new UsuarioVacioException("El usuario no puede estar vacio");
		}
		if (contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}
		if (cursor.next()) {

			this.contraseña = cursor.getString("contraseña");

			if (!this.contraseña.equals(contraseña)) {

				UtilsDB.desconectarBD();

				throw new ContraseñaIncorrectaException("La contraseña no es correcta");

			}

			if (!this.getNombre().equals(nombre)) {
				throw new UsuarioNoExisteException("No existe ese nombre de usuario en la BD");
			}
			nombre = cursor.getString("Nombre");
			this.nivel = cursor.getByte("Nivel");
			this.UbicacionEntrenamiento = cursor.getString("UbicacionEntrenamiento");

		} else {

			UtilsDB.desconectarBD();

			throw new UsuarioNoExisteException("El nombre de usuario no existe");

		}

		UtilsDB.desconectarBD();

	}

	public Usuario(String nombre) {
		super(nombre);
	}

	public Usuario(String nombre, byte nivel) throws SQLException, NivelVacioException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();
		if (nivel == 0) {
			throw new NivelVacioException("Nivel no valido");
		}
		smt.executeUpdate("Update usuario set nivel = " + nivel + " where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		this.nivel = nivel;
	}

	public Usuario(String nombre, TipoEntrenamiento entrenamiento) throws SQLException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"Update usuario set entrenamiento = '" + entrenamiento + "' where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		this.entrenamiento = entrenamiento;
	}

	public String entrenamiento(String nombre, TipoEntrenamiento entrenamiento) throws SQLException {

		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate("Select entrenamiento From usuario where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		return entrenamiento + "";

	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public byte getNivel() {
		return nivel;
	}

	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}

	public String getUbicacionEntrenamiento() {
		return UbicacionEntrenamiento;
	}

	public void setUbicacionEntrenamiento(String ubicacionEntrenamiento) {
		UbicacionEntrenamiento = ubicacionEntrenamiento;
	}

	public TipoEntrenamiento getEntrenamiento() {
		return entrenamiento;
	}

	public void setEntrenamiento(TipoEntrenamiento entrenamiento) {
		this.entrenamiento = entrenamiento;
	}

	public ArrayList<Rutina> getRutinas() {
		return rutinas;
	}

	public void setRutinas(ArrayList<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public ArrayList<Rutina> rutinas(Rutina r) {

		ArrayList<Rutina> rutinas = new ArrayList<Rutina>();
		rutinas.add(r);
		System.out.println(rutinas);
		return rutinas;

	}

	public String mostrarRutinas(Usuario usu) throws SQLException {
		String ret = "";
	
		Statement smt = UtilsDB.conectarBD();
		ResultSet rutinasUsuario = smt.executeQuery("Select fecha from rutina where usuario ='"+usu.getNombre()+"' ;");
		LocalDateTime fecha = null;
		while (rutinasUsuario.next()) {
			
			fecha = rutinasUsuario.getTimestamp("fecha").toLocalDateTime();
			System.out.println(fecha);
			
			ResultSet ejerciciosRutina = smt.executeQuery("Select e.nombre,ed.repeticiones,e.series,e.estatico_o_dinamico from ejercicios e,rutina r,ejercicios_rutina er,ejercicio_dinamico ed where r.fecha ="+fecha+" and ed.nombre=er.nombreEjercicio and ed.nombre=er.nombreEjercicio;");
			
			while (ejerciciosRutina.next()) {	
				String resultado = ejerciciosRutina.getString("weq");
			
		}
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
		/**
		for (TipoEntrenamiento clave : rutinas.keySet()) {
			System.out.println("Medio");
			Rutina valor = rutinas.get(clave);
			for (byte i = 0; i < valor.getEjercicios().size(); i++) {
				System.out.println("Dentro");
				Ejercicio ej = valor.getEjercicios().get(i);

				ResultSet cursor = smt.executeQuery("select tipo from " + ej.getNombre());
				while (cursor.next()) {
					if (cursor.equals("dinamico")) {
						ret = "dinamico";
					}
				}
			}
		}
		
		
		
		 * 
		 * } try { ResultSet cursor = smt.executeQuery("select tipo from ejercicio");
		 * while (cursor.next()) { if (cursor.equals("dinamico")) {
		 * rutinas.getRutinas();
		 * 
		 * } else {
		 * 
		 * } Rutina rut = new Rutina();
		 * 
		 * actual.nombre = cursor.getString("nombre"); actual.contraseña =
		 * cursor.getString("contrasena"); actual.email = cursor.getString("email");
		 * actual.añoNacimiento = cursor.getShort("anioNacimiento");
		 * actual.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
		 * actual.momentoRegistro =
		 * cursor.getTimestamp("momentoRegistro").toLocalDateTime();
		 * actual.horaAcostarse = cursor.getTime("horaAcostarse").toLocalTime();
		 * 
		 * ret.add(actual); } } catch (SQLException e) { // Si la conuslta falla no hay
		 * nada que devolver. e.printStackTrace(); return null; } // Si no hay usuarios
		 * en la tabla, va a devolver un arraylist vacio. // Si la consulta fue erronea
		 * se devuelve un arraylist null, que son cosas // distintas.
		 * UtilsDB.desconectarBD(); return ret;
		 
		return ret;
		
	}
	
*/
	
}
