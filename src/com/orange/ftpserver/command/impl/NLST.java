package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 列出指定目录内容,如果不是目录则报错
 * @author lining
 *
 */
public class NLST extends AbstractFtpCommand{
	
	public NLST(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.NLST, parameters);
	}

	@Override
	protected void executCommand(IFtpSession ftpSession) throws FtpCommandException {
		
	}
}
