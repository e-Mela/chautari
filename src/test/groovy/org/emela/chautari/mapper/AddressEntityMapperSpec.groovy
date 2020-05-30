package org.emela.chautari.mapper

import org.emela.chautari.domain.AddressEntity
import org.emela.chautari.model.Address
import spock.lang.Specification

class AddressEntityMapperSpec extends Specification {

    def 'address entity mapper should map address to address entity class'() {
        given:
        Address address = new Address(address1: 'fake address 1', address2: 'fake address 2', city: 'columbus', country: 'usa', zip: 12345)

        when:
        def result = AddressEntityMapper.INSTANCE.toAddressEntity(address)

        then:
        result != null
        result.address1 == address.address1
        result.address2 == address.address2
        result.city == address.city
        result.country == address.country
        result.state == address.state
        result.zipCode == address.zip
    }

    def 'address entity mapper should map address entity to address' () {
        given:
        AddressEntity entity = new AddressEntity(address1: 'fake address 1', address2: 'fake address 2', city: 'col', state: 'oh', zipCode: 123456, country: 'usa')

        when:
        def result = AddressEntityMapper.INSTANCE.toAddress(entity)

        then:
        result != null
        result.address1 == entity.address1
        result.address2 == entity.address2
        result.city == entity.city
        result.state == entity.state
        result.country == entity.country
        result.zip == entity.zipCode

    }
}
