package com.orange.ftpserver.handler;

import io.netty.channel.ChannelHandlerContext;

public class FtpServerHandler extends AbstractFtpHandler {
	
	/**
	 * 收到的消息没有指定的结束标记。 
	 * 比如指定了lineBasedFrameDecoder，没有换行标志，是不会调用channelRead方法的，
	 * 其他的类似
	 */
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {
		System.out.println(ctx.name());
	}
}
