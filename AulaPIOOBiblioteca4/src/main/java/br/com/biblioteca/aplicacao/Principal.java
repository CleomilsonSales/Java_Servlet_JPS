package br.com.biblioteca.aplicacao;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.dao.LivroDao;

public class Principal
{
    public static void main(final String[] args) {
    	//USANDO PARA TESTE PELO CONSOLE DO JAVA
    	final LivroDao livroDao = new LivroDao();
        final Livro livro = new Livro();
        livro.setTitulo("Teste1235");
        livro.setIsbn("15FD6556");
        livro.setIdioma("PT-PT");
        livroDao.insert(livro);
        
        /*livro.setId(3);
        livroDao.update(livro);*/
        
        //livroDao.deleteById(3);

        /*for (final Livro l : livroDao.getLivros()) {
            System.out.println("Livros: " + l.getTitulo());
        }*/
        
        /*Livro livro2 = new Livro();
        livro2 = livroDao.getLivroById(3);
        System.out.println(livro.getTitulo());*/
    }
}