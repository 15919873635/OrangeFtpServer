package com.orange.ftpserver.context;

public interface IFtpStaticData {
	IFtpSession getSession();
	String getCWP();
	String getMode();
	String getHost();
	int getPort();
}
