package com.orange.ftpserver.context;

import java.util.Collection;
import java.util.Map;

import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.server.AbstractFtpServerListener;
import com.orange.ftpserver.server.DefaultServerFactory;

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
	
	private void onCommand(Collection<AbstractFtpServerListener> values) 
			throws FtpCommandException{
		for(AbstractFtpServerListener listener : values){
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
		Map<String,AbstractFtpServerListener> listenerMap = DefaultServerFactory.getFtpContext().getListenerMap();
		Collection<AbstractFtpServerListener> values = listenerMap.values();
		for(AbstractFtpServerListener listener : values){
			listener.beforeCommond(ftpSession);
		}
		onCommand(values);
		for(AbstractFtpServerListener listener : values){
			listener.afterCommond(ftpSession);
		}
	}
}
