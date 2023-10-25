package br.com.nekicard.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nekicard.api.security.domain.User;

@Repository("user")
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findUserByEmail(String email);

	Boolean existsByEmail(String email);
}
