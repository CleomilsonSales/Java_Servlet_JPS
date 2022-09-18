package br.com.biblioteca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import br.com.biblioteca.factory.ConnectionFactory;
import br.com.biblioteca.model.Livro;

public class LivroDao
{
    public void insert(final Livro livro) {
        final String sql = "INSERT INTO livro(titulo, isbn, idioma) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getIsbn());
            pstm.setString(3, livro.getIdioma());
            pstm.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            return;
        }
        finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    
    public void update(final Livro livro) {
        final String sql = "UPDATE livro SET titulo = ?, isbn = ?, idioma = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getIsbn());
            pstm.setString(3, livro.getIdioma());
            pstm.setInt(4, livro.getId());

            pstm.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            return;
        }
        finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    
    public void deleteById(final int id) {
        final String sql = "DELETE FROM livro WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            return;
        }
        finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    
    public List<Livro> getLivros(int page, int limite) {
        final String sql = "SELECT * FROM livro LIMIT ?, ?";
        final List<Livro> livros = new ArrayList<Livro>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, page);
            pstm.setInt(2, limite);
            rset = pstm.executeQuery();
            while (rset.next()) {
                final Livro livro = new Livro();
                livro.setId(rset.getInt("id"));
                livro.setTitulo (rset.getString("titulo"));
                livro.setIsbn(rset.getString("isbn"));
                livro.setIdioma(rset.getString("idioma"));
                livros.add(livro);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            return livros;
        }
        finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (rset != null) {
                rset.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        return livros;
    }
    
    public Livro getLivroById(int id) {
    	final String sql = "SELECT * FROM livro where id=?";
        final Livro livro = new Livro();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            
            if (rset.next()) {
            	livro.setId(rset.getInt("id"));
                livro.setTitulo (rset.getString("titulo"));
                livro.setIsbn(rset.getString("isbn"));
                livro.setIdioma(rset.getString("idioma"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            return livro;
        }
        finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (rset != null) {
                rset.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        return livro;

    }
    
    public int getTotalRegistro() {
    	final String sql = "SELECT count(*) as total FROM livro";
    	int total_linha = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            rset.next();
            total_linha = Integer.parseInt(rset.getString("total"));
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            return total_linha;
        }
        finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (rset != null) {
                rset.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        return total_linha;

    }
}