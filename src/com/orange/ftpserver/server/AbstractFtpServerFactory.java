package com.orange.ftpserver.server;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.IFtpContext;
import com.orange.ftpserver.user.DefaultUserManager;

public abstract class AbstractFtpServerFactory{
	
	protected DefaultFtpContext ftpContext = new DefaultFtpContext();
	protected int serverPort = 0;
	
	public AbstractFtpServerFactory(){
		Map<String,AbstractFtpServerListener> defaultListenerMap = createListenerMap();
		ftpContext.setListenerMap(defaultListenerMap);
		ftpContext.setUserManager(new DefaultUserManager());
	}
	
	private Map<String,AbstractFtpServerListener> createListenerMap(){
		Map<String,AbstractFtpServerListener> listenerMap = new HashMap<String,AbstractFtpServerListener>();
		AbstractFtpServerListener defaultServerListener = new DefaultFtpServerListener();
		listenerMap.put("default", defaultServerListener);
		return listenerMap;
	}
	
	protected abstract IFtpServer createServer();
	
	protected abstract IFtpServer createServer(int serverPort);
	
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	
	public IFtpContext getFtpContext() {
		return ftpContext;
	}
}
