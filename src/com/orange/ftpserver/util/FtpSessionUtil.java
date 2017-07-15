package com.orange.ftpserver.util;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.context.FtpSession;

public class FtpSessionUtil {
	private static Map<Integer,FtpSession> sessionMap = new HashMap<Integer,FtpSession>();
	
	public static synchronized void putSession2Map(Integer sessionId,FtpSession ftpSession){
		if(!sessionMap.keySet().contains(sessionId)){
			sessionMap.put(sessionId, ftpSession);
		}
	}
	
	public static FtpSession getSession(Integer sessionId){
		if(sessionMap != null)
			return sessionMap.get(sessionId);
		else
			return null;
	}
	
	public static synchronized void deleteSession(Integer sessionId){
		if(sessionMap.keySet().contains(sessionId)){
			sessionMap.remove(sessionId);
		}
	}
}
