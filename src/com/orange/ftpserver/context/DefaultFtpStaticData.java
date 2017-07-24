package com.orange.ftpserver.context;

public class DefaultFtpStaticData implements IFtpStaticData {
	private IFtpSession ftpSession;
	/**
	 * ��ǰ����·��
	 */
	private String currentWorkPath;
	
	/**
	 * ���ݴ���ģʽ(�������ӻ��Ǳ�������)
	 */
	private String mode;
	
	/**
	 * �������ӵĵ�ַ
	 */
	private String host;
	
	/**
	 * �������ӵĶ˿ں�
	 */
	private int port;
	
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
	
	public void setCWP(String currentWorkPath){
		this.currentWorkPath = currentWorkPath;
	}

	public void setMode(String mode){
		this.mode = mode;
	}
	
	@Override
	public String getMode() {
		return mode;
	}

	public void setHost(String host){
		this.host = host;
	}
	
	@Override
	public String getHost() {
		return host;
	}

	public void setPort(int port){
		this.port = port;
	}
	
	@Override
	public int getPort() {
		return port;
	}
}
