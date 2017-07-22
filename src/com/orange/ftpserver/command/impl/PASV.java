package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 该命令告诉FTP服务器，让FTP服务器在指定的数据端口进行监听，进入被动接收
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
