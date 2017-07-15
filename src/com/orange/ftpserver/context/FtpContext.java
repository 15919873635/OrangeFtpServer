package com.orange.ftpserver.context;

import java.util.Map;

import com.orange.ftpserver.listener.FtpServerListener;
import com.orange.ftpserver.server.FtpServer;
import com.orange.ftpserver.user.UserManager;

public interface FtpContext {
	UserManager getUserManager();
	Map<String,FtpServerListener> getListenerMap();
	FtpServer getFtpServer();
}
