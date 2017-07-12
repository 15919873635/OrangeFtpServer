package com.orange.ftpserver.context;

public interface FtpRequest {
	FtpContext getFtpContext();
	FtpSession getFtpSession();
}
