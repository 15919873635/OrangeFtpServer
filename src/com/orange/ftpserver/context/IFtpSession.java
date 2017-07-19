package com.orange.ftpserver.context;

import com.orange.ftpserver.user.IFtpUser;

public interface IFtpSession {
	String getSessionId();
	IFtpRequest getRequest();
	IFtpResponse getResponse();
	IFtpUser getUser();
	IFtpContext getFtpContext();
	
	boolean isLoggedIn();
	boolean isSecure();
}
