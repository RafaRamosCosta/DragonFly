package br.com.dragonfly.dao;

import java.sql.*;

/**
 * Classe Conexao -> responsável por realizar a conexão com o banco de dados
 * 
 * @author RafaRamosCosta
 * @author DiogoKahn
 */
public class Conexao {
	private Connection con = null;
	/**
	 * Método abreConexao() -> abre a conexao com o banco de dados
	 * 
	 * @author RafaRamosCosta
	 * @return Connection con -> retorna um objeto da classe Connection (a conexão)
	 */
	public Connection abreConexao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM94286";
			final String PASS = "040304";
			con = DriverManager.getConnection(url, USER, PASS);
			System.out.println("Conexão aberta!");
			return con;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Método fechaConexao() -> fecha a conexão com o banco de dados
	 * 
	 * @author RafaRamosCosta
	 * @author DiogoKahn
	 * @param objeto da classe Connection
	 * @return void
	 */
	public static void fechaConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexão fechada!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}