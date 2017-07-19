package com.orange.ftpserver.server;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.IFtpContext;
import com.orange.ftpserver.user.DefaultUserManager;

public final class DefaultServerFactory implements IFtpServerFactory{
	private DefaultFtpContext ftpContext = new DefaultFtpContext();;
	
	public DefaultServerFactory(){
		Map<String,AbstractFtpServerListener> defaultListenerMap = createListenerMap();
		ftpContext.setListenerMap(defaultListenerMap);
		ftpContext.setUserManager(new DefaultUserManager());
	}
	
	@Override
	public IFtpServer createServer() {
		IFtpServer ftpServer = new DefaultFtpServer(ftpContext);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
	
	private Map<String,AbstractFtpServerListener> createListenerMap(){
		Map<String,AbstractFtpServerListener> listenerMap = new HashMap<String,AbstractFtpServerListener>();
		AbstractFtpServerListener defaultServerListener = new DefaultFtpServerListener();
		listenerMap.put("default", defaultServerListener);
		return listenerMap;
	}

	public IFtpContext getFtpContext() {
		return ftpContext;
	}
}
