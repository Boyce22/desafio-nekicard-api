package br.com.nekicard.api.security.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.nekicard.api.domain.Administrator;
import br.com.nekicard.api.dto.AdministratorRegistrationData;
import br.com.nekicard.api.security.domain.Role;
import br.com.nekicard.api.security.domain.User;
import br.com.nekicard.api.security.repository.UserRepository;
import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;


	public User createUserWithAdministrator(Administrator newAdmin, Set<Role> roles,
			@Valid AdministratorRegistrationData newAdminData) {
		User user = new User();
		user.setEmail(newAdminData.email());
		user.setPassword(encoder.encode(newAdminData.password()));
		user.setRoles(roles);
		user.setAdministrator(newAdmin);
		user = userRepository.save(user);
		return user;
	}
}
