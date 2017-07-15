package com.orange.ftpserver.context;

import com.orange.ftpserver.command.FtpRequestCommand;

public class DefaultFtpRequest implements FtpRequest {
	private FtpRequestCommand ftpCommand;
	private FtpCommandParameter commandParameter;
	
	@Override
	public FtpRequestCommand getCommand() {
		return ftpCommand;
	}

	@Override
	public FtpCommandParameter getParameters() {
		return commandParameter;
	}

	public void setCommand(FtpRequestCommand ftpRequestCommand) {
		this.ftpCommand = ftpRequestCommand;
	}
}
