package com.orange.ftpserver.server;

public class DefaultSafeFtpServerFactory extends AbstractFtpServerFactory{

	@Override
	public IFtpServer createServer() {
		IFtpServer ftpServer = null;
		if(serverPort == 0)
			ftpServer = new DefaultSafeFtpServer(ftpContext);
		else
			ftpServer = new DefaultSafeFtpServer(ftpContext,serverPort);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}

	@Override
	public IFtpServer createServer(int serverPort) {
		IFtpServer ftpServer = new DefaultSafeFtpServer(ftpContext,serverPort);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
}
