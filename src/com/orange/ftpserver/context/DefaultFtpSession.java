package com.orange.ftpserver.context;


import org.jboss.netty.channel.Channel;

import com.orange.ftpserver.util.FtpSessionUtil;

public class DefaultFtpSession implements FtpSession {
	
	private Integer sessionId;
	private FtpRequest ftpRequest;
	private FtpResponse ftpResponse;
	
	public DefaultFtpSession(){
		ftpRequest = new DefaultFtpRequest(this);
		ftpResponse = new DefaultFtpResponse(this);
	}
	
	public void initByChannel(Channel channel){
		this.sessionId = channel.getId();
		FtpSessionUtil.putSession2Map(sessionId, this);
	}
	
	@Override
	public Integer getSessionId() {
		return sessionId;
	}

	@Override
	public FtpResponse getResponse() {
		return ftpResponse;
	}

	@Override
	public boolean isLoggedIn() {
		return false;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public FtpRequest getRequest() {
		return ftpRequest;
	}
}
