package com.orange.ftpserver.command.impl;

import java.io.File;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class CWD extends AbstractFtpCommand{
	
	public CWD(IFtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.CWD,parameters);
	}
	
	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		String newWorkingDirectory = commandParameter[0];
		DefaultFtpStaticData ftpStaticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		File directory = new File(ftpStaticData.getCWP());
		if(directory.isDirectory()){
			if(newWorkingDirectory.equals("/")){
				String parentPath = directory.getParent();
				if(parentPath.equals(ftpSession.getUser().getHomedirectory())){
					ftpStaticData.setCWP(parentPath);
				}
			} else {
				ftpStaticData.setCWP(ftpSession.getUser().getHomedirectory() + newWorkingDirectory);
			}
			DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
			ftpResponse.setParameters(new String[]{newWorkingDirectory});
		}
	}
}
