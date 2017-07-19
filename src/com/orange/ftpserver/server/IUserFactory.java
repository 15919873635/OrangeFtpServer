package com.orange.ftpserver.server;

import com.orange.ftpserver.user.IFtpUser;

public interface IUserFactory {
	public IFtpUser createUser();
}
