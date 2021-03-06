package com.orange.ftpserver.server;

import java.util.Map;

import com.orange.ftpserver.listener.FtpServerListener;
import com.orange.ftpserver.user.UserManager;

public interface FtpServer {
	public Map<String, FtpServerListener> getServerListeners();
	public UserManager getUserManager();
	public void start();
	public void close();
}
