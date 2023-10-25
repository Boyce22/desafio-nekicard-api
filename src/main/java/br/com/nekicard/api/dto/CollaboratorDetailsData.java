package br.com.nekicard.api.dto;

import br.com.nekicard.api.domain.Collaborator;

public record CollaboratorDetailsData(Long id, String email, String name, String lastName, String socialName,
		String birthDate, String profileImage, String telephone, Boolean isActive, String linkedin, String github,
		String instagram, String facebook) {

	public CollaboratorDetailsData(Collaborator colaborador) {
		this(colaborador.getId(), colaborador.getEmail(), colaborador.getName(), colaborador.getLastName(),
				colaborador.getSocialName(), colaborador.getBirthDate(), colaborador.getProfileImage(),
				colaborador.getTelephone(), colaborador.getIsActive(), colaborador.getLinkedin(),
				colaborador.getGithub(), colaborador.getInstagram(), colaborador.getFacebook());
	}
}
