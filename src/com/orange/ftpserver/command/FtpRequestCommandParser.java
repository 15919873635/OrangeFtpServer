package com.orange.ftpserver.command;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.orange.ftpserver.command.impl.CLOSE;
import com.orange.ftpserver.command.impl.OPEN;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.obj.FtpTransferRequestObject;

public final class FtpRequestCommandParser {
	
	public static FtpRequestCommandParser defaultParser(){
		return new FtpRequestCommandParser();
	}
	
	public FtpTransferRequestObject getRequestObject(String reciveMessage){
		FtpTransferRequestObject requestObject = null;
		if(StringUtils.isNotBlank(reciveMessage)){
			JSONObject messageObject = JSONObject.parseObject(reciveMessage);
			if(!messageObject.isEmpty()){
				requestObject = JSONObject.toJavaObject(messageObject, FtpTransferRequestObject.class);
			}
		}
		return requestObject;
	}
	
	public FtpRequestCommand parseCommand(FtpTransferRequestObject requestObject){
		FtpRequestCommand recivedCommand = FtpRequestCommand.BLANK;
		if(requestObject != null){
			recivedCommand = FtpRequestCommand.nameOf(requestObject.getCommand());
		}
		return recivedCommand;
	}
	
	public String[] parseParameters(FtpTransferRequestObject requestObject){
		List<String> parameterArray = new LinkedList<String>();
		if(requestObject != null){
			parameterArray.addAll(requestObject.getParameters());
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
	
	public void excuteCommand(IFtpSession session,FtpTransferRequestObject requestObject) 
			throws FtpCommandException{
		FtpRequestCommand recivedCommand = parseCommand(requestObject);
		String[] parameters = parseParameters(requestObject);
		switch (recivedCommand) {
		case OPEN:
			OPEN open = new OPEN(session,parameters);
			open.exec();
			break;
		case CLOSE:
			CLOSE close = new CLOSE(session,parameters);
			close.exec();
		default:
			break;
		}
	}
}
