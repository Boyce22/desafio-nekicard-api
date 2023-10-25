package br.com.nekicard.api.exception;

public class EmailExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 6681868560968065805L;

	public EmailExistsException(String message) {
		super(message);
	}
}
