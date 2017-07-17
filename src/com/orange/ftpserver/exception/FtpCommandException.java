package com.orange.ftpserver.exception;

public final class FtpCommandException extends Exception implements IFtpException{

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
