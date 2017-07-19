package com.orange.ftpserver.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.IFtpException;

public abstract class AbstractFtpHandler extends SimpleChannelHandler {
	protected IFtpSession session;
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent cause) throws Exception
	{ 
		if(cause instanceof IFtpException){
			DefaultFtpContext ftpContext = (DefaultFtpContext)session.getFtpContext();
			ftpContext.deleteSession(session.getSessionId());
			session = null;
		}
	}
}
