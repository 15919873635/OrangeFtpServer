package com.orange.ftpserver.server;

import com.orange.ftpserver.context.CommandResult;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public abstract class AbstractFtpServerListener implements IFtpServerListener {

	public abstract void beforeRmdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterRmdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeMkdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterMkdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeStore(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterStore(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeAppend(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterAppend(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeDelete(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterDelete(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeClose(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterClose(IFtpSession ftpSession) throws FtpCommandException;
	
	public CommandResult beforeCommond(IFtpSession ftpSession) throws FtpCommandException {
		FtpRequestCommand command = ftpSession.getRequest().getFtpCommand().getCommand();
		if(command.valueOf().equals(FtpRequestCommand.CWD.name())
				|| command.valueOf().equals(FtpRequestCommand.CDUP.name())
				|| command.valueOf().equals(FtpRequestCommand.CLOSE.name())
				|| command.valueOf().equals(FtpRequestCommand.STOR.name())
				|| command.valueOf().equals(FtpRequestCommand.DELE.name())
				|| command.valueOf().equals(FtpRequestCommand.LIST.name())
				|| command.valueOf().equals(FtpRequestCommand.MKD.name())
				|| command.valueOf().equals(FtpRequestCommand.RMD.name()))
		{
			if(!ftpSession.isLoggedIn())
				return CommandResult.NeedLogin;
			else
				return CommandResult.Default;
		}else
			return CommandResult.Default;
	}

	public CommandResult afterCommond(IFtpSession ftpSession) throws FtpCommandException {
		return CommandResult.NeedLogin;
	}
	
	public void onRmdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}
	
	public void onStore(IFtpSession ftpSession) throws FtpCommandException {
		
	}
	
	public void onMkdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}
	
	public void onAppend(IFtpSession ftpSession) throws FtpCommandException {
		
	}
	
	public void onDelete(IFtpSession ftpSession) throws FtpCommandException {
		
	}
	
	public void onClose(IFtpSession ftpSession) throws FtpCommandException {
		
	}
}
