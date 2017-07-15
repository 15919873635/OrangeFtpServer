package com.orange.ftpserver.command;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.context.DefaultFtpRequest;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.FtpSession;
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
		DefaultFtpRequest ftpRequest = (DefaultFtpRequest)session.getRequest();
		ftpRequest.setCommand(recivedCommand);
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
