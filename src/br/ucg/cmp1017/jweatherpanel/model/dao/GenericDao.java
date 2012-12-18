package br.ucg.cmp1017.jweatherpanel.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.ucg.cmp1017.jweatherpanel.model.dao.util.DatabaseConnectionFactory;

/**
 * 
 * @author Filipe Bezerra
 * 
 * @param <T>
 */
public abstract class GenericDao<T> {
	private final Connection connection;

	protected GenericDao() throws Exception {
		connection = DatabaseConnectionFactory.getInstance().getConnection();
	}

	protected Connection getConnection() {
		return connection;
	}

	public void insert(final String insertSQL, final Object... parametros) {

	}

	public void alter(final String alterSQL, final Object... parametros) {

	}

	public void delete(final String deleteSQL, final int id) {

	}

	protected void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
