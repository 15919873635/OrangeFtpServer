package com.orange.ftpserver.listener;

import com.orange.ftpserver.exception.FtpCommandException;

public interface FtpServerListener {
	void beforeCommond() throws FtpCommandException;
	void afterCommond() throws FtpCommandException;
	void beforeRmdir() throws FtpCommandException;
	void onRmdir() throws FtpCommandException;
	void afterRmdir() throws FtpCommandException;
}
