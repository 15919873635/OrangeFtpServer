package com.orange.ftpserver.server;

import com.orange.ftpserver.user.BaseUser;
import com.orange.ftpserver.user.IFtpUser;

public class DefaultUserFactory implements IUserFactory {

	@Override
	public IFtpUser createUser() {
		return new BaseUser();
	}
}
