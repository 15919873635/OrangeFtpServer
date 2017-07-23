package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 
 * @author lining
 *
 */
public class AUTH extends AbstractFtpCommand{
	
	public AUTH(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.AUTH, parameters);
	}

	@Override
	protected void executCommand(IFtpSession ftpSession) throws FtpCommandException {
		
	}
}
