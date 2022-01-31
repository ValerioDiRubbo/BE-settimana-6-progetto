package it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/bancadb";
	public static final String UTENTE = "postgres";
	public static final String PASSWORD = "100989";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING, UTENTE, PASSWORD);
			System.out.println("Connessione riuscita");
		}
		catch(SQLException ex) {
			System.out.println("Connessione non riuscita");
		}
		return conn;
	}

}

