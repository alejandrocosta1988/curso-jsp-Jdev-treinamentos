package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelLoginTest {
	
	private ModelLogin modelLogin;
	private String login;
	private String senha;
	
	@BeforeEach
	public void createModelLogin() {
		
		this.modelLogin = new ModelLogin();
		this.login = "meuLogin";
		this.senha = "minhaSenha";

	}

	@Test
	void ifLoginNotInformedReturnFalse() {
		
		modelLogin.setSenha(senha);
		
		assertFalse(modelLogin.isLoginAndSenhaValid());
		
	}
	
	@Test
	void ifLoginIsEmptyReturnFalse() {
		
		modelLogin.setLogin("");
		modelLogin.setSenha(senha);
		
		assertFalse(modelLogin.isLoginAndSenhaValid());
		
	}
	
	@Test 
	public void ifSenhaNotInformedReturnFalse() {
		
		modelLogin.setLogin(login);
		
		assertFalse(modelLogin.isLoginAndSenhaValid());
		
	}
	
	@Test
	public void ifSenhaIsEmptyReturnFalse() {
		
		modelLogin.setLogin(login);
		modelLogin.setSenha("");
		
		assertFalse(modelLogin.isLoginAndSenhaValid());
		
	}
	
	@Test 
	void ifLoginAndSenhaIsInformedReturnTrue() {
		
		modelLogin.setLogin(login);
		modelLogin.setSenha(senha);
		
		assertTrue(modelLogin.isLoginAndSenhaValid());
		
	}

}
