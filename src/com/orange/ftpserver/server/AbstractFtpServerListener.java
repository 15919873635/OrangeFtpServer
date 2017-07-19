package com.orange.ftpserver.server;

import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public abstract class AbstractFtpServerListener {

	public abstract void beforeRmdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterRmdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeMkdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterMkdir(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeStore(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterStore(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeAppend(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterAppend(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeDelete(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterDelete(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void beforeClose(IFtpSession ftpSession) throws FtpCommandException;
	public abstract void afterClose(IFtpSession ftpSession) throws FtpCommandException;
	
}
