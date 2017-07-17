package com.orange.ftpserver.listener;

import com.orange.ftpserver.context.CommandResult;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public abstract class AbstractFtpServerListener implements IFtpServerListener {

	@Override
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
				return CommandResult.Nomal;
		}else
			return CommandResult.Nomal;
	}

	@Override
	public CommandResult afterCommond(IFtpSession ftpSession) throws FtpCommandException {
		return CommandResult.NeedLogin;
	}
}
