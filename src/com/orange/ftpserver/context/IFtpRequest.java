package com.orange.ftpserver.context;


public interface IFtpRequest {
	IFtpSession getSession();
	IFtpCommand getFtpCommand();
}
