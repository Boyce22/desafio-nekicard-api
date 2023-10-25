package br.com.nekicard.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AdministratorRegistrationData(
		@NotBlank 
		String name, 
		
		@NotBlank 
		String lastName,
		
		@NotBlank 
		@Pattern(regexp = ".*@(neki(-it)?\\.com\\.br)$", 
		message = "O dominio do email deve ser @neki.com.br ou @neki-it.com.br") 
		String email,  
		
		@NotBlank 
		@Size(min = 6)
		String password
		) {

}
