package br.com.nekicard.api.dto;

import jakarta.validation.constraints.Pattern;

public record CollaboratorUpdateData(
		@Pattern(regexp = ".*@(neki(-it)?\\.com\\.br)$", 
		message = "O dominio do email deve ser @neki.com.br ou @neki-it.com.br") 
		String email,
		
		String name,
		
		String lastName, 
		
		String socialName, 
		
		String birthDate,
		
		String telephone, 
		
		String linkedin, 
		
		String github,
		
		String instagram, 
		
		String facebook
		) {

}
