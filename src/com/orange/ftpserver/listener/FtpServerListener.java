package com.orange.ftpserver.listener;

import com.orange.ftpserver.exception.FtpCommandException;

public interface FtpServerListener {
	void beforeCommond() throws FtpCommandException;
	void afterCommond() throws FtpCommandException;
	void beforeRmdir() throws FtpCommandException;
	void onRmdir() throws FtpCommandException;
	void afterRmdir() throws FtpCommandException;
	void beforeStore() throws FtpCommandException;
	void onStore() throws FtpCommandException;
	void afterStore() throws FtpCommandException;
	void beforeAppend() throws FtpCommandException;
	void onAppend() throws FtpCommandException;
	void afterAppend() throws FtpCommandException;
	void beforeClose() throws FtpCommandException;
	void onClose() throws FtpCommandException;
	void afterClose() throws FtpCommandException;
}
