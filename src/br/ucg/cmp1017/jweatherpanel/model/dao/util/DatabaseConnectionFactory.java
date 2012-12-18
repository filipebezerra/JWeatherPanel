package br.ucg.cmp1017.jweatherpanel.model.dao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Classe Responsável por realizar a comunicação externa (boundary) com o SGBD
 * retornando uma conexão para efetuar transações com o banco de dados em caso
 * de sucesso, ou ao ocorrer uma exceção imediatamento é relançado ao chamador
 * do classe.
 * 
 * @author Filipe Bezerra <br>
 * 
 */
public class DatabaseConnectionFactory {
	private static DatabaseConnectionFactory instance;
	private static String URL;
	private static String USUARIO;
	private static String SENHA;

	private DatabaseConnectionFactory() throws Exception {
		try {
			Properties properties = new Properties();
			InputStream in = getClass()
					.getClassLoader()
					.getResourceAsStream(
							"br/ucg/cmp1017/jweatherpanel/model/dao/resouce/database.properties");
			properties.load(in);
			in.close();
			Class.forName(properties.getProperty("driver"));

			URL = properties.getProperty("url");
			USUARIO = properties.getProperty("usuario");
			SENHA = properties.getProperty("senha");
		} catch (Exception exception) {
			throw exception;
		}
	}

	public static DatabaseConnectionFactory getInstance() throws Exception {
		if (instance == null) {
			instance = new DatabaseConnectionFactory();
		}
		return instance;
	}

	public synchronized Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			return connection;
		} catch (Exception exception) {
			throw exception;
		}
	}
}
