package com.orange.ftpserver.context;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.orange.ftpserver.obj.FtpTransferResponseObject;

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
		FtpTransferResponseObject responseObject = new FtpTransferResponseObject();
		responseObject.setSessionId(this.ftpSession.getSessionId());
		responseObject.setRespMessage(replyMessage.getMessage());
		return JSONObject.toJSONString(responseObject);
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
