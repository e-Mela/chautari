package org.emela.chautari.mapper

import org.emela.chautari.domain.SecurityQuestionEntity
import org.emela.chautari.model.SecurityQuestion
import spock.lang.Specification

class SecurityQuestionEntityMapperSpec extends Specification {

    def subject = SecurityQuestionEntityMapper.INSTANCE

    def 'toSecurityQuestionEntity should convert security question to security question entity' () {
        given:
        def source = new SecurityQuestion().question('fake-question').answer('fake-answer')

        when:
        def result = subject.toSecurityQuestionEntity(source)

        then:
        result != null
        result.question == source.question
        result.answer == source.answer
        result.credentialEntity == null
    }


    def 'toSecurityQuestion should convert security question entity to security question' () {
        given:
        def entity = new SecurityQuestionEntity(question: 'fake-question', answer: 'fake-answer')

        when:
        def result = subject.toSecurityQuestion(entity)

        then:
        result != null
        result.question == entity.question
        result.answer == entity.answer
    }

}
