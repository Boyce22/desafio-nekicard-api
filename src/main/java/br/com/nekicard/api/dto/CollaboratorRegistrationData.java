package br.com.nekicard.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CollaboratorRegistrationData(
		@NotBlank(message = "O campo email não pode estar vazio") 
		@Pattern(regexp = ".*@(neki(-it)?\\.com\\.br)$", 
		message = "O dominio do email deve ser @neki.com.br ou @neki-it.com.br") 
		String email,

		@NotBlank(message = "O nome não pode estar vazio") 
		String name,

		@NotBlank(message = "O sobrenome não pode estar vazio") 
		String lastName,

		String socialName,
		
		@NotNull(message = "A data de nascimento não pode estar vazia") 
		String birthDate,

		String telephone,

		String linkedin,

		String github,

		String instagram,

		String facebook
		) {
}
