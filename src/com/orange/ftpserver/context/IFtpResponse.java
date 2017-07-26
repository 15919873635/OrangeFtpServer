package com.orange.ftpserver.context;

public interface IFtpResponse {
	
	/**
	 * 
	 * @return
	 */
	IFtpSession getSession();
	
	/**
	 * this response parameters
	 * 
	 * @return parameters array
	 */
	String[] getParameters();
	
    /**
     * The reply code
     * 
     * @return The reply code
     */
    int getCode();

    /**
     * The reply message, might be multiple lines
     * 
     * @return The reply message
     */
    String getMessage();
    
    /**
     * Returns the timestamp (in milliseconds since the epoch time) when this 
     * reply was sent. 
     * 
     * @return the timestamp (in milliseconds since the epoch time) when this 
     * reply was sent.
     */
    long getSentTime();
    
    /**
     * Must implement toString to format the reply as described in the RFC. Most
     * important is the handling of multi-line replies.
     * 
     * @return The formated reply
     */
    String toString();
    
    /**
     * Tells whether or not this reply indicates a positive completion. 
     * @return <code>true</code>, if this reply is a positive completion or 
     * positive intermediate reply; <code>false</code>, otherwise.  
     */
    boolean isPositive();
    
    public enum ReplyMessage{
    	REPLY_110_RESTART_MARKER_REPLY(110,"110 Restart marker reply."),
    	
    	REPLY_120_SERVICE_READY_IN_NNN_MINUTES(120,"120 Service ready in nnn minutes."),
    	
    	REPLY_125_DATA_CONNECTION_ALREADY_OPEN(125,"125 Data connection already open; transfer starting."),
    	
    	REPLY_150_FILE_STATUS_OKAY(150,"150 File status okay; about to open data connection."),
    	
    	REPLY_200_COMMAND_OKAY(200,"200 Command okay."),
    	
    	REPLY_202_COMMAND_NOT_IMPLEMENTED(202,"202 Command not implemented, superfluous at this site."),
    	
    	REPLY_211_SYSTEM_STATUS_REPLY(211,"211 System status, or system help reply."),
    	
    	REPLY_212_DIRECTORY_STATUS(212,"212 Directory status."),
    	
    	REPLY_213_FILE_STATUS(213,"213 {0}"),
    	
    	REPLY_214_HELP_MESSAGE(214,"214 Help message."),
    	
    	REPLY_215_NAME_SYSTEM_TYPE(215,"215 sysname={0},sysArch={1},sysVer={2}"),
    	
    	REPLY_220_SERVICE_READY(220,"220 Service ready for new user."),
    	
    	REPLY_221_CLOSING_CONTROL_CONNECTION(221,"Service closing control connection. Logged out if appropriate."),
    	
    	REPLY_225_DATA_CONNECTION_OPEN_NO_TRANSFER_IN_PROGRESS(225,"225 Data connection open; no transfer in progress."),
    	
    	REPLY_226_CLOSING_DATA_CONNECTION(226,"226 Closing data connection."),
    	
    	REPLY_227_ENTERING_PASSIVE_MODE(227,"227 Entering Passive Mode (h1,h2,h3,h4,p1,p2)."),
    	
    	REPLY_230_USER_LOGGED_IN(230,"230 User logged in, proceed."),
    	
    	REPLY_250_REQUESTED_FILE_ACTION_OKAY(250,"250 Requested file action okay, completed."),
    	
    	REPLY_257_PATHNAME_CREATED(257,"257 {0} created."),
    	
    	REPLY_331_USER_NAME_OKAY_NEED_PASSWORD(331,"331 User name okay, need password."),
    	
    	REPLY_332_NEED_ACCOUNT_FOR_LOGIN(332,"332 Need account for login."),
    	
    	REPLY_350_REQUESTED_FILE_ACTION_PENDING_FURTHER_INFORMATION(350,"350 Requested file action pending further information."),
    	
    	REPLY_421_SERVICE_NOT_AVAILABLE_CLOSING_CONTROL_CONNECTION(421,"421 Service not available, closing control connection."),
    	
    	REPLY_425_CANT_OPEN_DATA_CONNECTION(425,"425 Can't open data connection."),
    	
    	REPLY_426_CONNECTION_CLOSED_TRANSFER_ABORTED(426,"426 Connection closed; transfer aborted."),
    	
    	REPLY_450_REQUESTED_FILE_ACTION_NOT_TAKEN(450,"450 Requested file action not taken."),
    	
    	REPLY_451_REQUESTED_ACTION_ABORTED(451,"451 Requested action aborted."),
    	
    	REPLY_452_REQUESTED_ACTION_NOT_TAKEN(452,"452 Requested action not taken."),
    	
    	REPLY_500_SYNTAX_ERROR_COMMAND_UNRECOGNIZED(500,"500 Syntax error, command unrecognized."),
    	
    	REPLY_501_SYNTAX_ERROR_IN_PARAMETERS_OR_ARGUMENTS(501,"501 Syntax error in parameters or arguments."),
    	
    	REPLY_502_COMMAND_NOT_IMPLEMENTED(502,"502 Command not implemented."),
    	
    	REPLY_503_BAD_SEQUENCE_OF_COMMANDS(503,"503 Bad sequence of commands."),
    	
    	REPLY_504_COMMAND_NOT_IMPLEMENTED_FOR_THAT_PARAMETER(504,"504 Command not implemented for that parameter."),
    	
    	REPLY_530_NOT_LOGGED_IN(530,"530 Not logged in."),
    	
    	REPLY_532_NEED_ACCOUNT_FOR_STORING_FILES(532,"532 Need account for storing files."),
    	
    	REPLY_550_REQUESTED_ACTION_NOT_TAKEN(550,"550 Requested action not taken."),
    	
    	REPLY_551_REQUESTED_ACTION_ABORTED_PAGE_TYPE_UNKNOWN(551,"551 Requested action aborted: page type unknown."),
    	
    	REPLY_552_REQUESTED_FILE_ACTION_ABORTED_EXCEEDED_STORAGE(552,"552 Requested file action aborted exceeded storage."),
    	
    	REPLY_553_REQUESTED_ACTION_NOT_TAKEN_FILE_NAME_NOT_ALLOWED(553,"553 Requested action not taken. File name not allowed.");
    	
    	private int code;
    	private String message;
    	
    	private ReplyMessage(int code,String message){
    		this.code = code;
    		this.message = message;
    	}
    	
    	public int getCode(){
    		return code;
    	}
    	
    	public String getMessage(){
    		return message;
    	}
    }
}
