package com.orange.ftpserver.listener;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.consts.ServerConstant;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.FtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public final class DefaultFtpServerListener extends AbstractFtpServerListener{

	@Override
	public void beforeRmdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onRmdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterRmdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeStore(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onStore(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterStore(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeAppend(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onAppend(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterAppend(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeClose(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onClose(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterClose(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeMkdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onMkdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterMkdir(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeDelete(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onDelete(FtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterDelete(FtpSession ftpSession) throws FtpCommandException {
		
	}
	
	public void onOpen(FtpSession ftpSession) throws FtpCommandException {
		String[] parameters = ftpSession.getRequest().getFtpCommand().getParameters();
		if(parameters.length == 1){
			String address = parameters[0];
			if(address.contains(":")){
				String[] addSplit = address.split(":");
				if(addSplit.length == 2
						&& addSplit[0].matches(ServerConstant.IP_VERIFICATION)
						&& StringUtils.isNumeric(addSplit[1])){
					DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
					ftpResponse.setCode(220);
				} else
					throw new FtpCommandException("501");
			} else
				throw new FtpCommandException("501");
		} else
			throw new FtpCommandException("501");
	}
}
