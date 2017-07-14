package com.orange.ftpserver.context;

import com.orange.ftpserver.command.FtpRequestCommand;

public interface FtpSession {
	String getSessionId();
	void setCommand(FtpRequestCommand ftpCommand);
	FtpRequestCommand getCommand();
	FtpResponse getResponse();
	
	boolean isLoggedIn();
	boolean isSecure();
}
