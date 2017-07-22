package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ָ��Ҫ������������ͣ���ASCII��BINARY
 * @author lining
 *
 */
public class TYPE extends AbstractFtpCommand{
	
	public TYPE(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.TYPE, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
