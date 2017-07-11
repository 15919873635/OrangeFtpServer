package com.orange.ftpserver.factory;

import com.orange.ftpserver.server.DefaultFtpServer;
import com.orange.ftpserver.server.FtpServer;

public class DefaultServerFactory extends AbstractFtpServerFactory{

	@Override
	public FtpServer createServer() {
		return new DefaultFtpServer();
	}
}
