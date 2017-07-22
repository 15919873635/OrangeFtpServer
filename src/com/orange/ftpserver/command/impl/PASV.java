package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ���������FTP����������FTP��������ָ�������ݶ˿ڽ��м��������뱻������
 * @author lining
 *
 */
public class PASV extends AbstractFtpCommand{
	
	public PASV(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.PASV, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
