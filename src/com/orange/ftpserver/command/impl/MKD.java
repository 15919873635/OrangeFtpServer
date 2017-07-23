package com.orange.ftpserver.command.impl;

import java.io.File;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class MKD extends AbstractFtpCommand{
	
	public MKD(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.MKD, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		String newWorkingDirectory = commandParameter[0];
		DefaultFtpStaticData ftpStaticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		File directory = new File(ftpStaticData.getCWP());
		if(directory.isDirectory()){
			File newDirectory = new File(ftpStaticData.getCWP() + newWorkingDirectory);
			if(!newDirectory.exists())
				newDirectory.mkdir();
			DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
			ftpResponse.setParameters(new String[]{newDirectory.getName()});
		}
	}
}
