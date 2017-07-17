package com.orange.ftpserver.listener;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.consts.ServerConstant;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

public final class DefaultFtpServerListener extends AbstractFtpServerListener{

	@Override
	public void beforeRmdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onRmdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterRmdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeStore(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onStore(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterStore(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeAppend(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onAppend(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterAppend(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeClose(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onClose(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterClose(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeMkdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onMkdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterMkdir(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void beforeDelete(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void onDelete(IFtpSession ftpSession) throws FtpCommandException {
		
	}

	@Override
	public void afterDelete(IFtpSession ftpSession) throws FtpCommandException {
		
	}
	
	public void onOpen(IFtpSession ftpSession) throws FtpCommandException {
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
