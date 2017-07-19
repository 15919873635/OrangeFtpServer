package com.orange.ftpserver.context;

public class DefaultFtpStaticData implements IFtpStaticData {
	private IFtpSession ftpSession;
	
	public DefaultFtpStaticData(IFtpSession ftpSession){
		this.ftpSession = ftpSession;
	}
	
	@Override
	public IFtpSession getSession() {
		return ftpSession;
	}
}
