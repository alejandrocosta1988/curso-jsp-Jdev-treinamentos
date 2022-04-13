package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

// O mapeamento é "/ServletLogin". Está configurado em webapp/WEB-INF/web.xml
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		if (!modelLogin.isLoginAndSenhaValid()) {
			
			RequestDispatcher redirecionamento = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Login ou senha incorreto.");
			redirecionamento.forward(request, response);
			
		}
		
		
	}

}
