package com.orange.ftpserver.user;

public interface IUserFactory {
	public final static String USER_HOMEDIRECTORY = "/";
	public final static String USER_NAME = "admin";
	public final static String USER_PASSWORD = "admin";
	public final static long MAX_IDLE_TIME = 0;
	public final static long MAX_PER_FILE_SIZE = 0;
	public final static long MAX_USER_SIZE = 0;
	public final static boolean USER_ENABLE = true;
	public IFtpUser createUser();
}
