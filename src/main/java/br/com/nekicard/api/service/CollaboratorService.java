package br.com.nekicard.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.nekicard.api.domain.Collaborator;
import br.com.nekicard.api.dto.CollaboratorDetailsData;
import br.com.nekicard.api.dto.CollaboratorRegistrationData;
import br.com.nekicard.api.dto.CollaboratorUpdateData;
import br.com.nekicard.api.exception.EmailExistsException;
import br.com.nekicard.api.repository.CollaboratorRepository;
import br.com.nekicard.api.security.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CollaboratorService {

	@Autowired
	CollaboratorRepository collaboratorRepository;

	@Autowired
	ImageService imagemService;

	@Autowired
	RoleRepository roleRepository;

	public List<CollaboratorDetailsData> findAll() {
		return collaboratorRepository.findAllByIsActiveTrue();
	}

	public Collaborator findCollaboratorById(Long id) {
		return collaboratorRepository.getReferenceById(id);
	}

	@Transactional
	public Collaborator registerCollaborator(@Valid CollaboratorRegistrationData newCollaborator) {
		var collaborator = collaboratorRepository.findByEmail(newCollaborator.email());

		if (collaborator != null && collaborator.getEmail() != null) {
			throw new EmailExistsException("It is not possible to register a repeated email");
		}

		return collaboratorRepository.save(new Collaborator(newCollaborator));
	}

	@Transactional
	public Collaborator updateCollaborator(CollaboratorUpdateData updatedCollaborator, Long id) {
	    Collaborator collaborator = collaboratorRepository.getReferenceById(id);

	    if (collaborator != null) {
	        collaborator.updatedData(updatedCollaborator);

	        return collaboratorRepository.save(collaborator);
	    } else {
	        throw new EntityNotFoundException("Colaborador não encontrado com o ID: " + id);
	    }
	}
	
	public void registerAvatar(MultipartFile photo, String email) {
	    Collaborator collaborator = collaboratorRepository.findByEmail(email);
	    if (collaborator != null) {
	        String savedImagePath = imagemService.saveImage(photo);
	        collaborator.setProfileImage(savedImagePath);
	        collaboratorRepository.save(collaborator);
	    }
	}

	public Collaborator deleteCollaborator(Long id) {
		Collaborator collaboratorToDesactivate = findCollaboratorById(id);
		collaboratorToDesactivate.desactivateCollaborator();
		return collaboratorRepository.save(collaboratorToDesactivate);
	}

}
