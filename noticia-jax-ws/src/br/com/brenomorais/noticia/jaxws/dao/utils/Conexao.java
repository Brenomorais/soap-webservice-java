package br.com.brenomorais.noticia.jaxws.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static final Connection connection = construirConexao();
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/crudjaxws";
	private static final String USER = "postgres";
	private static final String PASS = "blm123";

	private static Connection construirConexao() {
		try {
			Class.forName(DRIVER);			
			System.out.println(">> Conectado banco de dados!");
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception ex) {
			System.err.println("Conexão falhou: " + ex.getMessage());
			ex.printStackTrace();			
		}
		return null;
	}

	public static Connection getConnection() {
		return connection;
	}

}
