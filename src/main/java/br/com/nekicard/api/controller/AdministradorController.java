package br.com.nekicard.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nekicard.api.dto.AdministratorDetailsData;
import br.com.nekicard.api.dto.AdministratorRegistrationData;
import br.com.nekicard.api.service.AdministratorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("administrator")
public class AdministradorController {

	@Autowired
	AdministratorService administratorService;

	@PostMapping("/signUp")
	@Operation(summary = "Adiciona um novo administrador", description = "Registra um novo administrador no sistema")
	public ResponseEntity<AdministratorDetailsData> registerAdministrador(@Valid @RequestBody AdministratorRegistrationData newAdministrator) {
		var newAdmin = administratorService.registerAdministrator(newAdministrator);
		return ResponseEntity.created(null).body(new AdministratorDetailsData(newAdmin));
	}
}
