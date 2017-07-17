package com.orange.ftpserver.context;

public interface IFtpCommand {
	IFtpSession getSession();
	FtpRequestCommand getCommand();
	String[] getParameters();
}
