package com.orange.ftpserver.server;

import org.jboss.netty.channel.ChannelPipeline;

import com.orange.ftpserver.context.IFtpContext;

public final class DefaultFtpServer extends AbstractFtpServer{
	
	public DefaultFtpServer(IFtpContext ftpContext){
		super(ftpContext);
	}
	
	public DefaultFtpServer(IFtpContext ftpContext,int serverPort){
		super(ftpContext,serverPort);
	}

	@Override
	protected void addSSL(ChannelPipeline pipeline) {
		
	}

	@Override
	public void startClientPort(int clientPort) {
		super.initClientPipeline(clientPort);
	}
}