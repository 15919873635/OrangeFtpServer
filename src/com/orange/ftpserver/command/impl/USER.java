package com.orange.ftpserver.command.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.user.IFtpUser;

/**
 * 指定登录的用户名，以便服务器进行身份验证
 * @author lining
 *
 */
public final class USER extends AbstractFtpCommand{

	protected USER(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.USER, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		int responseCode = 220;
		String userName = commandParameter[0];
		String password = null;
		if(commandParameter.length > 1){
			password = commandParameter[1];
		}
		if(StringUtils.isNotBlank(userName)){
			List<IFtpUser> ftpUserList = ftpSession.getFtpContext().getUserManager().getUsers();
			if(checkUserContains(ftpUserList,userName)){
				if(!checkPassword(ftpUserList,userName,password))
					responseCode = 331;
			}else
				responseCode = 230;
		}
		DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
		ftpResponse.setCode(responseCode);
	}
	
	private boolean checkUserContains(List<IFtpUser> ftpUserList,String userName){
		boolean contains = false;
		if(ftpUserList != null && ftpUserList.size() > 0){
			for(IFtpUser ftpUser : ftpUserList){
				if(ftpUser.getUserName().equals(userName)){
					contains = true;
					break;
				}
			}
		}
		return contains;
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
