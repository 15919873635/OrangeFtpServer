package com.orange.ftpserver.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.FtpRequestCommandParser;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.factory.DefaultServerFactory;
import com.orange.ftpserver.obj.FtpTransferRequestObject;

public class FtpServerHandler extends AbstractFtpHandler {
	protected FtpSession session;
	protected FtpRequestCommandParser commandDecoder = FtpRequestCommandParser.defaultParser();
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent event)  
            throws Exception {
        String message = (String) event.getMessage();
        FtpTransferRequestObject requestObject = commandDecoder.getRequestObject(message);
        if(requestObject != null){
        	DefaultFtpContext ftpContext = (DefaultFtpContext)DefaultServerFactory.getFtpContext();
            if(ftpContext.getSession(requestObject.getSessionId()) == null){
            	commandDecoder.excuteCommand(session,requestObject);
            }
        }
		ctx.getChannel().write(session.getResponse().getMessage());
	}
}
