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
import excepciones.Contrase�aIncorrectaException;
import excepciones.NivelVacioException;
import excepciones.UbicacionVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import excepciones.Contrase�aVaciaException;
import superClases.EntidadConNombre;
import utilsDB.UtilsDB;

public class Usuario extends EntidadConNombre {
	private String contrase�a;
	private byte nivel;// Del 1 al 10, 1 mas novato, 10 mas avanzado.
	// 1 principiante,2 y 3 principiante-intermedio, 4,5 intermedio 6-7
	// intermedio-avanzado 8 y 9 avanzado y nivel 10 Kamenov
	private String UbicacionEntrenamiento;
	private TipoEntrenamiento entrenamiento;
	private ArrayList<Rutina> rutinas;
	private String eod;
	private byte series;
	private byte repeticiones;

	public Usuario(String nombre, String contrase�a, String ubicacionEntrenamiento)
			throws SQLException, Contrase�aVaciaException, UsuarioVacioException, UbicacionVaciaException {
		super(nombre);
		if (contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}
		if (!this.UsuarioValido(nombre)) {
			throw new UsuarioVacioException("El usuario no puede estar vacio");
		}
		if (ubicacionEntrenamiento.equals("...")) {
			throw new UbicacionVaciaException("Porfavor, selecciona una Ubicacion");
		}

		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate("insert into usuario values('" + nombre + "','" + contrase�a + "'," + nivel + ",'"
				+ UbicacionEntrenamiento + "','" + entrenamiento + "')") > 0) {

			this.contrase�a = contrase�a;
			this.UbicacionEntrenamiento = ubicacionEntrenamiento;
			this.nivel = 0;
			this.rutinas = new ArrayList<Rutina>();
			this.entrenamiento = entrenamiento;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();
	}

	public Usuario(String nombre, String contrase�a) throws SQLException, Contrase�aIncorrectaException,
			UsuarioNoExisteException, UsuarioVacioException, Contrase�aVaciaException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();

		ResultSet cursor = smt.executeQuery("select * from usuario where nombre='" +

				nombre + "'");
		if (nombre.isBlank()) {
			throw new UsuarioVacioException("El usuario no puede estar vacio");
		}
		if (contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}
		if (cursor.next()) {

			this.contrase�a = cursor.getString("contrase�a");

			if (!this.contrase�a.equals(contrase�a)) {

				UtilsDB.desconectarBD();

				throw new Contrase�aIncorrectaException("La contrase�a no es correcta");

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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
		
		return rutinas;

	}
	
	
	
}
