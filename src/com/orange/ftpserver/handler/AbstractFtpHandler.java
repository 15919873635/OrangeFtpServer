package com.orange.ftpserver.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.orange.ftpserver.context.DefaultFtpSession;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.util.FtpSessionUtil;

public abstract class AbstractFtpHandler extends SimpleChannelHandler {

	private static Logger logger = Logger.getLogger(AbstractFtpHandler.class);
	
	protected FtpSession session;
	
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
	{
		Channel channel = ctx.getChannel();
		System.out.println(channel.getId());
		if(session == null){
			session = new DefaultFtpSession();
			DefaultFtpSession ftpSession = (DefaultFtpSession)session;
			ftpSession.initByChannel(channel);
		}
	}
	
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,ChannelStateEvent e) throws Exception
	{
		Channel channel = ctx.getChannel();
		FtpSessionUtil.deleteSession(channel.getId());
		session = null;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent cause) throws Exception
	{ 
		System.out.println("error");
		logger.error(cause.getCause().getMessage(), cause.getCause());
	}
}
