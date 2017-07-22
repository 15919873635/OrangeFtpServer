package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ���³�ʼ���û���Ϣ
 * @author lining
 *
 */
public class REIN extends AbstractFtpCommand{
	
	public REIN(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.REIN, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
