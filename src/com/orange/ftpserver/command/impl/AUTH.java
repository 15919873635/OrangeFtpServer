package com.orange.ftpserver.command.impl;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 认证方式
 * @author lining
 *
 */
public class AUTH extends AbstractFtpCommand{
	
	public AUTH(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.AUTH, parameters);
	}

	@Override
	protected void executCommand(IFtpSession ftpSession) throws FtpCommandException {
		String authType = commandParameter[0];
		if(StringUtils.isNotBlank(authType)){
			
		}
	}
}
