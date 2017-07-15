package com.orange.ftpserver.listener;

import com.orange.ftpserver.context.CommandResult;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public interface FtpServerListener {
	CommandResult beforeCommond(FtpSession ftpSession) throws FtpCommandException;
	CommandResult afterCommond(FtpSession ftpSession) throws FtpCommandException;
	void beforeRmdir(FtpSession ftpSession) throws FtpCommandException;
	void onRmdir(FtpSession ftpSession) throws FtpCommandException;
	void afterRmdir(FtpSession ftpSession) throws FtpCommandException;
	void beforeMkdir(FtpSession ftpSession) throws FtpCommandException;
	void onMkdir(FtpSession ftpSession) throws FtpCommandException;
	void afterMkdir(FtpSession ftpSession) throws FtpCommandException;
	void beforeStore(FtpSession ftpSession) throws FtpCommandException;
	void onStore(FtpSession ftpSession) throws FtpCommandException;
	void afterStore(FtpSession ftpSession) throws FtpCommandException;
	void beforeAppend(FtpSession ftpSession) throws FtpCommandException;
	void onAppend(FtpSession ftpSession) throws FtpCommandException;
	void afterAppend(FtpSession ftpSession) throws FtpCommandException;
	void beforeDelete(FtpSession ftpSession) throws FtpCommandException;
	void onDelete(FtpSession ftpSession) throws FtpCommandException;
	void afterDelete(FtpSession ftpSession) throws FtpCommandException;
	void beforeClose(FtpSession ftpSession) throws FtpCommandException;
	void onClose(FtpSession ftpSession) throws FtpCommandException;
	void afterClose(FtpSession ftpSession) throws FtpCommandException;
}
