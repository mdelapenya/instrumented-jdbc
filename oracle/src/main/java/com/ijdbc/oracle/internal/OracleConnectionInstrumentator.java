package com.ijdbc.oracle.internal;

import com.ijdbc.common.Instrumentator;
import com.ijdbc.common.JDBCInstrumentation;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;

/**
 * @author mdelapenya
 */
public class OracleConnectionInstrumentator implements Instrumentator {

	public OracleConnectionInstrumentator(
		JDBCInstrumentation defaultJdbcInstrumentation) {

		this.defaultJdbcInstrumentation = defaultJdbcInstrumentation;
	}

	@Override
	public void instrument(Connection connection) throws SQLException {
		instrument(connection, defaultJdbcInstrumentation);
	}

	@Override
	public void instrument(
			Connection connection, JDBCInstrumentation jdbcInstrumentation)
		throws SQLException {

		String[] metrics =
			new String[OracleConnection.END_TO_END_STATE_INDEX_MAX];

		metrics[OracleConnection.END_TO_END_CLIENTID_INDEX] =
			jdbcInstrumentation.getClientInfo();
		metrics[OracleConnection.END_TO_END_MODULE_INDEX] =
			jdbcInstrumentation.getModuleName();
		metrics[OracleConnection.END_TO_END_ACTION_INDEX] =
			jdbcInstrumentation.getActionName();

		((OracleConnection)connection).setEndToEndMetrics(metrics, (short)0);
	}

	private JDBCInstrumentation defaultJdbcInstrumentation;

}