package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * �г�ָ��Ŀ¼����,�������Ŀ¼�򱨴�
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
