package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bg_exercicio02","postgres","26470505");
			
		}
		catch(Exception e) {
			System.out.println("\nFalha ai abrir conexão com o banco de dados!");
			System.out.println(e.getMessage());
		}
		
		return connection;
	}
}
