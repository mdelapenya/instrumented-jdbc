package com.ijdbc.oracle.scenarios;

import com.ijdbc.common.JDBCInstrumentation;
import com.ijdbc.oracle.OracleInstrumentationUtil;

import com.tngtech.jgiven.Stage;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;

import org.mockito.Mockito;

/**
 * @author mdelapenya
 */
public class GivenAConnection extends Stage<GivenAConnection> {

	public Connection getConnection() {
		return connection;
	}

	public GivenAConnection theConnection()
		throws SQLException {

		JDBCInstrumentation jdbcInstrumentation = new JDBCInstrumentation(
			"actionName", "clientInfo", "moduleName");

		connection = Mockito.mock(OracleConnection.class);

		OracleInstrumentationUtil.instrument(connection, jdbcInstrumentation);

		return self();
	}

	private Connection connection;

}