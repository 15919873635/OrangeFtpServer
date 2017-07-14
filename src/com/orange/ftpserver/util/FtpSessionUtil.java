package com.orange.ftpserver.util;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.context.FtpSession;

public class FtpSessionUtil {
	private static Map<String,FtpSession> sessionMap = new HashMap<String,FtpSession>();
	
	public static synchronized void putSession2Map(String sessionId,FtpSession ftpSession){
		if(!sessionMap.keySet().contains(sessionId)){
			sessionMap.put(sessionId, ftpSession);
		}
	}
	
	public static FtpSession getSession(String sessionId){
		if(sessionMap != null)
			return sessionMap.get(sessionId);
		else
			return null;
	}
	
	public static synchronized void deleteSession(String sessionId){
		if(sessionMap.keySet().contains(sessionId)){
			sessionMap.remove(sessionId);
		}
	}
}
