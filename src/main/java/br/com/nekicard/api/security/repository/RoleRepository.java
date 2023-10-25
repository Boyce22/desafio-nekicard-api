package br.com.nekicard.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nekicard.api.security.domain.Role;
import br.com.nekicard.api.security.enuns.RoleEnum;
	
@Repository("role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleEnum name);

}
