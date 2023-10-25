package br.com.nekicard.api.domain;

import br.com.nekicard.api.dto.AdministratorRegistrationData;
import br.com.nekicard.api.security.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "administrator")
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adm_cd_id")
	private Long id;

	@Column(name = "adm_tx_email", unique = true)
	private String email;

	@Column(name = "adm_tx_name")
	private String name;

	@Column(name = "adm_tx_last_name")
	private String lastName;

	@OneToOne(mappedBy = "administrator")
	private User user;

	public Administrator (@Valid AdministratorRegistrationData newAdministrator) {
		this.email = newAdministrator.email();
		this.name = newAdministrator.name();
		this.lastName = newAdministrator.lastName();
	}
}
