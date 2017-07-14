package com.orange.ftpserver.command;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class FtpRequestCommandDecoder {
	
	public static FtpRequestCommandDecoder defaultParser(){
		return new FtpRequestCommandDecoder();
	}
	
	public FtpRequestCommand parseCommand(String reciveMessage){
		FtpRequestCommand recivedCommand = FtpRequestCommand.BLANK;
		if(StringUtils.isNotBlank(reciveMessage)){
			String[] commandSplit = reciveMessage.trim().split(" ");
			String commandName = commandSplit[0];
			recivedCommand = FtpRequestCommand.nameOf(commandName);
		}
		return recivedCommand;
	}
	
	public void excuteCommand(FtpSession session,String reciveMessage) 
			throws FtpCommandException{
		FtpRequestCommand recivedCommand = parseCommand(reciveMessage);
		session.setCommand(recivedCommand);
		switch (recivedCommand) {
		case OPEN:
			DefaultFtpResponse ftpResponse = (DefaultFtpResponse)session.getResponse();
			ftpResponse.setCode(220);
			break;

		default:
			break;
		}
	}
}
