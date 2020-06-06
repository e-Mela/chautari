package org.emela.chautari.service


import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.mapper.RentalEntityMapper
import org.emela.chautari.model.Address
import org.emela.chautari.model.RentalItemPrice
import org.emela.chautari.model.RentalItemRequest
import org.emela.chautari.model.RentalItemResponse
import org.emela.chautari.repository.RentalEntityRepository
import org.emela.chautari.service.impl.RentalServiceImpl
import spock.lang.Specification

class RentalServiceImplSpec extends Specification {

    def subject

    RentalEntity rentalEntity

    def setup() {

        subject = new RentalServiceImpl(Mock(RentalEntityRepository), Mock(RentalAvailabilityService),
                Mock(RentalFeatureService), Mock(RentalPreferenceService), RentalEntityMapper.INSTANCE)
    }


    def 'createRental should convert rentalItemRequest to rental entity and save to database'() {

        given:

        def rentalItemRequest = new RentalItemRequest()
                .rentOf(RentalItemRequest.RentOfEnum.ROOM)
                .location(new Address().address1("Amity Moor Rd").city('Westerville').zip(43081))
                .userId("3793db49-8ae7-440c-918c-48ae6d621fa4")
                .title("Balance force in the universe")
                .price(new RentalItemPrice().negotiable(true).value(new BigDecimal("100.12")))

        def rentalEntityLocal = new RentalEntity()
        UUID rentalId = UUID.randomUUID()
        rentalEntityLocal.setRentalId(rentalId)
        subject.rentalEntityRepository.save(_ as RentalEntity) >> rentalEntityLocal
        when:
        def response = subject.createRental(rentalItemRequest)

        then:

      subject.rentalEntityRepository.save(_ as RentalEntity) >> {
            arguments ->
                rentalEntity = arguments[0]

                rentalEntity.title == "Balance force in the universe"

        }


//        rentalEntity.getRentOf() == "ROOM"
//        rentalEntity.getTitle() == "Balance force in the universe"
//        rentalEntity.getPrice() == new BigDecimal("100.12")
//        rentalEntity.isNegotiable()
//        rentalEntity.getLocation().get(0).getAddress1() == "Amity Moor Rd"


        response.getRentalId() == rentalId.toString()

    }
}
