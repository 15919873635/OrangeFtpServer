package com.orange.ftpserver.context;

import com.orange.ftpserver.user.FtpUser;

public final class DefaultFtpSession implements FtpSession {
	
	private String sessionId;
	private FtpRequest ftpRequest;
	private FtpResponse ftpResponse;
	private FtpUser ftpUser;
	private boolean isLoggedIn;
	private boolean isSecure;
	
	public DefaultFtpSession(){
		ftpRequest = new DefaultFtpRequest(this);
		ftpResponse = new DefaultFtpResponse(this);
	}
	
	public void setSessionId(String sessionId){
		this.sessionId = sessionId;
	}
	
	@Override
	public String getSessionId() {
		return sessionId;
	}

	@Override
	public FtpResponse getResponse() {
		return ftpResponse;
	}

	@Override
	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setSecure(boolean isSecure){
		this.isSecure = isSecure;
	}
	
	@Override
	public boolean isSecure() {
		return isSecure;
	}

	@Override
	public FtpRequest getRequest() {
		return ftpRequest;
	}
	
	public void setUser(FtpUser ftpUser){
		this.ftpUser = ftpUser;
	}
	
	@Override
	public FtpUser getUser() {
		isLoggedIn = true;
		return ftpUser;
	}
}
