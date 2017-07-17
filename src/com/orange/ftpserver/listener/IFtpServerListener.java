package com.orange.ftpserver.listener;

import com.orange.ftpserver.context.CommandResult;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public interface IFtpServerListener {
	CommandResult beforeCommond(IFtpSession ftpSession) throws FtpCommandException;
	CommandResult afterCommond(IFtpSession ftpSession) throws FtpCommandException;
	void beforeRmdir(IFtpSession ftpSession) throws FtpCommandException;
	void onRmdir(IFtpSession ftpSession) throws FtpCommandException;
	void afterRmdir(IFtpSession ftpSession) throws FtpCommandException;
	void beforeMkdir(IFtpSession ftpSession) throws FtpCommandException;
	void onMkdir(IFtpSession ftpSession) throws FtpCommandException;
	void afterMkdir(IFtpSession ftpSession) throws FtpCommandException;
	void beforeStore(IFtpSession ftpSession) throws FtpCommandException;
	void onStore(IFtpSession ftpSession) throws FtpCommandException;
	void afterStore(IFtpSession ftpSession) throws FtpCommandException;
	void beforeAppend(IFtpSession ftpSession) throws FtpCommandException;
	void onAppend(IFtpSession ftpSession) throws FtpCommandException;
	void afterAppend(IFtpSession ftpSession) throws FtpCommandException;
	void beforeDelete(IFtpSession ftpSession) throws FtpCommandException;
	void onDelete(IFtpSession ftpSession) throws FtpCommandException;
	void afterDelete(IFtpSession ftpSession) throws FtpCommandException;
	void beforeClose(IFtpSession ftpSession) throws FtpCommandException;
	void onClose(IFtpSession ftpSession) throws FtpCommandException;
	void afterClose(IFtpSession ftpSession) throws FtpCommandException;
}
