package br.com.nekicard.api.security.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum RoleEnum {
	
	ROLE_ADMINISTRATOR("Role Administrator ", 1),
	ROLE_COLABORADOR("Role Colaborador", 2);
	private String tipo;

	private Integer codigo;
	
}
