package com.orange.ftpserver.context;


import com.orange.ftpserver.command.FtpRequestCommand;

public class DefaultFtpSession implements FtpSession {
	
	private String sessionId;
	private FtpRequestCommand ftpCommand;
	private FtpResponse ftpResponse;
	
	public DefaultFtpSession(String sessionId){
		this.sessionId = sessionId;
		ftpResponse = new DefaultFtpResponse();
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}
	
	@Override
	public void setCommand(FtpRequestCommand ftpCommand) {
		this.ftpCommand = ftpCommand;
	}
	
	@Override
	public FtpRequestCommand getCommand() {
		return ftpCommand;
	}

	@Override
	public FtpResponse getResponse() {
		return ftpResponse;
	}

	@Override
	public boolean isLoggedIn() {
		return false;
	}

	@Override
	public boolean isSecure() {
		return false;
	}
}
