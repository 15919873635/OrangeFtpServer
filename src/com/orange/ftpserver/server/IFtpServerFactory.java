package com.orange.ftpserver.server;

import com.orange.ftpserver.context.IFtpContext;

public interface IFtpServerFactory {
	public IFtpServer createServer();
	public IFtpContext getFtpContext();
}
