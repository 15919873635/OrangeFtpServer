package com.orange.ftpserver.handler;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.orange.ftpserver.command.FtpRequestCommandParser;
import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.DefaultFtpSession;
import com.orange.ftpserver.context.IFtpContext;
import com.orange.ftpserver.obj.FtpTransferRequestObject;

public final class FtpServerHandler extends AbstractFtpHandler {
	
	private IFtpContext ftpContext;

	protected FtpRequestCommandParser commandDecoder = FtpRequestCommandParser.defaultParser();
	
	public FtpServerHandler(IFtpContext ftpContext){
		this.ftpContext = ftpContext;
	}
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent event)  
            throws Exception {
        String message = (String) event.getMessage();
        FtpTransferRequestObject requestObject = commandDecoder.getRequestObject(message);
        if(requestObject != null 
        		&& StringUtils.isNotBlank(requestObject.getSessionId())){
        	DefaultFtpContext defaultFtpContext = (DefaultFtpContext)ftpContext;
        	session = defaultFtpContext.getSession(requestObject.getSessionId());
        	if(session == null){
            	session = new DefaultFtpSession(ftpContext);
            	DefaultFtpSession ftpSession = (DefaultFtpSession)session;
            	ftpSession.setSessionId(requestObject.getSessionId());
            	defaultFtpContext.putSession2Map(requestObject.getSessionId(), ftpSession);
            }
            commandDecoder.excuteCommand(session,requestObject);
        }
        super.writeResponse(ctx.getChannel());
	}
}
