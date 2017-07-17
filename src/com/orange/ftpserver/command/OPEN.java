package com.orange.ftpserver.command;

import com.orange.ftpserver.context.AbstractFtpCommand;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public final class OPEN extends AbstractFtpCommand{
	
	public OPEN(FtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.OPEN,parameters);
	}
	
	@Override
	public void exec() throws FtpCommandException{
		super.executCommand();
	}
}
