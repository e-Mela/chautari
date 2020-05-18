package org.emela.chautari.service

import org.emela.chautari.model.*
import org.emela.chautari.repository.AddressEntityRepository
import org.emela.chautari.repository.CredentialEntityRepository
import org.emela.chautari.repository.SecurityQuestionRepository
import org.emela.chautari.repository.UserEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

@SpringBootTest(webEnvironment = NONE)
class CredentialServiceITSpec extends Specification {

    @Autowired
    private CredentialService credentialService

    @Autowired
    private SetupService setupService

    @Autowired
    private CredentialEntityRepository credentialEntityRepository

    @Autowired
    private UserEntityRepository userEntityRepository

    @Autowired
    private AddressEntityRepository addressEntityRepository

    @Autowired
    private SecurityQuestionRepository securityQuestionRepository


    def setup() {
        addressEntityRepository.deleteAll()
        securityQuestionRepository.deleteAll()
        credentialEntityRepository.deleteAll()
        userEntityRepository.deleteAll()
        databaseSetup()
    }

    def 'login with valid user name and password should return correct authentication response' () {
        given:
        def credential = Credential.builder().userName("suseelbam").password("pass123").build()

        when:
        def response = credentialService.login(credential)

        then:
        response != null
        response.userId != null
        response.message == 'success'
    }

    def 'login with valid user name but invalid password should return correct authentication response' () {
        given:
        def credential = Credential.builder().userName("suseelbam").password("invalid password").build()

        when:
        def response = credentialService.login(credential)

        then:
        response != null
        response.userId == credential.getUserName()
        response.message == 'Invalid password!!!'
    }

    def 'login with invalid user name and password should return correct authentication response' () {
        given:
        def credential = Credential.builder().userName("fake-user").password("pass123").build()

        when:
        def response = credentialService.login(credential)

        then:
        response != null
        response.userId == credential.getUserName()
        response.message == 'user does not exist!!'
    }

    def databaseSetup() {
        SecurityQuestion question1 = SecurityQuestion.builder().question("Fake Question")
                .answer("Fake Answer").build()
        SecurityQuestion question2 = SecurityQuestion.builder().question("Fake Question 2")
                .answer("Fake Answer 2").build()
        Credential credential = Credential.builder().userName("suseelbam").password("pass123")
                .securityQuestions(Arrays.asList(question1, question2)).build()

        Person person = Person.builder().firstName("suseel").lastName("bam").build()
        Contact contact = Contact.builder().email("my@email").phoneNumber("1234567890").build()
        Address address = Address.builder().address1("address 1").address2("address 2").city("columbus")
                .state("OH").zipCode(123456).country("USA").build()

        def userDetail = UserDetail.builder().address(address).contact(contact).person(person).credential(credential).build()

        setupService.setupUser(userDetail)
    }
}
