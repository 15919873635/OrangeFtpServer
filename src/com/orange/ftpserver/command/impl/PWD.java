package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class PWD extends AbstractFtpCommand {

	protected PWD(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.PWD, parameters);
	}

	@Override
	protected void executCommand(IFtpSession ftpSession) throws FtpCommandException {
		DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
		ftpResponse.setParameters(new String[]{ftpSession.getFtpStaticData().getCWP()});
	}
}
