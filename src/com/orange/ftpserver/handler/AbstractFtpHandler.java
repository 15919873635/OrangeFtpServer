package com.orange.ftpserver.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public abstract class AbstractFtpHandler extends SimpleChannelHandler {

	private static Logger logger = Logger.getLogger(AbstractFtpHandler.class);
		
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent cause) throws Exception
	{ 
		System.out.println("error");
		logger.error(cause.getCause().getMessage(), cause.getCause());
	}
}
