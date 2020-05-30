package org.emela.chautari.service

import org.emela.chautari.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

@SpringBootTest(webEnvironment = NONE)
class SetupServiceImplITSpec extends Specification {

    @Autowired
    private SetupService service

    def 'setupUser should take user detail and update database accordengly' () {
        given:
        SecurityQuestion question1 = new SecurityQuestion().question('Fake Question')
                .answer('Fake Answer')
        SecurityQuestion question2 = new SecurityQuestion().question('Fake Question 2')
                .answer('Fake Answer 2')
        Credential credential = new Credential().userName('suseelbam').password('password')
                .securityQuestions(Arrays.asList(question1, question2))

        Person person = new Person().firstName('suseel').lastName('bam')
        Contact contact = new Contact().email('my@email').phoneNumber('1234567890')
        Address address = new Address().address1('address 1').address2('address 2').city('columbus')
                .state('OH').zip(123456).country('USA')

        def userAccountDetail = new UserAccountDetail().user(new UserDetail().address(address).person(person)).contact(contact).credential(credential)

        when:
        def result = service.setupUser(userAccountDetail)

        then:
        result != null
    }
}
