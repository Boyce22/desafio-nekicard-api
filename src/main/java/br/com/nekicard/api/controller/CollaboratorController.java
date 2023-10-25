package br.com.nekicard.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.nekicard.api.domain.Collaborator;
import br.com.nekicard.api.dto.CollaboratorDetailsData;
import br.com.nekicard.api.dto.CollaboratorRegistrationData;
import br.com.nekicard.api.dto.CollaboratorUpdateData;
import br.com.nekicard.api.service.CollaboratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("collaborators")
public class CollaboratorController {

	@Autowired
	private CollaboratorService collaboratorService;
	
	@PostMapping("/signUp")
	@Operation(summary = "Adiciona um novo colaborador", description = "Registra um novo colaborador no sistema")
	public ResponseEntity<CollaboratorDetailsData> addNewCollaborator(
	        @RequestBody @Valid CollaboratorRegistrationData newCollaborator,
	        UriComponentsBuilder uriBuilder) {

	    Collaborator collaborator = collaboratorService.registerCollaborator(newCollaborator);

	    var uri = uriBuilder.path("/collaborator/{id}").buildAndExpand(collaborator.getId()).toUri();

	    return ResponseEntity.created(uri).body(new CollaboratorDetailsData(collaborator));
	}

	@PostMapping("/photo/{email}")
	public ResponseEntity<String> salvarFoto(@RequestParam("photo") MultipartFile photo, @PathVariable String email) {
	    collaboratorService.registerAvatar(photo, email);
	    return ResponseEntity.ok("Avatar saved successfully.");
	}

	@PutMapping("/update/{id}")
	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMINISTRATOR')")
	@Operation(summary = "Atualiza um colaborador por id", description = "Resgata todas as informações relacionadas ao id inserido e altera os dados anteriores pelos novos dados enviados na requisição")
	public ResponseEntity<CollaboratorDetailsData> updateCollaborator(
	        @RequestBody @Valid CollaboratorUpdateData updatedCollaborator, @PathVariable Long id) {

	    Collaborator collaborator = collaboratorService.updateCollaborator(updatedCollaborator, id);

	    return ResponseEntity.ok(new CollaboratorDetailsData(collaborator));
	}

	@DeleteMapping("/delete/{id}")
	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMINISTRATOR')")
	@Operation(summary = "Deleta um colaborador por id", description = "Troca o valor do isActive para falso, fazendo com que seja um colaborador inativo no sistema")
	public ResponseEntity<CollaboratorDetailsData> deleteCollaborator(@PathVariable Long id) {

		Collaborator collaborator = collaboratorService.deleteCollaborator(id);
		return ResponseEntity.ok(new CollaboratorDetailsData(collaborator));

	}

	@GetMapping("/{id}")
	@Operation(summary = "Procura o colaborador por id", description = "Resgata todas as informações relacionadas ao id inserido")
	public ResponseEntity<CollaboratorDetailsData> findCollaborator(@PathVariable Long id) {

		Collaborator collaborator = collaboratorService.findCollaboratorById(id);
		return ResponseEntity.ok(new CollaboratorDetailsData(collaborator));

	}

	@GetMapping("/findAll/active")
	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMINISTRATOR')")
	@Operation(summary = "Procura por todos os colaboradores ativos", description = "Resgata todos os colaboradores ativos no sistema")
	public ResponseEntity <List<CollaboratorDetailsData>> findAllCollaborator() {
		var collaborators = collaboratorService.findAll();
		return ResponseEntity.ok(collaborators);
	}

}
