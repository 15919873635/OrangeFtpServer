package com.orange.ftpserver.handler;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public abstract class AbstractFtpHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = Logger.getLogger(AbstractFtpHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		System.out.println("12345");
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception
	{
		System.out.println("110");
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		System.out.println("error");
		logger.error(cause.getMessage(), cause);
		ctx.channel().close();
	}
}
