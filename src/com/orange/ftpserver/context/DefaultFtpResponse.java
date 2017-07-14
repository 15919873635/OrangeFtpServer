package com.orange.ftpserver.context;

import java.util.Date;

public class DefaultFtpResponse implements FtpResponse {
	private int code;
	
	public DefaultFtpResponse(){
		this.code = 0;
	}
	
	public DefaultFtpResponse(int code){
		setCode(code);
	}

	public void setCode(int code){
		this.code = code;
	}
	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		ReplyMessage[] values = ReplyMessage.values();
		ReplyMessage replyMessage = null;
		for(ReplyMessage reply : values){
			if(reply.getCode() == code){
				replyMessage = reply;
				break;
			}
		}
		if(replyMessage == null)
			replyMessage = ReplyMessage.REPLY_502_COMMAND_NOT_IMPLEMENTED;
		return replyMessage.getMessage();
	}

	@Override
	public long getSentTime() {
		return new Date().getTime();
	}

	@Override
	public boolean isPositive() {
		return false;
	}
}
