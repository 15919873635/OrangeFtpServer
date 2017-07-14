package com.orange.ftpserver.command;

import org.apache.commons.lang.StringUtils;

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
}
