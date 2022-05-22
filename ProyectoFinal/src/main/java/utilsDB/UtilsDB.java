package utilsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilsDB {

    // TODO Hacer un gestor de conexiones aqui

    private static final String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/proyectoFinal";

    private static final String usuarioBBDD = "root";

    private static final String contrasenha = "admin";

    private static Connection conexion;

    public static Statement conectarBD() {

        try {
            if (conexion == null) {
                conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoFinal", "root",
                        "admin");

            }
            return conexion.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.err.println("No se ha podido conectar,inténtalo luego");
            return null;
        }

    }

    public static void desconectarBD() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.err.println("No se ha podido desconectar");
            }
        }
    }

}