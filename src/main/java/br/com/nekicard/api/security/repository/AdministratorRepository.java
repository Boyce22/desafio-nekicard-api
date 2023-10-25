package br.com.nekicard.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nekicard.api.domain.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

	Administrator findByEmail(String email);

}
