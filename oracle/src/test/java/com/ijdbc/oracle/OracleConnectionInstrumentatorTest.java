package com.ijdbc.oracle;

import com.ijdbc.oracle.scenarios.GivenAConnection;
import com.ijdbc.oracle.scenarios.ThenConnectionIsInstrumented;
import com.ijdbc.oracle.scenarios.WhenExecutingQueries;

import com.tngtech.jgiven.junit.ScenarioTest;

import org.junit.Test;

/**
 * @author mdelapenya
 */
public class OracleConnectionInstrumentatorTest
	extends ScenarioTest<GivenAConnection, WhenExecutingQueries, ThenConnectionIsInstrumented> {

	@Test
	public void executeQueriesOverAConnection() throws Exception {
		GivenAConnection theConnection = given().theConnection();

		when().executingAQuery(theConnection.getConnection());

		then().connectionIsInstrumented(theConnection.getConnection());
	}

}