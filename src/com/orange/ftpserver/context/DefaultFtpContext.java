package com.orange.ftpserver.context;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.listener.FtpServerListener;
import com.orange.ftpserver.server.FtpServer;
import com.orange.ftpserver.user.UserManager;

public class DefaultFtpContext implements FtpContext {
	private Map<String, FtpServerListener> serverListenerMap =new HashMap<String,FtpServerListener>();
	private Map<String,FtpSession> sessionMap = new HashMap<String,FtpSession>();
	private UserManager userManager;
	private FtpServer ftpServer;
	
	@Override
	public UserManager getUserManager() {
		return userManager;
	}
	
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	
	@Override
	public Map<String, FtpServerListener> getListenerMap() {
		return serverListenerMap;
	}
	
	public void setListenerMap(Map<String, FtpServerListener> serverListenerMap){
		this.serverListenerMap = serverListenerMap;
	}

	@Override
	public FtpServer getFtpServer() {
		return ftpServer;
	}
	
	public void setFtpServer(FtpServer ftpServer){
		this.ftpServer = ftpServer;
	}
	
	public synchronized void putSession2Map(String sessionId,FtpSession ftpSession){
		if(!sessionMap.keySet().contains(sessionId)){
			sessionMap.put(sessionId, ftpSession);
		}
	}
	
	public FtpSession getSession(String sessionId){
		if(sessionMap != null)
			return sessionMap.get(sessionId);
		else
			return null;
	}
	
	public synchronized void deleteSession(String sessionId){
		if(sessionMap.keySet().contains(sessionId)){
			sessionMap.remove(sessionId);
		}
	}
}
