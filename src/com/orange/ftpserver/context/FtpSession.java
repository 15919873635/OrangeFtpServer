package com.orange.ftpserver.context;

import com.orange.ftpserver.user.FtpUser;

public interface FtpSession {
	String getSessionId();
	FtpRequest getRequest();
	FtpResponse getResponse();
	FtpUser getUser();
	
	boolean isLoggedIn();
	boolean isSecure();
}
