package com.orange.ftpserver.user;

import java.util.List;

import com.orange.ftpserver.author.Authority;

public class BaseUser extends AbstractUser{
	private String userName;
	private String userPassword;
	private String homedirectory;
	private List<Authority> authorities;
	private long maxIdleTime;
	private long maxPerFileSize;
	private long maxUserSize;
	private boolean enable;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getHomedirectory() {
		return homedirectory;
	}
	public void setHomedirectory(String homedirectory) {
		this.homedirectory = homedirectory;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public long getMaxIdleTime() {
		return maxIdleTime;
	}
	public void setMaxIdleTime(long maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}
	public long getMaxPerFileSize() {
		return maxPerFileSize;
	}
	public void setMaxPerFileSize(long maxPerFileSize) {
		this.maxPerFileSize = maxPerFileSize;
	}
	public long getMaxUserSize() {
		return maxUserSize;
	}
	public void setMaxUserSize(long maxUserSize) {
		this.maxUserSize = maxUserSize;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
