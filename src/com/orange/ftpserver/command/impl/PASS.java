package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ָ���û���������������ڵ�¼�û�������֮��
 * @author lining
 *
 */
public class PASS extends AbstractFtpCommand{
	
	public PASS(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.PASS, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
