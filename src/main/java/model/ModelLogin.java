package model;

public class ModelLogin {

	private String login;
	private String senha;
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return this.login;
	}

	public boolean isLoginAndSenhaValid() {
		
		if (isLoginValid() && isSenhaValid()) return true;	
		return false;
		
	}
	
	private boolean isLoginValid() {
		
		if (this.login != null && !this.login.isEmpty()) {
			return true;
		}	
		return false;
		
	}
	
	private boolean isSenhaValid() {
		
		if (this.senha != null && !this.senha.isEmpty()) return true;
		return false;
		
	}
}
