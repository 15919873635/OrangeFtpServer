package com.orange.ftpserver.context;

public class DefaultFtpRequest implements FtpRequest {
	private FtpSession ftpSession;
	private FtpCommand ftpCommand;
	
	public DefaultFtpRequest(FtpSession ftpSession){
		this.ftpSession = ftpSession;
	}
	
	public void setFtpCommand(FtpCommand ftpCommand){
		this.ftpCommand = ftpCommand;
	}
	@Override
	public FtpSession getSession() {
		return ftpSession;
	}

	@Override
	public FtpCommand getFtpCommand() {
		return ftpCommand;
	}
}
