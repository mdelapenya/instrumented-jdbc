package com.ijdbc.oracle.scenarios;

import com.tngtech.jgiven.Stage;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;

import org.mockito.Mockito;

/**
 * @author mdelapenya
 */
public class WhenExecutingQueries extends Stage<WhenExecutingQueries> {

	public WhenExecutingQueries executingAQuery(Connection connection)
		throws SQLException {

		String[] metrics =
			new String[OracleConnection.END_TO_END_STATE_INDEX_MAX];

		metrics[OracleConnection.END_TO_END_CLIENTID_INDEX] = "clientInfo";
		metrics[OracleConnection.END_TO_END_MODULE_INDEX] = "moduleName";
		metrics[OracleConnection.END_TO_END_ACTION_INDEX] = "actionName";

		Mockito.when(
			((OracleConnection)connection).getEndToEndMetrics()
		).thenReturn(metrics);

		return self();
	}

}