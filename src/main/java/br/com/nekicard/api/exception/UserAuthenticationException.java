package br.com.nekicard.api.exception;

public class UserAuthenticationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserAuthenticationException(String message, Exception e) {
		super(message, e);
	}
}
