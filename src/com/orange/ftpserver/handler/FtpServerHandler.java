package com.orange.ftpserver.handler;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.orange.ftpserver.command.FtpRequestCommandDecoder;

public class FtpServerHandler extends AbstractFtpHandler {
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent event)  
            throws Exception {
		ChannelBuffer messageReceived = (ChannelBuffer) event.getMessage();  
        String message = new String(messageReceived.array());
		if(StringUtils.isNotBlank(message)){
			FtpRequestCommandDecoder commandDecoder = FtpRequestCommandDecoder.defaultParser();
			commandDecoder.excuteCommand(super.session,message);
		}
	}
}
