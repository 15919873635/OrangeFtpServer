package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class CWD extends AbstractFtpCommand{
	
	public CWD(IFtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.CWD,parameters);
	}
	
	@Override
	public void exec() throws FtpCommandException{
		super.executCommand();
	}
}
