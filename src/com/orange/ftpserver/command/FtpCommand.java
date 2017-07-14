package com.orange.ftpserver.command;

public enum FtpCommand {
	/** This command tells the server to abort the previous FTP service command and
	 * any associated transfer of data. No action is to be taken if the previous
	 * command has been completed (including data transfer). The control connection
	 * is not to be closed by the server, but the data connection must be closed.
	 * Current implementation does not do anything. As here data transfers are not
	 * multi-threaded.
	 */
	ABOR("abor"),
	ACCT("acct"),
	APPE("appe"),
	AUTH("auth"),
	BLANK(""),
	CDUP("cdup"),
	CWD("cwd"),
	DELE("dele"),
	EPRT("eprt"),
	EPSV("epsv"),
	FEAT("feat"),
	HELP("help"),
	LIST("list"),
	MDTM("mdtm"),
	MFMT("mfmt"),
	MKD("mkd"),
	MLSD("mlsd"),
	MLST("mlst"),
	MODE("mode"),
	NLST("nlst"),
	NOOP("noop"),
	OPEN("open"),
	PASS("pass"),
	PASV("pasv"),
	PBSZ("pbsz"),
	PORT("port"),
	PWD("pwd"),
	QUIT("quit"),
	REIN("rein"),
	REST("rest"),
	RETR("retr"),
	RMD("rmd"),
	RNFR("rnfr"),
	RNTO("rnto"),
	SITE("site"),
	SIZE("size"),
	SITE_DESCUSER("site_descuser"),
	SITE_HELP("site_help"),
	SITE_STAT("site_stat"),
	SITE_WHO("site_who"),
	SITE_ZONE("site_zone"),
	SATA("sata"),
	STOR("stor"),
	STOU("stou"),
	STRU("stru"),
	SYST("syst"),
	USER("user");
	
	private String name;
	
	private FtpCommand(String name){
		this.name = name;
	}
	
	public static FtpCommand nameOf(String name){
		FtpCommand commond = FtpCommand.BLANK;
		FtpCommand[] values = FtpCommand.values();
		for(FtpCommand val : values){
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
