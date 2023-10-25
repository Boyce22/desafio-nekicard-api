package br.com.nekicard.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nekicard.api.domain.Collaborator;
import br.com.nekicard.api.dto.CollaboratorDetailsData;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

	List<CollaboratorDetailsData> findAllByIsActiveTrue();

	Collaborator findByEmail(String email);
	
}
