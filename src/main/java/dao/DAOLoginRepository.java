package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOLoginRepository {

	private SingleConnectionBanco connectionObject = new SingleConnectionBanco();
	private Connection connection;
	
	public DAOLoginRepository() {
		connection = connectionObject.getConnection();
	}
	
	public boolean validarAutenticacao(ModelLogin modelLogin) throws SQLException {
		
		String sql = "SELECT * FROM table_model_login WHERE login = ? AND senha = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
			
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) return true; //autenticado
		
		return false; //não autenticado
		
	}
	
}
