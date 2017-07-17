package com.orange.ftpserver.context;

import java.util.Collection;
import java.util.Map;

import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.factory.DefaultServerFactory;
import com.orange.ftpserver.listener.IFtpServerListener;

public abstract class AbstractFtpCommand implements IFtpCommand {
	
	protected IFtpSession ftpSession;
	
	protected FtpRequestCommand ftpCommand;
	protected String[] commandParameter;

	protected AbstractFtpCommand(IFtpSession ftpSession,FtpRequestCommand ftpCommand,String[] parameters){
		this.ftpSession = ftpSession;
		this.ftpCommand = ftpCommand;
		this.commandParameter = parameters;
		DefaultFtpRequest ftpRequest = (DefaultFtpRequest)ftpSession.getRequest();
		ftpRequest.setFtpCommand(this);
	}
	
	protected abstract void exec() throws Exception;
	
	@Override
	public IFtpSession getSession(){
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
	
	private void onCommand(Collection<IFtpServerListener> values) 
			throws FtpCommandException{
		for(IFtpServerListener listener : values){
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
		Map<String,IFtpServerListener> listenerMap = DefaultServerFactory.getFtpContext().getListenerMap();
		Collection<IFtpServerListener> values = listenerMap.values();
		for(IFtpServerListener listener : values){
			listener.beforeCommond(ftpSession);
		}
		onCommand(values);
		for(IFtpServerListener listener : values){
			listener.afterCommond(ftpSession);
		}
	}
}
