package servlets;

import java.io.IOException;

import dao.DAOLoginRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

// O mapeamento é "/ServletLogin" e "/principal/ServletLogin". Está configurado em webapp/WEB-INF/web.xml
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository(); 
       
    public ServletLogin() {
        super();
    }

	/**
	 * Recebe os dados pela url em parâmetros.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Recebe os dados enviados via formulário.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ModelLogin modelLogin = new ModelLogin();
		modelLogin.setLogin(request.getParameter("login"));
		modelLogin.setSenha(request.getParameter("senha"));

		String url = request.getParameter("url");
		
		try {
			
			if (!modelLogin.isLoginAndSenhaValid()) {
				
				RequestDispatcher redirecionamento = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Login ou senha incorreto.");
				redirecionamento.forward(request, response);
				
			}
			
			//simulação de login
			if (daoLoginRepository.validarAutenticacao(modelLogin)) {
				
				request.getSession().setAttribute("usuario", modelLogin.getLogin()); //login e senha validados. Criamos uma seção e passamos o login do usuário como atributo. Poderíamos passar o modelLogin inteiro, mas assim a senha ficaria registrada na seção.
				
				if (url == null|| url.equals("null")) {
					url = "principal/principal.jsp";
				}
				
				RequestDispatcher redirecionamento = request.getRequestDispatcher(url);
				redirecionamento.forward(request, response);
				
			} else {
				RequestDispatcher redirecionamento = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Login ou senha incorreto.");
				redirecionamento.forward(request, response);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
