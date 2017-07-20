package com.orange.ftpserver.handler;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

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
			session = null;
			ctx.getChannel().write(ftpResponse.getMessage());
		}
	}
}
