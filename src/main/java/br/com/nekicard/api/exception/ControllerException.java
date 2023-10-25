package br.com.nekicard.api.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerException {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleErrorNotFound() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorValidationData>> handleBadRequest(MethodArgumentNotValidException exception) {
		var error = exception.getFieldErrors();
		return ResponseEntity.badRequest().body(error.stream().map(ErrorValidationData::new).toList());
	}

	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<ErrorValidationData> handleConflict(EmailExistsException exception) {
		var erro = "Duplicate email";
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ErrorValidationData(erro, exception.getMessage(), formatTime(LocalDateTime.now())));
	}
	
	@ExceptionHandler(CollaboratorPhotoNotFound.class)
	public ResponseEntity<ErrorValidationData> CollaboratorPhotoNotFound(EmailExistsException exception) {
		var erro = "No collaborator photo found.";
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorValidationData(erro, exception.getMessage(), formatTime(LocalDateTime.now())));
	}

	@ExceptionHandler(UserBuildException.class)
	public ResponseEntity<ErrorValidationData> handleNotFoundRole(UserBuildException exception) {
		var erro = "Failed build";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorValidationData(erro, exception.getMessage(), formatTime(LocalDateTime.now())));
	}

	@ExceptionHandler(UserAuthenticationException.class)
	public ResponseEntity<ErrorValidationData> handleNotFoundRole(UserAuthenticationException exception) {
		var erro = "Failed authentication";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorValidationData(erro, exception.getMessage(), formatTime(LocalDateTime.now())));
	}

	private static String formatTime(LocalDateTime time) {
		DateTimeFormatter errorTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
				.withResolverStyle(ResolverStyle.STRICT);
		return time.format(errorTimeFormatter);
	}

	private record ErrorValidationData(String erro, String message, String timeOfError) {
		public ErrorValidationData(FieldError error) {
			this(error.getField(), error.getDefaultMessage(), formatTime(LocalDateTime.now()));
		}
	}

}
