package com.orange.ftpserver.context;

import com.orange.ftpserver.command.IFtpCommand;

public interface IFtpRequest {
	IFtpSession getSession();
	IFtpCommand getFtpCommand();
}
