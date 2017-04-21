package com.ijdbc.oracle;

import com.ijdbc.common.Instrumentator;
import com.ijdbc.common.JDBCInstrumentation;
import com.ijdbc.oracle.internal.OracleConnectionInstrumentator;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Manuel de la Peña
 */
public class OracleInstrumentationUtil {

	public static void instrument(
			Connection connection, String actionName, String clientInfo,
			String moduleName)
		throws SQLException {

		instrument(
			connection,
			new JDBCInstrumentation(actionName, clientInfo, moduleName));
	}

	public static void instrument(
			Connection connection, JDBCInstrumentation jdbcInstrumentation)
		throws SQLException {

		Instrumentator instrumentator = new OracleConnectionInstrumentator(
			jdbcInstrumentation);

		instrumentator.instrument(connection);
	}

}