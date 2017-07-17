package com.orange.ftpserver.context;

import java.util.Map;

import com.orange.ftpserver.listener.IFtpServerListener;
import com.orange.ftpserver.server.IFtpServer;
import com.orange.ftpserver.user.IUserManager;

public interface IFtpContext {
	IUserManager getUserManager();
	Map<String,IFtpServerListener> getListenerMap();
	IFtpServer getFtpServer();
}
