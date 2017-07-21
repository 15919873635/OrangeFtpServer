package com.orange.ftpserver.command;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.consts.ServerConstant;
import com.orange.ftpserver.context.CommandResult;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

class FtpOnCommand {

	protected void beforeCommond(IFtpSession ftpSession) 
			throws FtpCommandException {
		CommandResult commandResult = checkLoginIn(ftpSession);
		if(commandResult.name().equals(CommandResult.Default.name())){
			commandResult = checkparameters(ftpSession);
		}
	}

	protected void afterCommond(IFtpSession ftpSession) 
			throws FtpCommandException {
		setResponseCode(ftpSession);
	}
	
	private CommandResult checkLoginIn(IFtpSession ftpSession) 
			throws FtpCommandException{
		FtpRequestCommand command = ftpSession.getRequest().getFtpCommand().getCommand();
		if(command.valueOf().equals(FtpRequestCommand.CWD.name())
				|| command.valueOf().equals(FtpRequestCommand.PWD.name())
				|| command.valueOf().equals(FtpRequestCommand.CDUP.name())
				|| command.valueOf().equals(FtpRequestCommand.CLOSE.name())
				|| command.valueOf().equals(FtpRequestCommand.QUIT.name())
				|| command.valueOf().equals(FtpRequestCommand.STOR.name())
				|| command.valueOf().equals(FtpRequestCommand.DELE.name())
				|| command.valueOf().equals(FtpRequestCommand.LIST.name())
				|| command.valueOf().equals(FtpRequestCommand.MKD.name())
				|| command.valueOf().equals(FtpRequestCommand.RMD.name()))
		{
			if(!ftpSession.isLoggedIn())
				throw new FtpCommandException("530");
		}
		return CommandResult.Default;
	}
	
	private CommandResult checkparameters(IFtpSession ftpSession) 
			throws FtpCommandException{
		IFtpCommand command = ftpSession.getRequest().getFtpCommand();
		if(command.getCommand().valueOf().equals(FtpRequestCommand.OPEN.name())){
			String[] parameters = command.getParameters();
			if(parameters.length == 1){
				String address = parameters[0];
				if(address.contains(":")){
					String[] addSplit = address.split(":");
					if(addSplit.length != 2
							|| !addSplit[0].matches(ServerConstant.IP_VERIFICATION)
							|| !StringUtils.isNumeric(addSplit[1]))
						throw new FtpCommandException("501");
				} else
					throw new FtpCommandException("501");
			} else
				throw new FtpCommandException("501");
		} else if(command.getCommand().valueOf().equals(FtpRequestCommand.CWD.name())){
			String[] parameters = command.getParameters();
			if(parameters.length == 1){
				String address = parameters[0];
				if(!address.startsWith("/")){
					throw new FtpCommandException("501");
				} 
			} else
				throw new FtpCommandException("501");
		}
		return CommandResult.Default;
	}
	
	private void setResponseCode(IFtpSession ftpSession){
		IFtpCommand command = ftpSession.getRequest().getFtpCommand();
		DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
		if(command.getCommand().valueOf().equals(FtpRequestCommand.OPEN.name())){
			ftpResponse.setCode(220);
		} else if(command.getCommand().valueOf().equals(FtpRequestCommand.PWD.name()))
			ftpResponse.setCode(257);
	}
}
