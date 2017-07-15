package com.orange.ftpserver.util;

public class FtpSessionUtil {
	
	public static boolean hasEOL(String message){
		if(message.endsWith("\r\n") 
				|| message.endsWith("\r") 
				|| (!message.endsWith("\r\n") && message.endsWith("\n")))
			return true;
		else
			return false;
	}
}
