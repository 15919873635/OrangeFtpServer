package com.orange.ftpserver.user;

import java.util.List;

public interface UserManager {
	public void saveUser(FtpUser user);
	public List<FtpUser> getUsers();
}
