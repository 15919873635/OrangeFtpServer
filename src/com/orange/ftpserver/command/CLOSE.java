package com.orange.ftpserver.command;

import com.orange.ftpserver.context.AbstractFtpCommand;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.util.FtpSessionUtil;

public class CLOSE extends AbstractFtpCommand{

	public CLOSE(FtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.CLOSE, parameters);
	}

	@Override
	public void exec() {
		FtpSessionUtil.deleteSession("12345");
		super.ftpSession = null;
	}
}
