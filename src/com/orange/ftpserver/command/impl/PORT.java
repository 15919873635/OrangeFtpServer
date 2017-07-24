package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.consts.ServerConstant;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;

/**
 * ���������FTP���������ͻ��˼����Ķ˿ں���address����FTP��������������ģʽ
 * @author lining
 *
 */
public class PORT extends AbstractFtpCommand{
	
	public PORT(IFtpSession ftpSession, String[] parameters) {
		super(ftpSession, FtpRequestCommand.PORT, parameters);
	}

	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		String address = commandParameter[0];
		String[] addSplit = address.split(":");
		DefaultFtpStaticData ftpStatisticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		ftpStatisticData.setMode(ServerConstant.MODE_PASV);
		ftpStatisticData.setHost(addSplit[0]);
		ftpStatisticData.setPort(Integer.parseInt(addSplit[1]));
	}
}
