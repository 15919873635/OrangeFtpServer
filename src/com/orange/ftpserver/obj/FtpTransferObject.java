package com.orange.ftpserver.obj;

import java.io.Serializable;

public class FtpTransferObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1503040861461532845L;
	
	private String sessionId;
	private String message;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		StringBuffer toStringBuffer = new StringBuffer("Response :[");
		toStringBuffer.append("sessionId=").append(sessionId).append(",").append("message=").append(message);
		return toStringBuffer.toString();
	}
}
