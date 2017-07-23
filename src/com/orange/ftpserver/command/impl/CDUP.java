package com.orange.ftpserver.command.impl;

import java.io.File;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 回到上层目录
 * @author lining
 *
 */
public class CDUP extends AbstractFtpCommand{
	
	public CDUP(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.CDUP, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		DefaultFtpStaticData ftpStaticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		File directory = new File(ftpStaticData.getCWP());
		if(directory.isDirectory()){
			String parentPath = directory.getParent();
			if(parentPath.equals(ftpSession.getUser().getHomedirectory())){
				ftpStaticData.setCWP(parentPath);
			}
			DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
			ftpResponse.setParameters(new String[]{parentPath});
		}
	}
}
