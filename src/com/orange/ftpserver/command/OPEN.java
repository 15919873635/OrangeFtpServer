package com.orange.ftpserver.command;

import org.apache.commons.lang.StringUtils;

import com.orange.ftpserver.consts.ServerConstant;
import com.orange.ftpserver.context.AbstractFtpCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.FtpRequestCommand;
import com.orange.ftpserver.context.FtpSession;

public class OPEN extends AbstractFtpCommand{
	
	public OPEN(FtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.OPEN,parameters);
	}
	
	@Override
	public void exec() {
		if(super.commandParameter.length == 1 && hostAndPort(super.commandParameter[0])){
			setExecResultCode(220);
		}else
			setExecResultCode(501);
	}
	
	private boolean hostAndPort(String address){
		boolean isRightAddress = false;
		if(address.contains(":")){
			String[] addSplit = address.split(":");
			if(address.length() == 2 
					&& addSplit[0].matches(ServerConstant.IP_VERIFICATION)
					&& StringUtils.isNumeric(addSplit[1])){
				isRightAddress = true;
			}
		}
		return isRightAddress;
	}
	
	private void setExecResultCode(int code){
		DefaultFtpResponse ftpResponse = (DefaultFtpResponse)super.ftpSession.getResponse();
		ftpResponse.setCode(code);
	}
}
