package com.orange.ftpserver.command.impl;

import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.consts.ServerConstant;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.server.IFtpServer;

/**
 * 该命令告诉FTP服务器，客户端监听的端口号是address，让FTP服务器采用主动模式
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
		ftpStatisticData.setMode(ServerConstant.MODE_PORT);
		ftpStatisticData.setHost(addSplit[0]);
		ftpStatisticData.setPort(Integer.parseInt(addSplit[1]));
		IFtpServer iFtpServer = super.getSession().getFtpContext().getFtpServer();
		iFtpServer.startClientPort(ftpStatisticData.getPort());
	}
}
