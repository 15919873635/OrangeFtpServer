package com.orange.ftpserver.context;

public class DefaultFtpStaticData implements IFtpStaticData {
	private IFtpSession ftpSession;
	/**
	 * ��ǰ����·��
	 */
	private String currentWorkPath;
	
	public DefaultFtpStaticData(IFtpSession ftpSession){
		this.ftpSession = ftpSession;
	}
	
	@Override
	public IFtpSession getSession() {
		return ftpSession;
	}

	@Override
	public String getCWP() {
		return currentWorkPath;
	}
}
