package org.emela.chautari.service.impl;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.mapper.UserEntityMapper;
import org.emela.chautari.model.Credential;
import org.emela.chautari.model.SetupResponse;
import org.emela.chautari.model.UserAccountDetail;
import org.emela.chautari.repository.UserEntityRepository;
import org.emela.chautari.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupServiceImpl implements SetupService {

    private UserEntityRepository userEntityRepository;
    private UserEntityMapper userEntityMapper;
    private CredentialServiceImpl credentialServiceImpl;
    private SecurityQuestionServiceImpl securityQuestionServiceImpl;
    private AddressServiceImpl addressServiceImpl;

    @Autowired
    public SetupServiceImpl(UserEntityRepository userEntityRepository,
                            UserEntityMapper userEntityMapper,
                            CredentialServiceImpl credentialServiceImpl,
                            SecurityQuestionServiceImpl securityQuestionServiceImpl,
                            AddressServiceImpl addressServiceImpl) {

        this.userEntityRepository = userEntityRepository;
        this.credentialServiceImpl = credentialServiceImpl;
        this.userEntityMapper = userEntityMapper;
        this.securityQuestionServiceImpl = securityQuestionServiceImpl;
        this.addressServiceImpl = addressServiceImpl;
    }

    @Override
    public SetupResponse setupUser(UserAccountDetail userAccountDetail) {

        UserEntity user = userEntityMapper.toUserEntity(userAccountDetail);
        UserEntity savedEntity = userEntityRepository.save(user);

        setupUserCredential(userAccountDetail.getCredential(), savedEntity);
        addressServiceImpl.saveAddress(userAccountDetail.getUser().getAddress(), savedEntity);
        return new SetupResponse().userId(savedEntity.getUserId().toString()).message("success");
    }

    private void setupUserCredential(Credential credential, UserEntity userEntity) {
        CredentialEntity saveCredential = credentialServiceImpl.saveCredential(credential, userEntity);
        credential.getSecurityQuestions().forEach(it -> securityQuestionServiceImpl.saveSecurityQuestion(it, saveCredential));
    }
}
