package com.orange.ftpserver.handler;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.command.FtpRequestCommandDecoder;
import com.orange.ftpserver.context.FtpResponse;

import io.netty.channel.ChannelHandlerContext;

public class FtpServerHandler extends AbstractFtpHandler {
	
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {
		if(StringUtils.isNotBlank((String) msg)){
			FtpRequestCommandDecoder commandDecoder = FtpRequestCommandDecoder.defaultParser();
			commandDecoder.excuteCommand(super.session,(String)msg);
		}
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx)
			throws Exception
	{
		FtpResponse ftpResonse = super.session.getResponse();
		if(ftpResonse != null){
			ctx.writeAndFlush(ftpResonse);
		}
	}
}
