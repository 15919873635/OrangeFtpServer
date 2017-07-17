package com.orange.ftpserver.context;

import java.util.Map;

import com.orange.ftpserver.listener.AbstractFtpServerListener;
import com.orange.ftpserver.server.IFtpServer;
import com.orange.ftpserver.user.IUserManager;

public interface IFtpContext {
	IUserManager getUserManager();
	Map<String,AbstractFtpServerListener> getListenerMap();
	IFtpServer getFtpServer();
}
