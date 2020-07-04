package org.emela.chautari.service


import org.emela.chautari.domain.UserEntity
import org.emela.chautari.mapper.UserEntityMapper
import org.emela.chautari.model.*
import org.emela.chautari.repository.UserEntityRepository
import org.emela.chautari.service.impl.SetupServiceImpl
import spock.lang.Specification

import static java.util.UUID.fromString

class SetupServiceSpec extends Specification {

    def subject

    def setup() {
        subject = new SetupServiceImpl(Mock(UserEntityRepository), UserEntityMapper.INSTANCE, Mock(CredentialService),
                Mock(SecurityQuestionService), Mock(AddressService))
    }

    def 'setupUser method should map userDetail to User entity and save to database'() {
        given:
        SecurityQuestion question1 = new SecurityQuestion().question("Fake Question")
                .answer("Fake Answer")
        SecurityQuestion question2 = new SecurityQuestion().question("Fake Question 2")
                .answer("Fake Answer 2")
        Credential credential = new Credential().userName("suseelbam").password("password")
                .securityQuestions(Arrays.asList(question1, question2))

        Person person = new Person().firstName("suseel").lastName("bam")
        Contact contact = new Contact().email("my@email").phoneNumber("1234567890")
        Address address = new Address().address1("address 1").address2("address 2").city("columbus")
                .state("OH").zip(123456).country("USA")

        UserAccountDetail accountDetail = new UserAccountDetail().contact(contact).user(new UserDetail().person
        (person).address(address)).credential(credential)

        UserEntity userEntity = new UserEntity().setUserId(fromString('a045140d-e91f-4ad2-b52f-cded30bcd2d1'))

        when:
        def result = subject.setupUser(accountDetail)

        then:
        1 * subject.userEntityRepository.save(_ as UserEntity) >> { arguments -> userEntity = arguments[0] }
        result != null

    }
}
