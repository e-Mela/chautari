package org.emela.chautari.service;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.AuthenticationResponse;
import org.emela.chautari.model.Credential;
import org.emela.chautari.mapper.CredentialEntityMapper;
import org.emela.chautari.repository.CredentialEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialService {

    private CredentialEntityRepository credentialEntityRepository;
    private CredentialEntityMapper mapper;

    @Autowired
    public CredentialService(CredentialEntityRepository credentialEntityRepository, CredentialEntityMapper mapper) {
        this.credentialEntityRepository = credentialEntityRepository;
        this.mapper = mapper;
    }

    public CredentialEntity saveCredential(Credential credential, UserEntity userEntity) {

        CredentialEntity entity = mapper.toCredentialEntity(credential);
        entity.setUserEntity(userEntity);
        return credentialEntityRepository.save(entity);
    }


    public CredentialEntity saveCredential(Credential credential) {

        CredentialEntity entity = mapper.toCredentialEntity(credential);
        return credentialEntityRepository.save(entity);
    }

    public AuthenticationResponse login(Credential credential) {

        Optional<CredentialEntity> response;
        response = credentialEntityRepository.findByUserNameAndPassword(credential.getUserName(), credential.getPassword());
        if(response.isPresent()) {
            return AuthenticationResponse.builder().userId(response.get().getUserName()).message("success").build();
        }

        response = credentialEntityRepository.findByUserName(credential.getUserName());
        if(response.isPresent()) {
            return AuthenticationResponse.builder().userId(credential.getUserName()).message("Invalid password!!!").build();
        }

        return AuthenticationResponse.builder().userId(credential.getUserName()).message("user does not exist!!").build();

    }
}
