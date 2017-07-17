package com.orange.ftpserver.context;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.listener.AbstractFtpServerListener;
import com.orange.ftpserver.server.IFtpServer;
import com.orange.ftpserver.user.IUserManager;

public final class DefaultFtpContext implements IFtpContext {
	private Map<String, AbstractFtpServerListener> serverListenerMap =new HashMap<String,AbstractFtpServerListener>();
	private Map<String,IFtpSession> sessionMap = new HashMap<String,IFtpSession>();
	private IUserManager userManager;
	private IFtpServer ftpServer;
	
	@Override
	public IUserManager getUserManager() {
		return userManager;
	}
	
	public void setUserManager(IUserManager userManager){
		this.userManager = userManager;
	}
	
	@Override
	public Map<String, AbstractFtpServerListener> getListenerMap() {
		return serverListenerMap;
	}
	
	public void setListenerMap(Map<String, AbstractFtpServerListener> serverListenerMap){
		this.serverListenerMap = serverListenerMap;
	}

	@Override
	public IFtpServer getFtpServer() {
		return ftpServer;
	}
	
	public void setFtpServer(IFtpServer ftpServer){
		this.ftpServer = ftpServer;
	}
	
	public synchronized void putSession2Map(String sessionId,IFtpSession ftpSession){
		if(!sessionMap.keySet().contains(sessionId)){
			sessionMap.put(sessionId, ftpSession);
		}
	}
	
	public IFtpSession getSession(String sessionId){
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
