package com.orange.ftpserver.server;

import java.util.List;
import java.util.Map;

import com.orange.ftpserver.listener.FtpServerListener;
import com.orange.ftpserver.user.FtpUser;
import com.orange.ftpserver.user.UserManager;

public class DefaultFtpServer implements FtpServer {
	
	private Map<String,FtpServerListener> serverListenerMap;
	private UserManager userManager;
	
	@Override
	public void start() {
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public List<FtpUser> getUsers() {
		return null;
	}
	
	public void setServerListeners(Map<String, FtpServerListener> serverListenerMap){
		this.serverListenerMap = serverListenerMap;
	}
	
	@Override
	public Map<String, FtpServerListener> getServerListeners() {
		return serverListenerMap;
	}

	@Override
	public UserManager getUserManager() {
		return userManager;
	}
}