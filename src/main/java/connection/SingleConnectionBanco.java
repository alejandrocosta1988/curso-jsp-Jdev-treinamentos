package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SingleConnectionBanco {

	// utilização de um padrão singleton. Só devemos ter uma conexão com o banco de dados. O que abre e fecha são seções e transações. A conexão é só uma.
	private static String url = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "admin";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar(); //de qualquer lugar que chamar a classe, uma conexão será obtida
	}
	
	public SingleConnectionBanco() {
		conectar(); // se um objeto for instanciado, uma conexão será obtida
	}
	
	private static void conectar() {
		
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, senha);
				connection.setAutoCommit(false); //para não efetuar alterações no banco sem o nosso comando
			}
			
		} catch(Exception e) {
			e.printStackTrace();
	    }
	
	}
	
}
