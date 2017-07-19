package com.orange.ftpserver.user;

public class DefaultUserFactory implements IUserFactory {

	@Override
	public IFtpUser createUser() {
		return new BaseUser();
	}
}
