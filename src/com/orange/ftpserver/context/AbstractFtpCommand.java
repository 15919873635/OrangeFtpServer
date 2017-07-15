package com.orange.ftpserver.context;

import java.util.Collection;
import java.util.Map;

import com.orange.ftpserver.factory.DefaultServerFactory;
import com.orange.ftpserver.listener.FtpServerListener;

public abstract class AbstractFtpCommand implements FtpCommand {
	
	protected FtpSession ftpSession;
	
	protected FtpRequestCommand ftpCommand;
	protected String[] commandParameter;

	protected AbstractFtpCommand(FtpSession ftpSession,FtpRequestCommand ftpCommand,String[] parameters){
		this.ftpSession = ftpSession;
		this.ftpCommand = ftpCommand;
		this.commandParameter = parameters;
		DefaultFtpRequest ftpRequest = (DefaultFtpRequest)ftpSession.getRequest();
		ftpRequest.setFtpCommand(this);
	}
	
	protected abstract void exec();
	
	@Override
	public FtpSession getSession(){
		return ftpSession;
	}
	
	@Override
	public FtpRequestCommand getCommand() {
		return ftpCommand;
	}

	@Override
	public String[] getParameters() {
		return commandParameter;
	}
	
	private void onCommand(){
		
	}
	
	public void executCommand() throws Exception{
		exec();
		Map<String,FtpServerListener> listenerMap = DefaultServerFactory.getFtpContext().getListenerMap();
		Collection<FtpServerListener> values = listenerMap.values();
		for(FtpServerListener listener : values){
			listener.beforeCommond(ftpSession);
		}
		onCommand();
		for(FtpServerListener listener : values){
			listener.afterCommond(ftpSession);
		}
	}
}
