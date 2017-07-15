package com.orange.ftpserver.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.orange.ftpserver.context.FtpRequestCommandParser;

public class FtpServerHandler extends AbstractFtpHandler {
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent event)  
            throws Exception {
        String message = (String) event.getMessage();
		FtpRequestCommandParser commandDecoder = FtpRequestCommandParser.defaultParser();
		commandDecoder.excuteCommand(super.session,message);
		ctx.getChannel().write(super.session.getResponse());
	}
}
