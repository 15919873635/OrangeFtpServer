package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ���������ļ������������һ������Ӧ����RNTOָ���µ��ļ���
 * @author lining
 *
 */
public class RNFR extends AbstractFtpCommand{
	
	public RNFR(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.RNFR, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
