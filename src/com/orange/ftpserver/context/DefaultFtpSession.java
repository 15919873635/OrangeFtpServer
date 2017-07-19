package com.orange.ftpserver.context;

import com.orange.ftpserver.user.IFtpUser;

public final class DefaultFtpSession implements IFtpSession {
	
	private IFtpContext ftpContext;
	private String sessionId;
	private IFtpRequest ftpRequest;
	private IFtpResponse ftpResponse;
	private IFtpUser ftpUser;
	private boolean isLoggedIn;
	private boolean isSecure;
	
	public DefaultFtpSession(IFtpContext ftpContext){
		this.ftpContext = ftpContext;
		ftpRequest = new DefaultFtpRequest(this);
		ftpResponse = new DefaultFtpResponse(this);
	}
	
	public IFtpContext getFtpContext() {
		return ftpContext;
	}

	public void setSessionId(String sessionId){
		this.sessionId = sessionId;
	}
	
	@Override
	public String getSessionId() {
		return sessionId;
	}

	@Override
	public IFtpResponse getResponse() {
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
	public IFtpRequest getRequest() {
		return ftpRequest;
	}
	
	public void setUser(IFtpUser ftpUser){
		this.ftpUser = ftpUser;
	}
	
	@Override
	public IFtpUser getUser() {
		isLoggedIn = true;
		return ftpUser;
	}
}
