package com.orange.ftpserver.context;


public interface FtpRequest {
	FtpSession getSession();
	FtpCommand getFtpCommand();
}
