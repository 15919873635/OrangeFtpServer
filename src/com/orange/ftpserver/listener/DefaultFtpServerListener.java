package com.orange.ftpserver.listener;

import com.orange.ftpserver.context.FtpRequest;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public class DefaultFtpServerListener implements FtpServerListener{

	@Override
	public void beforeCommond(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void afterCommond(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void beforeRmdir(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void onRmdir(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void afterRmdir(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void beforeStore(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void onStore(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void afterStore(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void beforeAppend(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void onAppend(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void afterAppend(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void beforeClose(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void onClose(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}

	@Override
	public void afterClose(FtpSession ftpSession,FtpRequest ftpRequest) throws FtpCommandException {
		
	}
	
}
