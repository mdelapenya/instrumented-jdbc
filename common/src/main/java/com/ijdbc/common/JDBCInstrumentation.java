package com.ijdbc.common;

import com.ijdbc.common.internal.ActionName;
import com.ijdbc.common.internal.ClientInfo;
import com.ijdbc.common.internal.ModuleName;

/**
 * @author mdelapenya
 */
public class JDBCInstrumentation implements ActionName, ClientInfo, ModuleName {

	public JDBCInstrumentation(
		String actionName, String clientInfo, String moduleName) {

		this.actionName = actionName;
		this.clientInfo = clientInfo;
		this.moduleName = moduleName;
	}

	@Override
	public String getActionName() {
		return actionName;
	}

	@Override
	public String getClientInfo() {
		return clientInfo;
	}

	@Override
	public String getModuleName() {
		return moduleName;
	}

	private String actionName;
	private String clientInfo;
	private String moduleName;

}