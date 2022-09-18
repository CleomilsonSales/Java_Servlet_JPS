package br.com.biblioteca.factory;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory
{
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/biblioteca";
    
    public static Connection createConnectionToMySQL() throws Exception {
    	Class.forName("com.mysql.jdbc.Driver");
    	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    	final Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }
    
    //teste da conexão
    /*public static void main(final String[] args) throws Exception {
    	final Connection con = createConnectionToMySQL();
        if (con != null) {
            System.out.println("Conexão ok!");
            con.close();
        }else {
        	System.out.println("Falhou");
        }
    }*/
}