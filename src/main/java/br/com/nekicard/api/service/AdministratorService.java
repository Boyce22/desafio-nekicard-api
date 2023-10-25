package br.com.nekicard.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nekicard.api.domain.Administrator;
import br.com.nekicard.api.dto.AdministratorRegistrationData;
import br.com.nekicard.api.exception.EmailExistsException;
import br.com.nekicard.api.security.domain.Role;
import br.com.nekicard.api.security.domain.User;
import br.com.nekicard.api.security.enuns.RoleEnum;
import br.com.nekicard.api.security.repository.AdministratorRepository;
import br.com.nekicard.api.security.repository.RoleRepository;
import br.com.nekicard.api.security.repository.UserRepository;
import br.com.nekicard.api.security.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class AdministratorService {

	@Autowired
	AdministratorRepository administratorRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Transactional
	public Administrator registerAdministrator(@Valid AdministratorRegistrationData newAdminData) {
	    Administrator existingAdmin = administratorRepository.findByEmail(newAdminData.email());

	    if (existingAdmin != null && existingAdmin.getEmail() != null) {
	        throw new EmailExistsException("Unable to register a duplicate email");
	    }

	    Set<Role> roles = new HashSet<>();
	    Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMINISTRATOR)
	            .orElseThrow(() -> new RuntimeException("Error: Role not found."));
	    roles.add(adminRole);

	    Administrator newAdmin = administratorRepository.save(new Administrator(newAdminData));
	    User user = userService.createUserWithAdministrator(newAdmin, roles, newAdminData);
	    newAdmin.setUser(user);

	    return newAdmin;
	}

}
