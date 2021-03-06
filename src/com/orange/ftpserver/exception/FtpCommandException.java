package com.orange.ftpserver.exception;

public class FtpCommandException extends Exception implements FtpException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2315230829549506450L;
	
	public FtpCommandException() {
        super();
    }
	
	public FtpCommandException(String msg) {
        super(msg);
    }
	
	public FtpCommandException(Throwable throwable) {
        super(throwable.getMessage(),throwable);
    }
	
	public FtpCommandException(Throwable throwable,String msg) {
        super(msg,throwable);
    }
}
