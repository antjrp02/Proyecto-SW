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

public class Ejercicio extends EntidadConDificultad {
	private GruposMusculares gruposMusculares;
	private TipoEjercicio tipoEjercicio;
	private boolean usaGoma;
	private boolean realizado;
	protected byte series;
	private String estatico_o_dinamico;
	private Usuario usuario;

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

	public ArrayList<String> nombreEjercicio() throws SQLException {

		ArrayList<String> nombreEjercicio = new ArrayList<String>();
		Statement smt = UtilsDB.conectarBD();
		ResultSet devuelveDatos = smt.executeQuery("Select nombre from ejercicios ;");
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

	@Override
	public String toString() {
		return "Ejercicio [gruposMusculares=" + gruposMusculares + ", tipoEjercicio=" + tipoEjercicio + ", usaGoma="
				+ usaGoma + ", realizado=" + realizado + ", series=" + series + ", estatico_o_dinamico="
				+ estatico_o_dinamico + ", usuario=" + usuario + "]";
	}
}
