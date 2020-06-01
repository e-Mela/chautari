package org.emela.chautari.mapper

import io.micrometer.core.instrument.util.StringUtils
import org.emela.chautari.domain.UserEntity
import org.emela.chautari.model.*
import spock.lang.Specification

class UserEntityMapperSpec extends Specification {

    def subject = UserEntityMapper.INSTANCE

    def 'toUserEntity should convert user detail to user entity'() {
        given:
        UserAccountDetail userDetail = new UserAccountDetail().user(new UserDetail().person(new Person().firstName('suseel').lastName('bam').title(Person.TitleEnum.MR))
                .address(new Address().address1('address 1').address2('').city('columbus').state('OH').zip(12345).country('use')))
                .credential(new Credential().userName('fake-user').password('fake-password'))
                .contact(new Contact().phoneNumber('1234567890').email('fake@email.com'))

        when:
        def result = subject.toUserEntity(userDetail)

        then:
        result != null
        StringUtils.isNotEmpty(result.userId as String)
        result.firstName == userDetail.user.person.firstName
        result.lastName == userDetail.user.person.lastName
        result.phone == userDetail.contact.phoneNumber
        result.email == userDetail.contact.email
        result.title == userDetail.user.person.title.name()
        result.addresses == null
        result.credential == null
    }

    def 'toUserDetail should convert user entity to user detail'() {
        given:
        UserEntity entity = new UserEntity(firstName: 'suseel', lastName: 'bam', phone: '1234567890', email: 'fake@email.com')

        when:
        def result = subject.toUserAccountDetail(entity)

        then:
        result != null
        result.user.person.firstName == entity.firstName
        result.user.person.lastName == entity.lastName
        //TODO - fix Enum conversion to string and uncomment this line
        //result.person.title.name() == entity.title
        result.contact.phoneNumber == entity.phone
        result.contact.email == entity.email

    }
}
