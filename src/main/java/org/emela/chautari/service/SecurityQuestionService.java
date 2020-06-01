package org.emela.chautari.service;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.domain.SecurityQuestionEntity;
import org.emela.chautari.model.SecurityQuestion;
import org.springframework.stereotype.Service;

@Service
public interface SecurityQuestionService {

    SecurityQuestionEntity saveSecurityQuestion(SecurityQuestion securityQuestion, CredentialEntity credentialEntity);
}
