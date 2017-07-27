package com.orange.ftpserver.server;

import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.IFtpContext;

public abstract class AbstractFtpServerFactory implements IFtpServerFactory{
	
	protected DefaultFtpContext ftpContext = new DefaultFtpContext();
	protected int serverPort = 0;
	
	@Override
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	
	@Override
	public IFtpContext getFtpContext() {
		return ftpContext;
	}
}
