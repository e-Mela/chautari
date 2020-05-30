package org.emela.chautari.service

import org.emela.chautari.domain.AddressEntity
import org.emela.chautari.domain.UserEntity
import org.emela.chautari.mapper.AddressEntityMapper
import org.emela.chautari.model.Address
import org.emela.chautari.repository.AddressEntityRepository
import org.emela.chautari.service.impl.AddressServiceImpl
import spock.lang.Specification

class AddressServiceImplSpec extends Specification {

    def subject
    AddressEntity addressEntity

    def setup() {
        subject = new AddressServiceImpl(AddressEntityMapper.INSTANCE, Mock(AddressEntityRepository))
    }

    def 'saveAddress should convert address to address entity and save to database' () {
        given:
        def user = new UserEntity()
        Address address = new Address().address1('fake address 1').address2('fake address 2').city('columbus')
        .state('oh').zip(1234556).country('user')

        when:
        subject.saveAddress(address, user)

        then:
        1 * subject.addressEntityRepository.save(_ as AddressEntity)  >> {arguments -> addressEntity = arguments[0]}
        addressEntity instanceof AddressEntity
        addressEntity != null
        addressEntity.address1 == address.address1
        addressEntity.address2 == address.address2
    }
}
