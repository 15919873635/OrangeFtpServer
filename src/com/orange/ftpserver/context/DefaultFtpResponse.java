package com.orange.ftpserver.context;

public class DefaultFtpResponse implements FtpResponse {

	private int code;
	
	public DefaultFtpResponse(){}
	
	public DefaultFtpResponse(int code){
		this.code = code;
	}
	
	@Override
	public void string() {
		
	}

	@Override
	public int replyCode() {
		return 0;
	}
}
