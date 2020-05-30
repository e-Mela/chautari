package org.emela.chautari.service;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.AuthenticationResponse;
import org.emela.chautari.model.Credential;
import org.springframework.stereotype.Service;

@Service
public interface CredentialService {

    CredentialEntity saveCredential(Credential credential, UserEntity userEntity);

    CredentialEntity saveCredential(Credential credential);

    AuthenticationResponse login(Credential credential);
}
