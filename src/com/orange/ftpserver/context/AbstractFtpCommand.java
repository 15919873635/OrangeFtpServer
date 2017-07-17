package com.orange.ftpserver.context;

import java.util.Collection;
import java.util.Map;

import com.orange.ftpserver.exception.FtpCommandException;
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
	
	protected abstract void exec() throws Exception;
	
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
	
	private void onCommand(Collection<FtpServerListener> values) 
			throws FtpCommandException{
		for(FtpServerListener listener : values){
			switch (ftpCommand) {
			case MKD:
				listener.onMkdir(ftpSession);
				break;
			case RMD:
				listener.onRmdir(ftpSession);
				break;
			case STOR:
				listener.onStore(ftpSession);
				break;
			case DELE:
				listener.onDelete(ftpSession);
				break;
			default:
				break;
			}
			
		}
	}
	
	public void executCommand() throws FtpCommandException{
		Map<String,FtpServerListener> listenerMap = DefaultServerFactory.getFtpContext().getListenerMap();
		Collection<FtpServerListener> values = listenerMap.values();
		for(FtpServerListener listener : values){
			listener.beforeCommond(ftpSession);
		}
		onCommand(values);
		for(FtpServerListener listener : values){
			listener.afterCommond(ftpSession);
		}
	}
}
