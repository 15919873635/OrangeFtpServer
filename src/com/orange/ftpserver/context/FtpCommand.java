package com.orange.ftpserver.context;

public interface FtpCommand {
	FtpSession getSession();
	FtpRequestCommand getCommand();
	String[] getParameters();
}
