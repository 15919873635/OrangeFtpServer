package com.orange.ftpserver.factory;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.IFtpContext;
import com.orange.ftpserver.listener.AbstractFtpServerListener;
import com.orange.ftpserver.listener.DefaultFtpServerListener;
import com.orange.ftpserver.server.DefaultFtpServer;
import com.orange.ftpserver.server.IFtpServer;
import com.orange.ftpserver.user.DefaultUserManager;

public final class DefaultServerFactory implements IFtpServerFactory{
	private static DefaultFtpContext ftpContext = new DefaultFtpContext();;
	
	public DefaultServerFactory(){
		Map<String,AbstractFtpServerListener> defaultListenerMap = createListenerMap();
		ftpContext.setListenerMap(defaultListenerMap);
		ftpContext.setUserManager(new DefaultUserManager());
	}
	
	@Override
	public IFtpServer createServer() {
		IFtpServer ftpServer = new DefaultFtpServer();
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
	
	private Map<String,AbstractFtpServerListener> createListenerMap(){
		Map<String,AbstractFtpServerListener> listenerMap = new HashMap<String,AbstractFtpServerListener>();
		AbstractFtpServerListener defaultServerListener = new DefaultFtpServerListener();
		listenerMap.put("default", defaultServerListener);
		return listenerMap;
	}

	public static IFtpContext getFtpContext() {
		return ftpContext;
	}
}
