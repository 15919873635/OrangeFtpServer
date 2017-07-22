package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 该命令告诉FTP服务器，客户端监听的端口号是address，让FTP服务器采用主动模
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
