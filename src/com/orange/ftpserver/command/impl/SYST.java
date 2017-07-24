package com.orange.ftpserver.command.impl;

import java.util.Properties;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class SYST extends AbstractFtpCommand{
	public SYST(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.SYST, parameters);
	}

	@Override
	protected void executCommand(IFtpSession ftpSession) throws FtpCommandException {
		Properties props = System.getProperties();
		DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
		ftpResponse.setParameters(new String[]{props.getProperty("os.name"),props.getProperty("os.arch"),props.getProperty("os.version")});
	}
}
