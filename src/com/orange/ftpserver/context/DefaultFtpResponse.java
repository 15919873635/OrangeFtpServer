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
		return null;
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
