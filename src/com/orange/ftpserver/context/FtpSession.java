package com.orange.ftpserver.context;

public interface FtpSession {
	String getSessionId();
	FtpRequest getRequest();
	FtpResponse getResponse();
	
	boolean isLoggedIn();
	boolean isSecure();
}
