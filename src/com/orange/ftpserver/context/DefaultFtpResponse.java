package com.orange.ftpserver.context;

public class DefaultFtpResponse implements FtpResponse {

	private int code;
	
	public DefaultFtpResponse(){}
	
	public DefaultFtpResponse(int code){
		this.code = code;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return null;
	}

	@Override
	public long getSentTime() {
		return 0;
	}

	@Override
	public boolean isPositive() {
		return false;
	}
}
