package com.orange.ftpserver.context;

import java.util.LinkedList;
import java.util.List;

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
			String commandName = "";
			for(String command : commandSplit){
				if(StringUtils.isNotBlank(command)){
					commandName = command;break;
				}
			}
			recivedCommand = FtpRequestCommand.nameOf(commandName);
		}
		return recivedCommand;
	}
	
	public String[] parseParameters(String reciveMessage){
		List<String> parameterArray = new LinkedList<String>();
		String[] commandSplit = reciveMessage.trim().split(" ");
		int count = 0;
		for(String command : commandSplit){
			if(StringUtils.isNotBlank(command) && count == 1){
				parameterArray.add(command);
			}else
				count += 1;
		}
		if(parameterArray.size() > 0){
			String[] parameters = new String[parameterArray.size()];
			int index = 0;
			for(String parameter : parameterArray){
				parameters[index] = parameter;
				index += 1;
			}
			return parameters;
		}
		return new String[0];
	}
	
	public void excuteCommand(FtpSession session,String reciveMessage) 
			throws FtpCommandException{
		FtpRequestCommand recivedCommand = parseCommand(reciveMessage);
		String[] parameters = parseParameters(reciveMessage);
		switch (recivedCommand) {
		case OPEN:
			OPEN open = new OPEN(session,parameters);
			open.exec();
			break;

		default:
			break;
		}
	}
}
