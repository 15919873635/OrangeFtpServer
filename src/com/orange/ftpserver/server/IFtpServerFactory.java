package com.orange.ftpserver.server;

import com.orange.ftpserver.context.IFtpContext;

public interface IFtpServerFactory {
	public void setServerPort(int serverPort);
	public IFtpServer createServer();
	public IFtpServer createServer(int serverPort);
	public IFtpContext getFtpContext();
}
