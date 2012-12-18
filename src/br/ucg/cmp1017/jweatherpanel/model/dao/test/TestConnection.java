package br.ucg.cmp1017.jweatherpanel.model.dao.test;

import java.sql.Connection;

import br.ucg.cmp1017.jweatherpanel.model.dao.util.DatabaseConnectionFactory;

public class TestConnection {

	/**
	 * Classe de teste da classe {@link DatabaseConnectionFactory}.
	 * 
	 * @author Filipe Bezerra <br>
	 * 
	 */
	public static void main(final String[] args) {
		System.out.println("Realizando teste de conexão com banco de dados...");
		try {
			DatabaseConnectionFactory connectionManager = DatabaseConnectionFactory
					.getInstance();
			System.out
					.println("Consegui uma instância da classe fábrica de conexão: "
							+ connectionManager);
			Connection connection = connectionManager.getConnection();
			System.out.println("Some database definitions...");
			System.out.println("---------------------------------------");
			System.out.println("Is Auto Commit: " + connection.getAutoCommit());
			System.out.println("Catalog: " + connection.getCatalog());
			System.out.println("Network timeout: "
					+ connection.getNetworkTimeout());
			System.out.println("Schema: " + connection.getSchema());
			System.out.println("Transaction isolation: "
					+ connection.getTransactionIsolation());
		} catch (Exception e) {
			System.out.println(e.getClass().toString() + "; " + e.getMessage());
		}
	}

}
