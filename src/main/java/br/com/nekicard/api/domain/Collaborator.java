package br.com.nekicard.api.domain;

import br.com.nekicard.api.dto.CollaboratorRegistrationData;
import br.com.nekicard.api.dto.CollaboratorUpdateData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "collaborators")
public class Collaborator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "col_cd_id")
	private Long id;

	@Column(name = "col_tx_email", unique = true)
	private String email;

	@Column(name = "col_tx_name")
	private String name;

	@Column(name = "col_tx_last_name")
	private String lastName;

	@Column(name = "col_tx_social_name")
	private String socialName;

	@Column(name = "col_date_birth_date")
	private String birthDate;

	@Column(name = "col_tx_url_image")
	private String profileImage;

	@Column(name = "col_tx_tel")
	private String telephone;

	@Column(name = "col_bl_is_active")
	private Boolean isActive;

	@Column(name = "col_tx_lin")
	private String linkedin;

	@Column(name = "col_tx_git")
	private String github;

	@Column(name = "col_tx_ins")
	private String instagram;

	@Column(name = "col_tx_fac")
	private String facebook;

	public Collaborator(@Valid CollaboratorRegistrationData newCollaborator) {
	    this.email = newCollaborator.email();
	    this.name = newCollaborator.name();
	    this.lastName = newCollaborator.lastName();
	    this.socialName = (newCollaborator.socialName() != null) ? newCollaborator.socialName() : "Não informado";
	    this.birthDate = newCollaborator.birthDate();
	    this.telephone = (newCollaborator.telephone() != null) ? newCollaborator.telephone() : "Não informado";
	    this.profileImage = "";
	    this.linkedin = (newCollaborator.linkedin() != null) ? newCollaborator.linkedin() : "Não informado";
	    this.github = (newCollaborator.github() != null) ? newCollaborator.github() : "Não informado";
	    this.instagram = (newCollaborator.instagram() != null) ? newCollaborator.instagram() : "Não informado";
	    this.facebook = (newCollaborator.facebook() != null) ? newCollaborator.facebook() : "Não informado";
	    this.isActive = true;
	}


	public void desactivateCollaborator() {
		this.isActive = false;
	}

	public void updatedData(CollaboratorUpdateData updatedCollaborator) {
		if (updatedCollaborator.email() != null) {
			this.email = updatedCollaborator.email();
		}

		if (updatedCollaborator.name() != null) {
			this.name = updatedCollaborator.name();
		}

		if (updatedCollaborator.lastName() != null) {
			this.lastName = updatedCollaborator.lastName();
		}

		if (updatedCollaborator.socialName() != null) {
			this.socialName = updatedCollaborator.socialName();
		}

		if (updatedCollaborator.birthDate() != null) {
			this.birthDate = updatedCollaborator.birthDate();
		}

		if (updatedCollaborator.telephone() != null) {
			this.telephone = updatedCollaborator.telephone();
		}

		if (updatedCollaborator.linkedin() != null) {
		    this.linkedin = updatedCollaborator.linkedin();
		}

		if (updatedCollaborator.github() != null) {
		    this.github = updatedCollaborator.github();
		}

		if (updatedCollaborator.instagram() != null) {
		    this.instagram = updatedCollaborator.instagram();
		}

		if (updatedCollaborator.facebook() != null) {
		    this.facebook = updatedCollaborator.facebook();
		}

	}

}
