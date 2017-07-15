package com.orange.ftpserver.context;


import java.util.UUID;

import org.jboss.netty.channel.Channel;

import com.orange.ftpserver.factory.DefaultServerFactory;

public class DefaultFtpSession implements FtpSession {
	
	private String sessionId;
	private FtpRequest ftpRequest;
	private FtpResponse ftpResponse;
	
	public DefaultFtpSession(){
		ftpRequest = new DefaultFtpRequest(this);
		ftpResponse = new DefaultFtpResponse(this);
	}
	
	public void initByChannel(Channel channel){
		this.sessionId = UUID.randomUUID().toString();
		DefaultFtpContext ftpContext = (DefaultFtpContext)DefaultServerFactory.getFtpContext();
		ftpContext.putSession2Map(sessionId, this);
	}
	
	@Override
	public String getSessionId() {
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
