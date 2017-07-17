package com.orange.ftpserver.user;

import java.util.List;

public interface IUserManager {
	public void saveUser(IFtpUser user);
	public List<IFtpUser> getUsers();
}
