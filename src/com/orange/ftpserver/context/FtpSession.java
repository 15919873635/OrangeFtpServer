package com.orange.ftpserver.context;

import com.orange.ftpserver.command.FtpCommand;

public interface FtpSession {
	String getSessionId();
	FtpCommand getCommand();
	FtpResponse getResponse();
}
