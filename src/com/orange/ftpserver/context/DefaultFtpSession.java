package com.orange.ftpserver.context;

import com.orange.ftpserver.command.FtpCommand;

public class DefaultFtpSession implements FtpSession {
	
	private String sessionId;
	private FtpCommand ftpCommand;
	private FtpResponse ftpResponse;
	
	public DefaultFtpSession(String sessionId){
		this.sessionId = sessionId;
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}
	
	@Override
	public FtpCommand getCommand() {
		return ftpCommand;
	}

	@Override
	public FtpResponse getResponse() {
		return ftpResponse;
	}
}
