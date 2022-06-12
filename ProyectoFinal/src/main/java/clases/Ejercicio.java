package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import Enums.Dificultad;
import Enums.GruposMusculares;
import Enums.TipoEjercicio;
import Enums.TipoEntrenamiento;
import excepciones.NivelVacioException;
import superClases.EntidadConDificultad;
import utilsDB.UtilsDB;
/**
 * 
 * @author Antonio Jesus Rodriguez
 *
 */
public class Ejercicio extends EntidadConDificultad {
	private GruposMusculares gruposMusculares;
	private TipoEjercicio tipoEjercicio;
	private boolean usaGoma;
	private boolean realizado;
	protected byte series;
	private String estatico_o_dinamico;
	private Usuario usuario;
	private String descripcion;

	public Ejercicio(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series) {
		super(nombre, dificultad);
		this.gruposMusculares = gruposMusculares;
		this.tipoEjercicio = tipoEjercicio;
		this.usaGoma = usaGoma;
		this.realizado = realizado;
		this.series = series;
	}

	public Ejercicio(String nombre, byte series) throws SQLException {
		super(nombre);

		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate("Update ejercicios set series = " + series + " where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		this.series = series;

	}

	public Ejercicio(String nombre, Usuario usuario) throws SQLException {
		super(nombre);
		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate(
				"insert into ejercicios_rutina values('" + usuario.getNombre() + "','" + nombre + "')") > 0) {

			this.usuario = usuario;
			System.out.println("Ejercicio insertado");
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();

	}

	public Ejercicio() {
		super();
	}

	public GruposMusculares getGruposMusculares() {
		return gruposMusculares;
	}

	public void setGruposMusculares(GruposMusculares gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}

	public TipoEjercicio getTipoEjercicio() {
		return tipoEjercicio;
	}

	public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	public boolean isUsaGoma() {
		return usaGoma;
	}

	public void setUsaGoma(boolean usaGoma) {
		this.usaGoma = usaGoma;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public ArrayList<String> nombreEjercicioTironOEmpuje() throws SQLException {

		ArrayList<String> nombreEjercicio = new ArrayList<String>();
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos = smt.executeQuery("Select nombre from ejercicios where tipoEjercicio='tiron' or tipoEjercicio='empuje' ;");
		while (devuelveDatos.next()) {
			this.nombre = devuelveDatos.getString("nombre");
			nombreEjercicio.add(this.nombre);
		}
		UtilsDB.desconectarBD();
		return nombreEjercicio;
	}

	public String estaticoODinamico() throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos = smt.executeQuery("Select estatico_o_dinamico from ejercicios where nombre ='"+nombre+"' ;");
		while (devuelveDatos.next()) {
			this.estatico_o_dinamico = devuelveDatos.getString("estatico_o_dinamico");
			
		}
		
		UtilsDB.desconectarBD();
		return estatico_o_dinamico;
		
	}
	public ArrayList<String> nombreEjercicioFront() throws SQLException {

		ArrayList<String> nombreEjercicio = new ArrayList<String>();
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos = smt.executeQuery("Select nombre from ejercicios where tipoEjercicio='FRONTLEVER' ;");
		while (devuelveDatos.next()) {
			this.nombre = devuelveDatos.getString("nombre");
			nombreEjercicio.add(this.nombre);
		}
		UtilsDB.desconectarBD();
		return nombreEjercicio;
	}
	public ArrayList<String> nombreEjercicio() throws SQLException {

		ArrayList<String> nombreEjercicio = new ArrayList<String>();
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos = smt.executeQuery("Select nombre from ejercicios  ;");
		while (devuelveDatos.next()) {
			this.nombre = devuelveDatos.getString("nombre");
			nombreEjercicio.add(this.nombre);
			if(nombreEjercicio.size()==127) {
				
				UtilsDB.desconectarBD();
				return nombreEjercicio;
			}
		}
		
		UtilsDB.desconectarBD();
		return nombreEjercicio;
	}
	
	public ArrayList<String> nombreEjercicioPlancha() throws SQLException {

		ArrayList<String> nombreEjercicio = new ArrayList<String>();
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos = smt.executeQuery("Select nombre from ejercicios where tipoEjercicio='PLANCHA'  ;");
		while (devuelveDatos.next()) {
			this.nombre = devuelveDatos.getString("nombre");
			nombreEjercicio.add(this.nombre);
		}
		
		UtilsDB.desconectarBD();
		return nombreEjercicio;
	}
	public ArrayList<Ejercicio> todos() throws SQLException{
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Ejercicio>ejercicios=new ArrayList<Ejercicio>();
		ResultSet devuelveDatos = smt.executeQuery("Select nombre,dificultad,gruposMusculares,tipoEjercicio,usaGoma,descripcion from ejercicios  ;");
		while (devuelveDatos.next()) {
			Ejercicio ej = new Ejercicio();
			ej.nombre = devuelveDatos.getString("nombre");
			ej.dificultad = Dificultad.valueOf(devuelveDatos.getString("dificultad"));
			ej.gruposMusculares = GruposMusculares.valueOf(devuelveDatos.getString("gruposMusculares"));
			ej.tipoEjercicio = TipoEjercicio.valueOf(devuelveDatos.getString("tipoEjercicio"));
			ej.usaGoma=devuelveDatos.getBoolean("usaGoma");
			ej.descripcion=devuelveDatos.getString("descripcion");
			ejercicios.add(ej);
				if(ejercicios.size()==127) {
				
				UtilsDB.desconectarBD();
				return ejercicios;
			}
		}
		
		UtilsDB.desconectarBD();
		return ejercicios;
		
		
	}

	@Override
	public String toString() {
		return "Ejercicio: "+nombre+" dificultad: "+dificultad+" musculo mas ejercitado: " +this. gruposMusculares + "\ntipo de ejercicio: " + this.tipoEjercicio + "usa goma: "
				+ usaGoma+ "\n descripcion: "+descripcion+"\n";
	}
}
