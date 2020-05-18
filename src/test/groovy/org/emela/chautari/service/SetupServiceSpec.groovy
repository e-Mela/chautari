//package org.emela.chautari.service
//
//import org.emela.chautari.model.*
//import org.emela.chautari.mapper.UserEntityMapper
//import org.emela.chautari.repository.UserEntityRepository
//import spock.lang.Specification
//
//class SetupServiceSpec extends Specification {
//
//    SetupService subject
//    UserEntityMapper mapper
//
//    def setup() {
//        mapper = UserEntityMapper.INSTANCE
//        subject = new SetupService(Mock(UserEntityRepository), mapper, Mock(CredentialService),
//        Mock(SecurityQuestionService), Mock(AddressService))
//    }
//
//    def 'setupUser mathod should map userDetail to User entity and save to database' () {
//        given:
//        SecurityQuestion question1 = SecurityQuestion.builder().question("Fake Question")
//                                                                .answer("Fake Answer").build()
//        SecurityQuestion question2 = SecurityQuestion.builder().question("Fake Question 2")
//                                                                .answer("Fake Answer 2").build()
//        Credential credential = Credential.builder().userName("suseelbam").password("password")
//                                                    .securityQuestions(Arrays.asList(question1, question2)).build()
//
//        Person person = Person.builder().firstName("suseel").lastName("bam").build()
//        Contact contact = Contact.builder().email("my@email").phoneNumber("1234567890").build()
//        Address address = Address.builder().address1("address 1").address2("address 2").city("columbus")
//                .state("OH").zipCode(123456).country("USA").build()
//
//        def userDetail = UserDetail.builder().address(address).contact(contact).person(person).credential(credential).build()
//
//        when:
//        def result = subject.setupUser(userDetail)
//
//        then:
//        result != null
//
//    }
//}
