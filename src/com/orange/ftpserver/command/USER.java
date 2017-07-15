package com.orange.ftpserver.command;

import com.orange.ftpserver.context.AbstractFtpCommand;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.FtpSession;

public class USER extends AbstractFtpCommand{

	protected USER(FtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.USER, parameters);
	}

	@Override
	public void exec() {
		
	}
}
