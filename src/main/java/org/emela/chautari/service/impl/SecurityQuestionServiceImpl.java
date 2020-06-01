package org.emela.chautari.service.impl;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.SecurityQuestionEntity;
import org.emela.chautari.mapper.SecurityQuestionEntityMapper;
import org.emela.chautari.model.SecurityQuestion;
import org.emela.chautari.repository.SecurityQuestionRepository;
import org.emela.chautari.service.SecurityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityQuestionServiceImpl implements SecurityQuestionService {

    private final SecurityQuestionRepository securityQuestionRepository;
    private final SecurityQuestionEntityMapper mapper;

    @Autowired
    public SecurityQuestionServiceImpl(SecurityQuestionRepository securityQuestionRepository, SecurityQuestionEntityMapper mapper) {
        this.securityQuestionRepository = securityQuestionRepository;
        this.mapper = mapper;
    }

    @Override
    public SecurityQuestionEntity saveSecurityQuestion(SecurityQuestion securityQuestion, CredentialEntity credentialEntity) {
        SecurityQuestionEntity securityQuestionEntity = mapper.toSecurityQuestionEntity(securityQuestion);
        securityQuestionEntity.setCredentialEntity(credentialEntity);
        return securityQuestionRepository.save(securityQuestionEntity);
    }
}
