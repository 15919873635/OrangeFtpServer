package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class STOR extends AbstractFtpCommand{
	
	public STOR(IFtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.STOR,parameters);
	}
	
	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		
	}
}
