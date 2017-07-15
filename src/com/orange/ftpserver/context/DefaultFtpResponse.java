package com.orange.ftpserver.context;

import java.util.Date;

public class DefaultFtpResponse implements FtpResponse {
	
	private FtpSession ftpSession;
	
	private int code;
	
	public DefaultFtpResponse(FtpSession ftpSession){
		this.code = 0;
		this.ftpSession = ftpSession;
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
		StringBuffer messageBuffer = new StringBuffer(ftpSession.getSessionId());
		ReplyMessage[] values = ReplyMessage.values();
		ReplyMessage replyMessage = null;
		for(ReplyMessage reply : values){
			if(reply.getCode() == this.code){
				replyMessage = reply;
				break;
			}
		}
		if(replyMessage == null)
			replyMessage = ReplyMessage.REPLY_502_COMMAND_NOT_IMPLEMENTED;
		messageBuffer.append(",").append(replyMessage.getMessage());
		return messageBuffer.toString();
	}

	@Override
	public long getSentTime() {
		return new Date().getTime();
	}

	@Override
	public boolean isPositive() {
		return false;
	}

	@Override
	public FtpSession getSession() {
		return ftpSession;
	}
}
