package com.orange.ftpserver.handler;

import org.apache.log4j.Logger;

import com.orange.ftpserver.context.DefaultFtpSession;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.util.FtpSessionUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public abstract class AbstractFtpHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = Logger.getLogger(AbstractFtpHandler.class);
	
	protected FtpSession session;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		Channel channel = ctx.channel();
		if(session == null){
			String sessionId = channel.id().asLongText();
			session = new DefaultFtpSession(sessionId);
			FtpSessionUtil.putSession2Map(sessionId, session);
		}
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception
	{
		Channel channel = ctx.channel();
		FtpSessionUtil.deleteSession(channel.id().asLongText());
		session = null;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		System.out.println("error");
		logger.error(cause.getMessage(), cause);
	}
}
