package com.orange.ftpserver.context;

public interface FtpSession {
	Integer getSessionId();
	FtpRequest getRequest();
	FtpResponse getResponse();
	
	boolean isLoggedIn();
	boolean isSecure();
}
