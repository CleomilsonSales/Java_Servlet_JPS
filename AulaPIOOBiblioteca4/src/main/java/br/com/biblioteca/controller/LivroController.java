package br.com.biblioteca.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.model.Livro;

/**
 * Servlet implementation class LivroController
 */
@WebServlet("/LivroController")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/livro.jsp";
    private static String LIST_LIVRO = "/listLivro.jsp?action=listLivro&page=0";
    private LivroDao dao;
    final int limite = 3; //total de linha para exibir
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LivroController() {
        super();
        dao = new LivroDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		int total_linhas = 0;
		int prox = 0;
		int page = 0;
		int inicioPesquisa = 0;
		
        String action = request.getParameter("action");
        //paginação
        if (!request.getParameter("page").isEmpty()) {
        	page = Integer.parseInt(request.getParameter("page"));
        }else {
        	page = 0;
        }
        
        int ant = page - 1;
        prox = page + 1;
        
        if (ant <= 0) {
        	ant = 0;
        }
        
        total_linhas = dao.getTotalRegistro();
        int ultimaLinha = (total_linhas / limite);
        
        if(prox >= ultimaLinha){ 
        	prox = ultimaLinha; 
        }
        
        request.setAttribute("ant", ant);
        request.setAttribute("prox", prox);
        
        if (page == 0) {
        	inicioPesquisa = 0;
        }else {
        	inicioPesquisa = (((page + 1) * limite) - limite);  
        }
        //fim paginação
        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteById(id);
            forward = LIST_LIVRO;
            request.setAttribute("livros", dao.getLivros(inicioPesquisa, limite));   
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Livro livro = dao.getLivroById(id);
            request.setAttribute("livros", livro);
        } else if (action.equalsIgnoreCase("listLivro")){
            forward = LIST_LIVRO;
            request.setAttribute("livros", dao.getLivros(inicioPesquisa, limite));
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livro livro = new Livro();
		livro.setTitulo(request.getParameter("titulo"));
		livro.setIsbn(request.getParameter("isbn"));
		livro.setIdioma(request.getParameter("idioma"));
        String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
            dao.insert(livro);
        }
        else
        {
        	livro.setId(Integer.parseInt(id));
            dao.update(livro);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_LIVRO);
        request.setAttribute("livros", dao.getLivros(0, limite));
        view.forward(request, response);
		doGet(request, response);
	}

}
