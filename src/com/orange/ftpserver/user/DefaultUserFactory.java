package com.orange.ftpserver.user;

public class DefaultUserFactory implements IUserFactory {

	@Override
	public IFtpUser createUser() {
		BaseUser user = new BaseUser();
		user.setEnable(USER_ENABLE);
		user.setHomedirectory(USER_HOMEDIRECTORY);
		user.setMaxIdleTime(MAX_IDLE_TIME);
		user.setMaxPerFileSize(MAX_PER_FILE_SIZE);
		user.setUserName(USER_NAME);
		user.setUserPassword(USER_PASSWORD);
		return user;
	}
}
