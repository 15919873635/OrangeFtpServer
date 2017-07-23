package com.orange.ftpserver.command.impl;

import java.io.File;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class DELE extends AbstractFtpCommand{

	public DELE(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.DELE, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		String newWorkingDirectory = commandParameter[0];
		DefaultFtpStaticData ftpStaticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		File directory = new File(ftpStaticData.getCWP());
		if(directory.isDirectory()){
			File newDirectoryFile = new File(ftpStaticData.getCWP() + newWorkingDirectory);
			if(!newDirectoryFile.isFile()
					&& newDirectoryFile.canWrite()){
				newDirectoryFile.delete();
			}
		}
	}
}
