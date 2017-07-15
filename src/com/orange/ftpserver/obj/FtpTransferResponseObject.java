package com.orange.ftpserver.obj;

import java.io.Serializable;

public class FtpTransferResponseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915478934929027024L;

	/**
	 * ͨ�õ�sessionID
	 */
	private String sessionId;
	
	/**
	 * ���ص���Ϣ
	 */
	private String respMessage;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
}
