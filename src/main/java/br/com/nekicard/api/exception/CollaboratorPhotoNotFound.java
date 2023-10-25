package br.com.nekicard.api.exception;

public class CollaboratorPhotoNotFound extends RuntimeException {

	private static final long serialVersionUID = 6681868560968065805L;

	public CollaboratorPhotoNotFound(String message) {
		super(message);
	}
}
