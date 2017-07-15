package com.orange.ftpserver.command;

import com.orange.ftpserver.context.AbstractFtpCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.FtpSession;

public class OPEN extends AbstractFtpCommand{
	
	public OPEN(FtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.OPEN,parameters);
	}
	
	@Override
	public void exec() {
		DefaultFtpResponse ftpResponse = (DefaultFtpResponse)super.ftpSession.getResponse();
		ftpResponse.setCode(220);
	}
}
