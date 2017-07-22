package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 回到上层目录
 * @author lining
 *
 */
public class CDUP extends AbstractFtpCommand{
	
	public CDUP(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.CDUP, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
