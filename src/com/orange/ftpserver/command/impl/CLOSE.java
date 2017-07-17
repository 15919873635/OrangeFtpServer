package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public final class CLOSE extends AbstractFtpCommand{

	public CLOSE(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.CLOSE, parameters);
	}

	@Override
	public void exec() throws FtpCommandException{
		super.executCommand();
	}
}
