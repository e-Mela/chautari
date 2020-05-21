package org.emela.chautari.mapper

import io.micrometer.core.instrument.util.StringUtils
import org.emela.chautari.domain.UserEntity
import org.emela.chautari.model.Address
import org.emela.chautari.model.Contact
import org.emela.chautari.model.Credential
import org.emela.chautari.model.Person
import org.emela.chautari.model.TitleEnum
import org.emela.chautari.model.UserDetail
import spock.lang.Specification

class UserEntityMapperSpec extends Specification {

    def subject = UserEntityMapper.INSTANCE

    def 'toUserEntity should convert user detail to user entity' () {
        given:
        UserDetail userDetail = UserDetail.builder()
                .person(Person.builder().firstName('suseel').lastName('bam').title(TitleEnum.MR).build())
        .address(Address.builder().address1('address 1').address2('').city('columbus').state('OH').zipCode(12345).country('use').build())
        .contact(Contact.builder().phoneNumber('1234567890').email('fake@email.com').build())
        .credential(Credential.builder().userName('fake-user').password('fake-password').build()).build()

        when:
        def result = subject.toUserEntity(userDetail)

        then:
        result != null
        StringUtils.isNotEmpty(result.userId as String)
        result.firstName == userDetail.person.firstName
        result.lastName == userDetail.person.lastName
        result.phone == userDetail.contact.phoneNumber
        result.email == userDetail.contact.email
        result.title == userDetail.person.title.name()
        result.addresses == null
        result.credential == null
    }

    def 'toUserDetail should convert user entity to user detail' () {
        given:
        UserEntity entity = new UserEntity(firstName: 'suseel', lastName: 'bam',  phone: '1234567890', email: 'fake@email.com')

        when:
        def result = subject.toUserDetail(entity)

        then:
        result != null
        result.person.firstName == entity.firstName
        result.person.lastName == entity.lastName
        //TODO - fix Enum conversion to string and uncomment this line
        //result.person.title.name() == entity.title
        result.contact.phoneNumber == entity.phone
        result.contact.email == entity.email

    }
}
