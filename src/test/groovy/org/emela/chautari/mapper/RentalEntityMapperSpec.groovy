package org.emela.chautari.mapper


import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.model.RentalItemPrice
import org.emela.chautari.model.RentalItemRequest
import spock.lang.Specification

class RentalEntityMapperSpec extends Specification {

    def subject = RentalEntityMapper.INSTANCE

    def 'mapToRentalEntity should convert rentalItemRequest to rentalEntity'() {
        given:
        RentalItemRequest rentalItemRequest = new RentalItemRequest().title("test-title")
                .rentOf(RentalItemRequest.RentOfEnum.ROOM)
                .price(new RentalItemPrice().negotiable(true).value(new BigDecimal("5.5")))

        when:
        def result = subject.mapToRentalEntity(rentalItemRequest)

        then:
        result != null
        result.title == rentalItemRequest.getTitle()
        result.rentOf == "ROOM"
        result.price == new BigDecimal("5.5")
        result.negotiable
    }

    def 'mapToRentalItemRequest should convert rentalEntity to rentalItemRequest'() {
        given:
        RentalEntity rentalEntity = new RentalEntity();
        rentalEntity.setRentOf("ROOM")
        rentalEntity.setPrice(new BigDecimal("5.5"))
        rentalEntity.setNegotiable(Boolean.TRUE)

        when:
        def result = subject.mapToRentalItemRequest(rentalEntity)

        then:
        result != null
        result.title == rentalEntity.getTitle()
        result.getRentOf() == RentalItemRequest.RentOfEnum.ROOM
        result.price.getValue() == new BigDecimal("5.5")
        result.price.getNegotiable()
    }

}
