package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {	
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/login";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	
	static {
		try {
			Class.forName(CONTROLADOR);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Conexion conexion = new Conexion();
		conexion.conectar();
	}
	
	public Connection conectar() {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			System.out.println("Conexión OK");
			
		}catch(SQLException ex) {
			System.out.println("Error en la conexión");
			ex.printStackTrace();
		}
		
		return conexion;
		
	}
	
	
}
