package br.com.nekicard.api.dto;

import br.com.nekicard.api.domain.Administrator;

public record AdministratorDetailsData(String name, String lastName, String email) {

	public AdministratorDetailsData(Administrator administrator) {
		this(administrator.getName(), administrator.getLastName(), administrator.getEmail());
	}

}
