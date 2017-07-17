package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public final class USER extends AbstractFtpCommand{

	protected USER(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.USER, parameters);
	}

	@Override
	public void exec() throws FtpCommandException{
		super.executCommand();
	}
}
