package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 请求服务器将指定路径内的文件复制到客户端，也即下载指定的文件
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
