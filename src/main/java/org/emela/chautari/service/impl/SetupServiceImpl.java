package org.emela.chautari.service.impl;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.mapper.UserEntityMapper;
import org.emela.chautari.model.Credential;
import org.emela.chautari.model.SetupResponse;
import org.emela.chautari.model.UserAccountDetail;
import org.emela.chautari.repository.UserEntityRepository;
import org.emela.chautari.service.AddressService;
import org.emela.chautari.service.CredentialService;
import org.emela.chautari.service.SecurityQuestionService;
import org.emela.chautari.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupServiceImpl implements SetupService {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;
    private final CredentialService credentialService;
    private final SecurityQuestionService securityQuestionService;
    private final AddressService addressService;

    @Autowired
    public SetupServiceImpl(UserEntityRepository userEntityRepository,
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

    @Override
    public SetupResponse setupUser(UserAccountDetail userAccountDetail) {

        UserEntity user = userEntityMapper.toUserEntity(userAccountDetail);
        UserEntity savedEntity = userEntityRepository.save(user);

        setupUserCredential(userAccountDetail.getCredential(), savedEntity);
        addressService.saveAddress(userAccountDetail.getUser().getAddress(), savedEntity);
        return new SetupResponse().userId(savedEntity.getUserId().toString()).message("success");
    }

    private void setupUserCredential(Credential credential, UserEntity userEntity) {
        CredentialEntity saveCredential = credentialService.saveCredential(credential, userEntity);
        credential.getSecurityQuestions().forEach(it -> securityQuestionService.saveSecurityQuestion(it,
                saveCredential));
    }
}
