package dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ModelLogin;

class DAOLoginRepositoryTest {

	private ModelLogin modelLogin;
	private static DAOLoginRepository daoLoginRepository;
	
	@BeforeAll
	public static void createConnection() {
		try {
			daoLoginRepository = new DAOLoginRepository();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeEach
	public void createModelLogin() {
		modelLogin = new ModelLogin();
	}
	
	@Test
	void daoHasConnectionWithDataBase() {
		assertTrue(daoLoginRepository.isConnected());
	}
	
	@Test
	void returnsFalseIfLoginOrPasswordAreNotRegisteredInDatabase() throws SQLException {
		
		modelLogin.setLogin("admin");
		modelLogin.setSenha("senhaErrada");
		
		assertFalse(daoLoginRepository.validarAutenticacao(modelLogin));
		
	}
	
	@Test
	void returnsTrueIfLoginAndPasswordAreRegisteredInDatabase() throws SQLException {
		
		modelLogin.setLogin("admin");
		modelLogin.setSenha("admin");
		
		assertTrue(daoLoginRepository.validarAutenticacao(modelLogin));
		
	}

}
