package org.emela.chautari.mapper

import org.emela.chautari.domain.CredentialEntity
import org.emela.chautari.model.Credential
import spock.lang.Specification

class CredentialEntityMapperSpec extends Specification {

    def subject = CredentialEntityMapper.INSTANCE

    def 'toCredentialEntity should convert credential to credentialEntity'() {
        given:
        Credential credential = new Credential().userName('fake-user').password('fake-password')

        when:
        def result = subject.toCredentialEntity(credential)

        then:
        result != null
        result.password == credential.password
        result.userName == credential.userName
        result.securityQuestions.size() == 0
    }

    def 'toCredential should convert credential entity to credential'() {
        given:
        CredentialEntity entity = new CredentialEntity(userName: 'fake-user', password: 'fake-password')

        when:
        def result = subject.toCredential(entity)

        then:
        result != null
        result.password == entity.password
        result.userName == entity.userName
        result.securityQuestions.size() == 0
    }
}
