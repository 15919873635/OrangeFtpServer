package com.orange.ftpserver.user;

import java.util.ArrayList;
import java.util.List;

public final class DefaultUserManager implements UserManager {
	private List<FtpUser> ftpUserList;
	
	public DefaultUserManager(){
		ftpUserList = new ArrayList<FtpUser>();
	}
	@Override
	public void saveUser(FtpUser user) {
		ftpUserList.add(user);
	}

	@Override
	public List<FtpUser> getUsers() {
		return ftpUserList;
	}
}
