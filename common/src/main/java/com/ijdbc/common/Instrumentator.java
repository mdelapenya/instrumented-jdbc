package com.ijdbc.common;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author mdelapenya
 */
public interface Instrumentator {

	void instrument(Connection connection) throws SQLException;

	void instrument(Connection connection, JDBCInstrumentation instrumentation)
		throws SQLException;

}
