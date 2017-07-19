package com.orange.ftpserver.user;

import java.io.File;

public interface IUserPropertyFactory extends IUserFactory{

	public void init(File userPropertyFile);
}
