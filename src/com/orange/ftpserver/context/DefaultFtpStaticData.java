package com.orange.ftpserver.context;

public class DefaultFtpStaticData implements IFtpStaticData {
	private IFtpSession ftpSession;
	/**
	 * 当前工作路径
	 */
	private String currentWorkPath;
	
	/**
	 * 数据传输模式(主动连接或是被动连接)
	 */
	private String mode;
	
	/**
	 * 数据连接的地址
	 */
	private String host;
	
	/**
	 * 数据连接的端口号
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
