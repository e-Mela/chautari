package org.emela.chautari.service.impl;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.mapper.CredentialEntityMapper;
import org.emela.chautari.model.AuthenticationResponse;
import org.emela.chautari.model.Credential;
import org.emela.chautari.repository.CredentialEntityRepository;
import org.emela.chautari.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialServiceImpl implements CredentialService {

    private final CredentialEntityRepository credentialEntityRepository;
    private final CredentialEntityMapper mapper;

    @Autowired
    public CredentialServiceImpl(CredentialEntityRepository credentialEntityRepository, CredentialEntityMapper mapper) {
        this.credentialEntityRepository = credentialEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public CredentialEntity saveCredential(Credential credential, UserEntity userEntity) {

        CredentialEntity entity = mapper.toCredentialEntity(credential);
        entity.setUserEntity(userEntity);
        return credentialEntityRepository.save(entity);
    }

    @Override
    public CredentialEntity saveCredential(Credential credential) {

        CredentialEntity entity = mapper.toCredentialEntity(credential);
        return credentialEntityRepository.save(entity);
    }

    @Override
    public AuthenticationResponse login(Credential credential) {

        Optional<CredentialEntity> response;
        response = credentialEntityRepository.findByUserNameAndPassword(credential.getUserName(), credential.getPassword());
        if (response.isPresent()) {
            return new AuthenticationResponse().userId(response.get().getUserName()).message("success");
        }

        response = credentialEntityRepository.findByUserName(credential.getUserName());
        if (response.isPresent()) {
            return new AuthenticationResponse().userId(credential.getUserName()).message("Invalid password!!!");
        }

        return new AuthenticationResponse().userId(credential.getUserName()).message("user does not exist!!");

    }
}
