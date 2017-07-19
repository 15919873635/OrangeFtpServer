package com.orange.ftpserver.server;

import java.io.File;

public interface IUserPropertyFactory extends IUserFactory{

	public void init(File userPropertyFile);
}
