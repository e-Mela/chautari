package org.emela.chautari.service

import org.emela.chautari.model.Address
import org.emela.chautari.model.Contact
import org.emela.chautari.model.Credential
import org.emela.chautari.model.Person
import org.emela.chautari.model.SecurityQuestion
import org.emela.chautari.model.UserDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE


@SpringBootTest(webEnvironment = NONE)
class SetupServiceITSpec extends Specification {

    @Autowired
    private SetupService service

    def 'setupUser should take user detail and update database accordengly' () {
        given:
        SecurityQuestion question1 = SecurityQuestion.builder().question("Fake Question")
                .answer("Fake Answer").build()
        SecurityQuestion question2 = SecurityQuestion.builder().question("Fake Question 2")
                .answer("Fake Answer 2").build()
        Credential credential = Credential.builder().userName("suseelbam").password("password")
                .securityQuestions(Arrays.asList(question1, question2)).build()

        Person person = Person.builder().firstName("suseel").lastName("bam").build()
        Contact contact = Contact.builder().email("my@email").phoneNumber("1234567890").build()
        Address address = Address.builder().address1("address 1").address2("address 2").city("columbus")
                .state("OH").zipCode(123456).country("USA").build()

        def userDetail = UserDetail.builder().address(address).contact(contact).person(person).credential(credential).build()

        when:
        def result = service.setupUser(userDetail)

        then:
        result != null
    }
}
