package com.github.xarmada.utilityset;

public class UtilityException extends RuntimeException {

	
	String reason;
	
	public UtilityException(String reason) {
		this.reason = reason;
		System.err.println("Z3R0 UtilitySet Exception: " + reason);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
