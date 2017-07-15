package com.orange.ftpserver.obj;

import java.io.Serializable;
import java.util.List;

public final class FtpTransferRequestObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1503040861461532845L;
	
	/**
	 * ͨ�õ�sessionID
	 */
	private String sessionId;
	/**
	 * ������
	 */
	private String command;
	/**
	 * �������
	 */
	private List<String> parameters;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
}
