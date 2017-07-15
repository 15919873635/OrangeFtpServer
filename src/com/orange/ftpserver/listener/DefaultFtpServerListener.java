package com.orange.ftpserver.listener;

import com.orange.ftpserver.context.CommandResult;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public final class DefaultFtpServerListener implements FtpServerListener{

	@Override
	public CommandResult beforeCommond(FtpSession ftpSession) throws FtpCommandException {
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
			if(!ftpSession.isLoggedIn()){
				return CommandResult.NeedLogin;
			}else{
				if(command.valueOf().equals(FtpRequestCommand.RMD.name()))
					onRmdir(ftpSession);
				else if(command.valueOf().equals(FtpRequestCommand.MKD.name()))
					onMkdir(ftpSession);
				else if(command.valueOf().equals(FtpRequestCommand.STOR.name()))
					onStore(ftpSession);
			}
		}
			
		return null;
	}

	@Override
	public CommandResult afterCommond(FtpSession ftpSession) throws FtpCommandException {
		return CommandResult.NeedLogin;
	}

	@Override
	public void beforeRmdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onRmdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterRmdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeStore(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onStore(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterStore(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeAppend(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onAppend(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterAppend(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeClose(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onClose(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterClose(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeMkdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onMkdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterMkdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeDelete(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onDelete(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterDelete(FtpSession ftpSession) throws FtpCommandException {
		
	}
}
