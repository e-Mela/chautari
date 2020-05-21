package org.emela.chautari.service;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.Credential;
import org.emela.chautari.model.SetupResponse;
import org.emela.chautari.model.UserDetail;
import org.emela.chautari.mapper.UserEntityMapper;
import org.emela.chautari.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupService {

    private UserEntityRepository userEntityRepository;
    private UserEntityMapper userEntityMapper;
    private CredentialService credentialService;
    private SecurityQuestionService securityQuestionService;
    private AddressService addressService;

    @Autowired
    public SetupService(UserEntityRepository userEntityRepository,
                        UserEntityMapper userEntityMapper,
                        CredentialService credentialService,
                        SecurityQuestionService securityQuestionService,
                        AddressService addressService) {

        this.userEntityRepository = userEntityRepository;
        this.credentialService = credentialService;
        this.userEntityMapper = userEntityMapper;
        this.securityQuestionService = securityQuestionService;
        this.addressService = addressService;
    }

    public SetupResponse setupUser(UserDetail userDetail) {

        UserEntity user = userEntityMapper.toUserEntity(userDetail);
        UserEntity savedEntity = userEntityRepository.save(user);

        setupUserCredential(userDetail.getCredential(), savedEntity);
        addressService.saveAddress(userDetail.getAddress(), savedEntity);
        return SetupResponse.builder().userId(savedEntity.getUserId()).message("success").build();
    }

    private void setupUserCredential(Credential credential, UserEntity userEntity) {
        CredentialEntity saveCredential = credentialService.saveCredential(credential, userEntity);
        credential.getSecurityQuestions().forEach(it -> securityQuestionService.saveSecurityQuestion(it, saveCredential));
    }
}
