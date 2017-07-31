package com.orange.ftpserver.command.impl;

import java.io.File;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.orange.ftpserver.command.AbstractFtpCommand;
import com.orange.ftpserver.command.FtpRequestCommand;
import com.orange.ftpserver.context.DefaultFtpResponse;
import com.orange.ftpserver.context.DefaultFtpStaticData;
import com.orange.ftpserver.context.IFtpSession;
import com.orange.ftpserver.exception.FtpCommandException;
import com.orange.ftpserver.file.FtpFile;

/**
 * 如果是文件名列出文件信息，如果是目录则列出文件列表
 * @author lining
 *
 */
public class LIST extends AbstractFtpCommand{

	public LIST(IFtpSession ftpSession,String[] parameters){
		super(ftpSession,FtpRequestCommand.LIST,parameters);
	}
	
	@Override
	public void executCommand(IFtpSession ftpSession) throws FtpCommandException{
		String newWorkingDirectory = commandParameter[0];
		DefaultFtpStaticData ftpStaticData = (DefaultFtpStaticData)ftpSession.getFtpStaticData();
		File directory = new File(ftpStaticData.getCWP());
		if(directory.isDirectory()){
			String filesJson = "";
			File newDirectory = new File(ftpStaticData.getCWP() + newWorkingDirectory);
			if(newDirectory.isDirectory()){
				File[] files = newDirectory.listFiles();
				if(files != null && files.length > 0){
					for(File file: files){
						FtpFile ftpFile = new FtpFile();
						ftpFile.setFileName(file.getName());
						ftpFile.setFileSize(file.length());
						ftpFile.setModifyTime(file.lastModified());
						ftpFile.setUser(ftpSession.getUser().getUserName());
					}
				}
				filesJson = JSONArray.toJSONString(files);
			} else{
				FtpFile ftpFile = new FtpFile();
				ftpFile.setFileName(newDirectory.getName());
				ftpFile.setFileSize(newDirectory.length());
				ftpFile.setModifyTime(newDirectory.lastModified());
				ftpFile.setUser(ftpSession.getUser().getUserName());
				filesJson = JSONObject.toJSONString(ftpFile);
			}
			DefaultFtpResponse ftpResponse = (DefaultFtpResponse)ftpSession.getResponse();
			ftpResponse.setParameters(new String[]{filesJson});
		}
	}
}
