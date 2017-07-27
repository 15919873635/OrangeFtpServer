package com.orange.ftpserver.server;

public final class DefaultServerFactory extends AbstractFtpServerFactory{
	
	public DefaultServerFactory(){
		super();
	}
	
	@Override
	public IFtpServer createServer() {
		IFtpServer ftpServer = null;
		if(serverPort == 0)
			ftpServer = new DefaultFtpServer(ftpContext);
		else
			ftpServer = new DefaultFtpServer(ftpContext,serverPort);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
	
	@Override
	public IFtpServer createServer(int serverPort) {
		IFtpServer ftpServer = new DefaultFtpServer(ftpContext,serverPort);
		ftpContext.setFtpServer(ftpServer);
		return ftpServer;
	}
}
