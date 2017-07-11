package com.orange.ftpserver.enums;

public enum FtpCommond {
	CWD("cws"),
	MLD("mld"),
	CLOSE("close"),
	OPEN("open");
	
	private String name;
	
	private FtpCommond(String name){
		this.name = name;
	}
	
	public FtpCommond nameOf(String name){
		FtpCommond commond = null;
		FtpCommond[] values = FtpCommond.values();
		for(FtpCommond val : values){
			if(val.valueOf().equals(name)){
				commond =  val;break;
			}
		}
		return commond;
	}
	
	public String valueOf(){
		return this.name;
	}
}
