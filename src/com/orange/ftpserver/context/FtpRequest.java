package com.orange.ftpserver.context;

import com.orange.ftpserver.command.FtpRequestCommand;

public interface FtpRequest {
	FtpRequestCommand getCommand();
	FtpCommandParameter getParameters();
}
