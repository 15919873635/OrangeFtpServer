package com.orange.ftpserver.command;

import com.orange.ftpserver.context.IFtpSession;

public interface IFtpCommand {
	IFtpSession getSession();
	FtpRequestCommand getCommand();
	String[] getParameters();
}
