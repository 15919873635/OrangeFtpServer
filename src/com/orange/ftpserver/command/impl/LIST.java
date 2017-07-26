package com.orange.ftpserver.command.impl;

import java.io.File;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ������ļ����г��ļ���Ϣ�������Ŀ¼���г��ļ��б�
 * @author lining
 *
 */
public class LIST extends AbstractFtpCommand{

	public LIST(IFtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.LIST,parameters);
	}
	
	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		String newWorkingDirectory = commandParameter[0];
		DefaultFtpStaticData ftpStaticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		File directory = new File(ftpStaticData.getCWP());
		if(directory.isDirectory()){
			File newDirectory = new File(ftpStaticData.getCWP() + newWorkingDirectory);
			if(newDirectory.isDirectory()){
				newDirectory.listFiles();
			} else{
				
			}
		}
	}
}
