package org.emela.chautari.service

import org.emela.chautari.domain.CredentialEntity
import org.emela.chautari.domain.SecurityQuestionEntity
import org.emela.chautari.mapper.SecurityQuestionEntityMapper
import org.emela.chautari.model.SecurityQuestion
import org.emela.chautari.repository.SecurityQuestionRepository
import org.emela.chautari.service.impl.SecurityQuestionServiceImpl
import spock.lang.Specification

class SecurityQuestionServiceImplSpec extends Specification {

    def subject
    SecurityQuestionEntity capturedEntity

    def 'setup' () {
        subject = new SecurityQuestionServiceImpl(Mock(SecurityQuestionRepository), SecurityQuestionEntityMapper.INSTANCE)
    }

    def 'saveSecurityQuestion should convert security question to enitty and save to database' () {
        given:
        def securityQuestion = new SecurityQuestion().question('fake question').answer('fake answer')

        when:
        subject.saveSecurityQuestion(securityQuestion, new CredentialEntity())

        then:
        1 * subject.securityQuestionRepository.save(_ as SecurityQuestionEntity)  >> { arguments -> capturedEntity = arguments[0]}
        capturedEntity instanceof SecurityQuestionEntity
        capturedEntity != null
        capturedEntity.question == securityQuestion.question
        capturedEntity.answer == securityQuestion.answer
    }
}
