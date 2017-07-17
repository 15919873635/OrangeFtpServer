package com.orange.ftpserver.user;

import java.util.ArrayList;
import java.util.List;

public final class DefaultUserManager implements IUserManager {
	private List<IFtpUser> ftpUserList;
	
	public DefaultUserManager(){
		ftpUserList = new ArrayList<IFtpUser>();
	}
	@Override
	public void saveUser(IFtpUser user) {
		ftpUserList.add(user);
	}

	@Override
	public List<IFtpUser> getUsers() {
		return ftpUserList;
	}
}
