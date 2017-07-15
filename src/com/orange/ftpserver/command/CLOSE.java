package com.orange.ftpserver.command;

import com.orange.ftpserver.context.AbstractFtpCommand;
import com.orange.ftpserver.context.DefaultFtpContext;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.factory.DefaultServerFactory;

public class CLOSE extends AbstractFtpCommand{

	public CLOSE(FtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.CLOSE, parameters);
	}

	@Override
	public void exec() {
		DefaultFtpContext ftpContext = (DefaultFtpContext)DefaultServerFactory.getFtpContext();
		ftpContext.deleteSession(ftpSession.getSessionId());
		super.ftpSession = null;
	}
}
