package com.orange.ftpserver.handler;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.command.FtpRequestCommandParser;
import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.DefaultFtpSession;
import com.orange.ftpserver.context.IFtpContext;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.obj.FtpTransferRequestObject;
import com.orange.ftpserver.obj.FtpTransferResponseObject;

public final class FtpDataHandler extends SimpleChannelHandler{
	private IFtpSession session;
	
	private IFtpContext ftpContext;

	private FtpRequestCommandParser commandDecoder = FtpRequestCommandParser.defaultParser();
	
	public FtpDataHandler(IFtpContext ftpContext){
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
        writeResponseAndCloseSession(ctx.getChannel());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent cause) throws Exception
	{ 
		if(cause.getCause() instanceof FtpCommandException){
			FtpCommandException ftpCommandException = (FtpCommandException)cause.getCause();
			DefaultFtpResponse ftpResponse = (DefaultFtpResponse)session.getResponse();
			ftpResponse.setCode(StringUtils.isNumeric(ftpCommandException.getMessage()) ? Integer.parseInt(ftpCommandException.getMessage()) : 200);
			writeResponse(ctx.getChannel());
		}
	}
	
	private void writeResponse(Channel channel){
		FtpTransferResponseObject responseObj = new FtpTransferResponseObject();
        responseObj.setSessionId(session.getSessionId());
		if(session.getResponse().getParameters().length > 0)
        	responseObj.setRespMessage(session.getResponse().getMessage(),session.getResponse().getParameters());
        else
        	responseObj.setRespMessage(session.getResponse().getMessage());
		channel.write(responseObj.getRespMessage());
	}
	
	private void writeResponseAndCloseSession(Channel channel){
		FtpRequestCommand ftpCommand = session.getRequest().getFtpCommand().getCommand();
		writeResponse(channel);
		switch(ftpCommand){
			case BYE:
			case QUIT:
				DefaultFtpContext ftpContext = (DefaultFtpContext)session.getFtpContext();
				ftpContext.deleteSession(session.getSessionId());
				session = null;
				break;
			default:
				break;
		}
	}
}
