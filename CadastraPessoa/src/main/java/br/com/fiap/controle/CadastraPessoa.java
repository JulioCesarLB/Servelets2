package br.com.fiap.controle;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.modelo.Pessoa;
import br.com.fiap.negocio.BusinessObject;

/**
 * Servlet implementation class CadastraPessoa
 */
@WebServlet("/CadastraPessoa")
public class CadastraPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		String data = request.getParameter("nascimento");
		String[] conhecimentos = request.getParameterValues("skills");
		String[] idiomas = request.getParameterValues("idiomas");
		
		Pessoa pes = new Pessoa();
		pes.setNome(nome);
		pes.setGenero(genero);
		
		List<String> linguas = new ArrayList<>();
		for(String s: idiomas)
			linguas.add(s);
		pes.setIdiomas(linguas);
		
		List<String> skills = new ArrayList<>();
		for(String s: conhecimentos)
			skills.add(s);
		pes.setSkills(skills);

		LocalDate id = LocalDate.parse(data);
		pes.setNascimento(id);
		
		try {
			BusinessObject negocio = new BusinessObject();
			negocio.cadastraPessoa(pes);
			//colocando a pessoa cadastrada para a pagina JSP
			request.setAttribute("info",pes);
			request.getRequestDispatcher("exibePessoa.jsp").forward(request, response);
			
		}catch(Exception e ) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
