package com.orange.ftpserver.command.impl;

import java.util.List;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.user.BaseUser;
import com.orange.ftpserver.user.IFtpUser;

/**
 * 指定用户口令，该命令必须跟在登录用户名命令之后
 * @author lining
 *
 */
public class PASS extends AbstractFtpCommand{
	
	public PASS(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.PASS, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		BaseUser user = (BaseUser)ftpSession.getUser();
		String userName = user.getUserName();
		String password = commandParameter[0];
		List<IFtpUser> ftpUserList = ftpSession.getFtpContext().getUserManager().getUsers();
		if(!checkPassword(ftpUserList,userName,password))
			throw new FtpCommandException("331");
		else
			user.setUserPassword(password);
	}
	
	private boolean checkPassword(List<IFtpUser> ftpUserList,String userName,String password){
		boolean correct = false;
		if(ftpUserList != null && ftpUserList.size() > 0){
			for(IFtpUser ftpUser : ftpUserList){
				if(ftpUser.getUserName().equals(userName)){
					if((ftpUser.getUserName() == null && password == null) 
							|| ftpUser.getUserName().equals(password))
						correct = true;
					break;
				}
			}
		}
		return correct;
	}
}
