package com.orange.ftpserver.factory;

import com.orange.ftpserver.server.FtpServer;

public interface FtpServerFactory {
	public FtpServer createServer();
}
