package org.emela.chautari.service

import org.emela.chautari.domain.AddressEntity
import org.emela.chautari.domain.UserEntity
import org.emela.chautari.mapper.AddressEntityMapper
import org.emela.chautari.model.Address
import org.emela.chautari.repository.AddressEntityRepository
import spock.lang.Specification

class AddressServiceSpec extends Specification {

    def subject
    AddressEntity addressEntity

    def setup() {
        subject = new AddressService(AddressEntityMapper.INSTANCE, Mock(AddressEntityRepository))
    }

    def 'saveAddress should convert address to address entity and save to database' () {
        given:
        def user = new UserEntity()
        Address address = Address.builder().address1('fake address 1').address2('fake address 2').city('columbus')
        .state('oh').zipCode(1234556).country('user').build()

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
