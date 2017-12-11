package com.orange.ftpserver.server;

public interface IFtpServer {
	public void start();
	public void close();
	public int getServerPort();
	public String getSafeMode();
	public void startClientPort(int clientPort);
}
