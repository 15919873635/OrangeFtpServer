package com.orange.ftpserver.listener;

import com.orange.ftpserver.context.FtpRequest;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public interface FtpServerListener {
	void beforeCommond(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void afterCommond(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void beforeRmdir(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void onRmdir(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void afterRmdir(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void beforeStore(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void onStore(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void afterStore(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void beforeAppend(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void onAppend(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void afterAppend(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void beforeClose(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void onClose(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
	void afterClose(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException;
}
