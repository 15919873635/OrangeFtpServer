package com.orange.ftpserver.user;

import java.util.List;

import com.orange.ftpserver.author.Authority;

public abstract class AbstractUser implements FtpUser{
	private List<Authority> authorityList;

	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}
}
