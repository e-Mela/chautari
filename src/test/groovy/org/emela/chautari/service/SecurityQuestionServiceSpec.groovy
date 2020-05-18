package org.emela.chautari.service


import org.emela.chautari.domain.CredentialEntity
import org.emela.chautari.domain.SecurityQuestionEntity
import org.emela.chautari.mapper.SecurityQuestionEntityMapper
import org.emela.chautari.model.SecurityQuestion
import org.emela.chautari.repository.SecurityQuestionRepository
import spock.lang.Specification

class SecurityQuestionServiceSpec extends Specification {

    def subject
    SecurityQuestionEntity capturedEntity

    def 'setup' () {
        subject = new SecurityQuestionService(Mock(SecurityQuestionRepository), SecurityQuestionEntityMapper.INSTANCE)
    }

    def 'saveSecurityQuestion should convert security question to enitty and save to database' () {
        given:
        def securityQuestion = SecurityQuestion.builder().question('fake question').answer('fake answer').build()

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
