package com.orange.ftpserver.server;

public class DefaultSafeFtpServerFactory extends AbstractFtpServerFactory{

	public DefaultSafeFtpServerFactory(){
		super();
	}
	
	@Override
	public IFtpServer createServer() {
		IFtpServer ftpServer = null;
		if(serverPort == 0)
			ftpServer = new DefaultSafeFtpServer(ftpContext);
		else
			ftpServer = new DefaultSafeFtpServer(ftpContext,serverPort);
		DefaultSafeFtpServer defaultSafeFtpServer = (DefaultSafeFtpServer)ftpServer;
		defaultSafeFtpServer.setSafeMode(safeMode);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}

	@Override
	public IFtpServer createServer(int serverPort) {
		IFtpServer ftpServer = new DefaultSafeFtpServer(ftpContext,serverPort);
		DefaultSafeFtpServer defaultSafeFtpServer = (DefaultSafeFtpServer)ftpServer;
		defaultSafeFtpServer.setSafeMode(safeMode);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
}
