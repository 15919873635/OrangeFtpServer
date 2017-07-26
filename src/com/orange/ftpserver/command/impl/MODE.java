package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 传输模式（S=流模式，B=块模式，C=压缩模式）
 * @author lining
 *
 */
public class MODE extends AbstractFtpCommand{
	
	public MODE(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.MODE, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
