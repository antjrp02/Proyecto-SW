package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.ContraseñaIncorrectaException;
import excepciones.NivelVacioException;
import excepciones.UsuarioNoExisteException;
import excepciones.ContraseñaVaciaException;
import superClases.EntidadConNombre;
import utilsDB.UtilsDB;

public class Usuario extends EntidadConNombre{
	private String contraseña;
	private byte nivel;//Del 1 al 10, 1 mas novato, 10 mas avanzado. 
	//1 principiante,2 y 3 principiante-intermedio, 4,5 intermedio 6-7 intermedio-avanzado  8 y 9 avanzado y nivel 10 Kamenov
	private String UbicacionEntrenamiento;
	private Entrenamiento entrenamiento;
	
	public Usuario(String nombre, String contraseña, byte nivel, String ubicacionEntrenamiento,
			Entrenamiento entrenamiento) throws SQLException, ContraseñaVaciaException, NivelVacioException {
		super(nombre);
		if (contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}

		if (nivel==0) {
			throw new NivelVacioException("El nivel no puede estar vacio");
		}

		   Statement query=UtilsDB.conectarBD();
		   if (query.executeUpdate("insert into usuario values('" + nombre + "','" + contraseña + "'," + nivel + ",'"
					+ UbicacionEntrenamiento + "','"+entrenamiento+"')")> 0) {
		this.contraseña = contraseña;
		this.nivel = nivel;
		this.UbicacionEntrenamiento = ubicacionEntrenamiento;
		this.entrenamiento = entrenamiento;
		   }else {
				throw new SQLException("No se ha podido insertar el usuario");
			}
			UtilsDB.desconectarBD();
		}
		   
	
	
	public Usuario(String nombre,String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException{
		super(nombre);
        Statement smt=UtilsDB.conectarBD();

        ResultSet cursor=smt.executeQuery("select * from usuario where nombre='"+

        nombre+"'");

        if(cursor.next()) {

                this.contraseña=cursor.getString("contrasena");

                if(!this.contraseña.equals(contraseña)) {

                        UtilsDB.desconectarBD();

                        throw new ContraseñaIncorrectaException("La contraseña no es correcta");

                }

                nombre = cursor.getString("nombre");
                this.nivel=cursor.getByte("nivel");
                this.UbicacionEntrenamiento=cursor.getString("UbicacionEntrenamiento");
                this.entrenamiento=(Entrenamiento) cursor.getClob("Entrenamiento");
                

        }else {

                UtilsDB.desconectarBD();

                throw new UsuarioNoExisteException("No existe ese nombre de usuario en la BD");

        }

        UtilsDB.desconectarBD();

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
	public Entrenamiento getEntrenamiento() {
		return entrenamiento;
	}
	public void setEntrenamiento(Entrenamiento entrenamiento) {
		this.entrenamiento = entrenamiento;
	}
	
	
	
	
	
	
}
