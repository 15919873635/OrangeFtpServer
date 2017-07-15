package com.orange.ftpserver.context;


import org.jboss.netty.channel.Channel;

import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.util.FtpSessionUtil;

public class DefaultFtpSession implements FtpSession {
	
	private Integer sessionId;
	private FtpRequestCommand ftpCommand;
	private FtpResponse ftpResponse;
	
	public DefaultFtpSession(){
		ftpResponse = new DefaultFtpResponse();
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
	public void setCommand(FtpRequestCommand ftpCommand) {
		this.ftpCommand = ftpCommand;
	}
	
	@Override
	public FtpRequestCommand getCommand() {
		return ftpCommand;
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
}
