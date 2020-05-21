package org.emela.chautari.service;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.SecurityQuestionEntity;
import org.emela.chautari.model.SecurityQuestion;
import org.emela.chautari.mapper.SecurityQuestionEntityMapper;
import org.emela.chautari.repository.SecurityQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityQuestionService {

    private SecurityQuestionRepository securityQuestionRepository;
    private SecurityQuestionEntityMapper mapper;

    @Autowired
    public SecurityQuestionService(SecurityQuestionRepository securityQuestionRepository, SecurityQuestionEntityMapper mapper) {
        this.securityQuestionRepository = securityQuestionRepository;
        this.mapper = mapper;
    }

    public SecurityQuestionEntity saveSecurityQuestion(SecurityQuestion securityQuestion, CredentialEntity credentialEntity) {
        SecurityQuestionEntity securityQuestionEntity = mapper.toSecurityQuestionEntity(securityQuestion);
        securityQuestionEntity.setCredentialEntity(credentialEntity);
        return securityQuestionRepository.save(securityQuestionEntity);
    }
}
