package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * �����������ָ��·���ڵ��ļ����Ƶ��ͻ��ˣ�Ҳ������ָ�����ļ�
 * @author lining
 *
 */
public class RETR extends AbstractFtpCommand{
	
	public RETR(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.RETR, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
