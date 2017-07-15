package com.orange.ftpserver.factory;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.FtpContext;
import com.orange.ftpserver.listener.DefaultFtpServerListener;
import com.orange.ftpserver.listener.FtpServerListener;
import com.orange.ftpserver.server.DefaultFtpServer;
import com.orange.ftpserver.server.FtpServer;

public class DefaultServerFactory implements FtpServerFactory{
	private static FtpContext ftpContext;
	@Override
	public FtpServer createServer() {
		FtpServer ftpServer = new DefaultFtpServer();
		ftpContext = new DefaultFtpContext();
		DefaultFtpContext defaultFtpContext = (DefaultFtpContext)ftpContext;
		Map<String,FtpServerListener> defaultListenerMap = createListenerMap();
		defaultFtpContext.setListenerMap(defaultListenerMap);
		defaultFtpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
	
	private Map<String,FtpServerListener> createListenerMap(){
		Map<String,FtpServerListener> listenerMap = new HashMap<String,FtpServerListener>();
		FtpServerListener defaultServerListener = new DefaultFtpServerListener();
		listenerMap.put("default", defaultServerListener);
		return listenerMap;
	}

	public static FtpContext getFtpContext() {
		return ftpContext;
	}
}
