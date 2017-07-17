package com.orange.ftpserver.user;

import java.util.List;

import com.orange.ftpserver.author.Authority;

public interface IFtpUser {
	public String getUserName();
	public String getUserPassword();
	public String getHomedirectory();
	public List<Authority> getAuthorities();
	public long getMaxIdleTime();
	public long getMaxPerFileSize();
	public long getMaxUserSize();
	public boolean isEnable();
}
