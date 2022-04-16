package connection;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class SingleConnectionBancoTest {
	
	private Connection connection = null;

	@Test
	void afterConnectingToPostgreSqlConnectionIsNotNull() {
		
		connection = SingleConnectionBanco.getConnection();
		
		assertTrue(connection != null);
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
