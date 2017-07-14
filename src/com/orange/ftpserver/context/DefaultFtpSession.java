package com.orange.ftpserver.context;

public class DefaultFtpSession implements FtpSession {
	
	private String sessionId;
	
	public DefaultFtpSession(String sessionId){
		this.sessionId = sessionId;
	}
	
}
