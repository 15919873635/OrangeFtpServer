package com.orange.ftpserver.context;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.command.OPEN;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.util.FtpSessionUtil;

public class FtpRequestCommandParser {
	
	public static FtpRequestCommandParser defaultParser(){
		return new FtpRequestCommandParser();
	}
	
	public FtpRequestCommand parseCommand(String reciveMessage){
		FtpRequestCommand recivedCommand = FtpRequestCommand.BLANK;
		if(StringUtils.isNotBlank(reciveMessage) 
				&& FtpSessionUtil.hasEOL(reciveMessage)){
			String[] commandSplit = reciveMessage.trim().split(" ");
			String commandName = commandSplit[0];
			recivedCommand = FtpRequestCommand.nameOf(commandName);
		}
		return recivedCommand;
	}
	
	public void excuteCommand(FtpSession session,String reciveMessage) 
			throws FtpCommandException{
		FtpRequestCommand recivedCommand = parseCommand(reciveMessage);
		switch (recivedCommand) {
		case OPEN:
			OPEN open = new OPEN(session,new String[2]);
			open.exec();
			break;

		default:
			break;
		}
	}
}
