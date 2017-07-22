package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class MODE extends AbstractFtpCommand{
	
	public MODE(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.MODE, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
