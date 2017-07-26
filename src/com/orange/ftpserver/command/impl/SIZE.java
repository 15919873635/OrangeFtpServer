package com.orange.ftpserver.command.impl;

import java.io.File;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * 获取文件大小
 * @author lining
 *
 */
public class SIZE extends AbstractFtpCommand{
	public SIZE(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.SIZE, parameters);
	}

	@Override
	protected void executCommand(IFtpSession ftpSession) throws FtpCommandException {
		String newWorkingDirectory = commandParameter[0];
		DefaultFtpStaticData ftpStaticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		File directory = new File(ftpStaticData.getCWP());
		if(directory.isDirectory()){
			File newDirectoryFile = new File(ftpStaticData.getCWP() + newWorkingDirectory);
			if(newDirectoryFile.isFile() && newDirectoryFile.exists()){
				DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
				ftpResponse.setParameters(new String[]{Long.toString(newDirectoryFile.length())});
			}
		}
	}
}
