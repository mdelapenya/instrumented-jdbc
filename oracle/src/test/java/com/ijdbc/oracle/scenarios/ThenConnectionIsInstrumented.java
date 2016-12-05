package com.ijdbc.oracle.scenarios;

import com.tngtech.jgiven.Stage;

import java.sql.Connection;

import oracle.jdbc.OracleConnection;

import org.junit.Assert;

/**
 * @author mdelapenya
 */
public class ThenConnectionIsInstrumented
	extends Stage<ThenConnectionIsInstrumented> {

	public ThenConnectionIsInstrumented connectionIsInstrumented(
		Connection connection) throws Exception {

		String[] endToEndMetrics = ((OracleConnection) connection).getEndToEndMetrics();

		Assert.assertEquals(
			"actionName",
			endToEndMetrics[oracle.jdbc.OracleConnection.END_TO_END_ACTION_INDEX]);
		Assert.assertEquals(
			"clientInfo",
			endToEndMetrics[oracle.jdbc.OracleConnection.END_TO_END_CLIENTID_INDEX]);
		Assert.assertEquals(
			"moduleName",
			endToEndMetrics[oracle.jdbc.OracleConnection.END_TO_END_MODULE_INDEX]);

		return self();
	}

}