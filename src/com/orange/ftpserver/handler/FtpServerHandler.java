package com.orange.ftpserver.handler;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.DefaultFtpSession;
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
        if(requestObject != null 
        		&& StringUtils.isNotBlank(requestObject.getSessionId())){
        	DefaultFtpContext ftpContext = (DefaultFtpContext)DefaultServerFactory.getFtpContext();
        	session = ftpContext.getSession(requestObject.getSessionId());
        	if(session == null){
            	session = new DefaultFtpSession();
            	DefaultFtpSession ftpSession = (DefaultFtpSession)session;
            	ftpSession.setSessionId(requestObject.getSessionId());
            	ftpContext.putSession2Map(requestObject.getSessionId(), ftpSession);
            }
            commandDecoder.excuteCommand(session,requestObject);
        }
		ctx.getChannel().write(session.getResponse().getMessage());
	}
}
