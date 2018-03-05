package de.cultuzz.roomrateinfofetcher.exceptions;

public class RoomRateFetcherInfoException extends RuntimeException{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String errorMsg;
	
	public RoomRateFetcherInfoException(String errorMsg){
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
