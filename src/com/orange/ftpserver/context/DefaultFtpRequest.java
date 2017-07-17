package com.orange.ftpserver.context;

import com.orange.ftpserver.command.IFtpCommand;

public final class DefaultFtpRequest implements IFtpRequest {
	private IFtpSession ftpSession;
	private IFtpCommand ftpCommand;
	
	public DefaultFtpRequest(IFtpSession ftpSession){
		this.ftpSession = ftpSession;
	}
	
	public void setFtpCommand(IFtpCommand ftpCommand){
		this.ftpCommand = ftpCommand;
	}
	@Override
	public IFtpSession getSession() {
		return ftpSession;
	}

	@Override
	public IFtpCommand getFtpCommand() {
		return ftpCommand;
	}
}
