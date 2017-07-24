package com.orange.ftpserver.command.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
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
		String userName = commandParameter[0];
		if(StringUtils.isNotBlank(userName)){
			List<IFtpUser> ftpUserList = ftpSession.getFtpContext().getUserManager().getUsers();
			if(!checkUserContains(ftpUserList,userName)){
				throw new FtpCommandException("230");
			}
		}else
			throw new FtpCommandException("332");
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
}
