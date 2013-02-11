package br.ucg.cmp1017.jweatherpanel.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public void insert(final String insertSQL, final Object... parametros)
			throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(insertSQL);
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.execute();
		pstmt.close();
	}

	public void alter(final String alterSQL, final Object... parametros)
			throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(alterSQL);
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.execute();
		pstmt.close();
	}

	public void delete(final String deleteSQL, final int id)
			throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(deleteSQL);
		pstmt.execute();
		pstmt.close();
	}

	protected void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
