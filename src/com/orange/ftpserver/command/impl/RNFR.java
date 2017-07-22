package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 重新命名文件，该命令的下一条命令应该用RNTO指定新的文件名
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
