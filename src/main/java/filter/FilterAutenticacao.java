package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// Um filtro intercepta todas as requisições que vierem do projeto ou mapeamento. O index não passa pelo filtro. O padrão de url para passar pelo filtro foi configurado como "principal/*". Ver em src/main/webapp/WEB-INF/web.xml
public class FilterAutenticacao extends HttpFilter {
	
	private static Connection connection;
       
    public FilterAutenticacao() {
        super();
    }

    //Encerra os processos quando o servidor é parado.
    // Encerra processos de conexão com o banco.
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Intercepta as requisições e dá as respostas no sistema
	// Tudo que for feito no sistema, passa por ele. Ex.: validação de conexão, commit ou rollback de transações do banco, validar e fazer redirecionamento de páginas.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			
			String usuarioLogado = (String) session.getAttribute("usuario");
			String urlParaAutenticar = req.getServletPath(); //url que está sendo acessada
			
			//validar se está logado. Se não, redireciona para tela de login
			if (usuarioLogado == null &&
					!urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {
				
				RequestDispatcher redirecionamento = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por favor, realize login!");
				redirecionamento.forward(request, response);
				return; //para a execução e redireciona para o login
				
			} else {
				chain.doFilter(request, response);			
			}
			
			connection.commit(); //dando tudo certo, as alterações no banco devem ser comitadas
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	// Inicia os processos ou recursos quando o servidor sobe o projeto
	// Iniciar a conexão com o banco
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
	}

}
