package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * �������RNFR���ͬ��ɶ��ļ�����������������RNFR�����
 * @author lining
 *
 */
public class RNTO extends AbstractFtpCommand{
	
	public RNTO(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.RNTO, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
