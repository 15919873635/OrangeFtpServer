package com.orange.ftpserver.command;

import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public interface IFtpCommand {
	IFtpSession getSession();
	FtpRequestCommand getCommand();
	String[] getParameters();
	void exec() throws FtpCommandException;
}
