package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ���������FTP���������ͻ��˼����Ķ˿ں���address����FTP��������������ģ
 * @author lining
 *
 */
public class PORT extends AbstractFtpCommand{
	
	public PORT(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.PORT, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
