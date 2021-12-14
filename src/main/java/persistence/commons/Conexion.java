package persistence.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection con;
	private static String url = "jdbc:sqlite:D:\\Mis documentos\\Todo tipo de documentos\\yoprogramo\\proyectoFinal\\ProyectoTierraMedia.db";	
	
	public static Connection obtenerConexion() {
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if(con == null) {
			try {
				con = DriverManager.getConnection(url);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}		
		
		return con;
	}
	
	public static void cerrar() throws SQLException {
		con.close();
	}
	
}
