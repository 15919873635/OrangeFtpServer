package com.orange.ftpserver.server;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.user.DefaultUserManager;

public final class DefaultServerFactory extends AbstractFtpServerFactory{
	
	public DefaultServerFactory(){
		Map<String,AbstractFtpServerListener> defaultListenerMap = createListenerMap();
		ftpContext.setListenerMap(defaultListenerMap);
		ftpContext.setUserManager(new DefaultUserManager());
	}
	
	@Override
	public IFtpServer createServer() {
		IFtpServer ftpServer = null;
		if(serverPort == 0)
			ftpServer = new DefaultFtpServer(ftpContext);
		else
			ftpServer = new DefaultFtpServer(ftpContext,serverPort);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
	
	@Override
	public IFtpServer createServer(int serverPort) {
		IFtpServer ftpServer = new DefaultFtpServer(ftpContext,serverPort);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
	
	private Map<String,AbstractFtpServerListener> createListenerMap(){
		Map<String,AbstractFtpServerListener> listenerMap = new HashMap<String,AbstractFtpServerListener>();
		AbstractFtpServerListener defaultServerListener = new DefaultFtpServerListener();
		listenerMap.put("default", defaultServerListener);
		return listenerMap;
	}
}
