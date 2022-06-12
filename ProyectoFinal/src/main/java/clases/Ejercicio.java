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
 * Clase Ejercicio que extiende de Entidadcondificultad y a la vez de EntidadConNombre,
 * De esta extienden ejercicio dinamico y ejercicioEstatico
 * @author Antonio Jesus
 */
public class Ejercicio extends EntidadConDificultad {
	//Grupo Muscular mas trabajado por el ejercicio
	private GruposMusculares gruposMusculares;
	//de que tipo es el ejercicio
	private TipoEjercicio tipoEjercicio;
	//boolean para saber si usa goma o no
	private boolean usaGoma;
	//boolean para saber si está realizado o no
	private boolean realizado;
	//Numero de series que se tienen que hacer del ejercicio
	protected byte series;
	//String para saber si es estatico o es dinamico
	private String estatico_o_dinamico;
	//Usuario que realiza los ejercicios
	private Usuario usuario;
	//Descripcion breve del ejercicio
	private String descripcion;
	/**
	 * 
	 * @param nombre String es el nombre del ejercicio
	 * @param dificultad EnumDificultad es la dificultad del ejercicio
	 * @param gruposMusculares EnumGruoMuscular Grupo Muscular mas trabajado por el ejercicio
	 * @param tipoEjercicio enum TipoEjercicio para saber de que tipo es el ejercicio
	 * @param usaGoma bolean para saber si usa goma o no
	 * @param realizado boolean para saber si se ha realizado o no
	 * @param series byte con el numero de series que se realizan del ejercicio
	 */
	public Ejercicio(String nombre, Dificultad dificultad, GruposMusculares gruposMusculares,
			TipoEjercicio tipoEjercicio, boolean usaGoma, boolean realizado, byte series) {
		super(nombre, dificultad);
		this.gruposMusculares = gruposMusculares;
		this.tipoEjercicio = tipoEjercicio;
		this.usaGoma = usaGoma;
		this.realizado = realizado;
		this.series = series;
	}
	/**
	 * Constructor el cual actualiza las series que por defecto sin igualadas a 0 en la base de datos
	 * @param nombre String es el nombre del ejercicio
	 * @param series byte con el numero de series que se realizan del ejercicio
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
	public Ejercicio(String nombre, byte series) throws SQLException {
		super(nombre);

		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate("Update ejercicios set series = " + series + " where nombre = '" + nombre + "';");
		UtilsDB.desconectarBD();
		this.series = series;

	}
	/**
	 * Constructor el cual inserta en la table intermedia de rutinas_ejercicio los ejercicios de la rutina en la base de datos.
	 * @param nombre String es el nombre del ejercicio
	 * @param series byte con el numero de series que se realizan del ejercicio
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
	public Ejercicio(String nombre, Usuario usuario) throws SQLException {
		super(nombre);
		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate(
				"insert into ejercicios_rutina values('" + usuario.getNombre() + "','" + nombre + "')") > 0) {

			this.usuario = usuario;
			
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();

	}
	//Simple constructor vacio, que nos puede ayudar en muchas ocasiones,
	public Ejercicio() {
		super();
	}
	/**
	 * Getter de grupos musculares
	 * @return Enum de Grupos musculares
	 */
	public GruposMusculares getGruposMusculares() {
		return gruposMusculares;
	}
	/*
	 * Setter de grupos musculares para poder añadirlos a los ejercicios.
	 */
	public void setGruposMusculares(GruposMusculares gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}
	
	/**
	 * Getter de TipoEjercicio
	 * @return Enum de TipoEjercicio
	 */
	public TipoEjercicio getTipoEjercicio() {
		return tipoEjercicio;
	}
	/*
	 * Setter de TipoEjercicio para poder añadirlos a los ejercicios.
	 */
	public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}
	/**
	 *getter  de usaGoma 
	 * @return de tipo boolean
	 */
	public boolean isUsaGoma() {
		return usaGoma;
	}
	/**
	 * setter de usaGoma
	 * @param usaGoma de tipo boolean
	 */
	public void setUsaGoma(boolean usaGoma) {
		this.usaGoma = usaGoma;
	}
	
	/**
	 * getter de realizado 
	 * @return de tipo boolean
	 */
	public boolean isRealizado() {
		return realizado;
	}
	/**
	 * setter de realizado
	 * @param realizado de tipo boolean
	 */
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	/**
	 * Funcion que devuelve un ArrayList de String con todos los nombres de los ejericios de la base de datos.
	 * @return de tipo ArrayList<String> devuelve un arrayList con todos los nombres de los ejercicios
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
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
	/**
	 * Funcion que devuelve si un ejercicio es estatico o dinamico.
	 * @return de tipo String devuelve un String dependiendo de si el ejercicio es estatico o es dinamico
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
	public String estaticoODinamico() throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos = smt.executeQuery("Select estatico_o_dinamico from ejercicios where nombre ='"+nombre+"' ;");
		while (devuelveDatos.next()) {
			this.estatico_o_dinamico = devuelveDatos.getString("estatico_o_dinamico");
			
		}
		
		UtilsDB.desconectarBD();
		return estatico_o_dinamico;
		
	}
	/**
	 * Funcion que devuelve un ArrayList>String> con todos los nombres de ejercicios de front lever que hay en la base de datos,
	 * @return ArrayList<String> este arrayList devuelve todos los ejercicios de front lever, se utiliza cuando vayamos a hacer una rutina de front lever
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
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
	/**
	 * Funcion que devuelve un ArrayList>String> con todos los nombres de ejercicios que hay en la base de datos,
	 * @return ArrayList<String> este arrayList devuelve todos los ejercicios la base de datos, se utiliza cuando vayamos a hacer una rutina mixta
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
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
	/**
	 * Funcion que devuelve un ArrayList>String> con todos los nombres de ejercicios de plancha que hay en la base de datos,
	 * @return ArrayList<String> este arrayList devuelve todos los ejercicios de plancha , se utiliza cuando vayamos a hacer una rutina de plancha
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
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
	/**
	 * Funcion que devuelve ArrayList<Ejercicio> con todos los ejercicios de la base de datos
	 * @return de tipo ArrayList<Ejercicio> devuekve todos los ejericios de la base de datos(hasta 127, que es el maximo de numero de campos soportados)
	 * @throws SQLException Excepcion por si hubiera algun error a la hora de insertar ejercicios en la base de datos
	 */
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
	/*
	 * ToString de ejercicio para mostrarlo en la pantallaInformacionEjercicios
	 */
	public String toString() {
		return "Ejercicio: "+nombre+" dificultad: "+dificultad+" musculo mas ejercitado: " +this. gruposMusculares + "\ntipo de ejercicio: " + this.tipoEjercicio + "usa goma: "
				+ usaGoma+ "\n descripcion: "+descripcion+"\n";
	}
}
