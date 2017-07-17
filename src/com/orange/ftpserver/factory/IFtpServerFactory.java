package com.orange.ftpserver.factory;

import com.orange.ftpserver.server.IFtpServer;

public interface IFtpServerFactory {
	public IFtpServer createServer();
}
