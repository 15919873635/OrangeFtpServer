package com.orange.ftpserver.handler;


import org.apache.commons.lang.StringUtils;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.obj.FtpTransferResponseObject;

public abstract class AbstractFtpHandler extends SimpleChannelHandler {
	protected IFtpSession session;
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent cause) throws Exception
	{ 
		if(cause.getCause() instanceof FtpCommandException){
			FtpCommandException ftpCommandException = (FtpCommandException)cause.getCause();
			DefaultFtpContext ftpContext = (DefaultFtpContext)session.getFtpContext();
			ftpContext.deleteSession(session.getSessionId());
			DefaultFtpResponse ftpResponse = (DefaultFtpResponse)session.getResponse();
			ftpResponse.setCode(StringUtils.isNumeric(ftpCommandException.getMessage()) ? Integer.parseInt(ftpCommandException.getMessage()) : 200);
			writeResponse(ctx.getChannel());
		}
	}
	
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception
	{
		session = null;
		ctx.sendDownstream(e);
	}
	
	protected void writeResponse(Channel channel){
		FtpTransferResponseObject responseObj = new FtpTransferResponseObject();
        responseObj.setSessionId(session.getSessionId());
		if(session.getResponse().getParameters().length > 0)
        	responseObj.setRespMessage(session.getResponse().getMessage(),session.getResponse().getParameters());
        else
        	responseObj.setRespMessage(session.getResponse().getMessage());
		channel.write(responseObj.getRespMessage());
	}
}
