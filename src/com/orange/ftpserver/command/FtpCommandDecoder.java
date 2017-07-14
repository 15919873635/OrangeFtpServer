package com.orange.ftpserver.command;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class FtpCommandDecoder {
	
	public static FtpCommandDecoder defaultParser(){
		return new FtpCommandDecoder();
	}
	
	public FtpCommand parseCommand(String reciveMessage){
		FtpCommand recivedCommand = FtpCommand.BLANK;
		if(StringUtils.isNotBlank(reciveMessage)){
			String[] commandSplit = reciveMessage.trim().split(" ");
			String commandName = commandSplit[0];
			recivedCommand = FtpCommand.nameOf(commandName);
		}
		return recivedCommand;
	}
	
	public void excuteCommand(FtpSession session,String reciveMessage) 
			throws FtpCommandException{
		FtpCommand recivedCommand = parseCommand(reciveMessage);
		switch (recivedCommand) {
		case OPEN:
			
			break;

		default:
			break;
		}
	}
}
