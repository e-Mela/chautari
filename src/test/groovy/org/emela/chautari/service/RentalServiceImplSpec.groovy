package org.emela.chautari.service

import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.exception.RentalServiceException
import org.emela.chautari.mapper.RentalEntityMapper
import org.emela.chautari.model.Address
import org.emela.chautari.model.RentalItemPrice
import org.emela.chautari.model.RentalItemRequest
import org.emela.chautari.repository.RentalEntityRepository
import org.emela.chautari.service.impl.RentalServiceImpl
import org.hibernate.HibernateException
import spock.lang.Specification

class RentalServiceImplSpec extends Specification {

    def subject

    def setup() {

        subject = new RentalServiceImpl(Mock(RentalEntityRepository), Mock(RentalAvailabilityService),
                Mock(RentalFeatureService), Mock(RentalPreferenceService), RentalEntityMapper.INSTANCE,
                Mock(AddressService), Mock(UserService))
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
        response.getRentalId() == rentalId.toString()

    }

    def 'createRental should throw exception when entity save operation fails'() {

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
        1 * subject.rentalEntityRepository.save(_ as RentalEntity) >> {
            throw new HibernateException("Can't save the " +
                    "entity")
        }
        when:
        subject.createRental(rentalItemRequest)

        then:
        RentalServiceException exception = thrown()

    }

    def 'deleteRental should delete rental entity from database'() {

        given:
        def rentalEntityLocal = new RentalEntity()
        UUID rentalId = UUID.randomUUID()
        rentalEntityLocal.setRentalId(rentalId)
        subject.rentalEntityRepository.findByRentalId(_) >> Optional.of(rentalEntityLocal)

        when:
        def response = subject.deleteRental(rentalId.toString())

        then:
        response.getRentalId() == rentalId.toString()

    }


    def 'deleteRental should throw exception when delete operation fails'() {

        given:
        def rentalEntityLocal = new RentalEntity()
        UUID rentalId = UUID.randomUUID()
        rentalEntityLocal.setRentalId(rentalId)
        subject.rentalEntityRepository.findByRentalId(_) >> Optional.of(rentalEntityLocal)
        subject.rentalEntityRepository.delete(_) >> {
            throw new HibernateException("Can't delete the " +
                    "entity")
        }

        when:
        subject.deleteRental(rentalId.toString())

        then:
        RentalServiceException exception = thrown()

    }

    def 'updateRental should convert rentalItemRequest to rental entity and update the existing entity'() {

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
        subject.rentalEntityRepository.findByRentalId(_) >> Optional.of(rentalEntityLocal)
        subject.rentalEntityRepository.save(_ as RentalEntity) >> rentalEntityLocal

        when:
        def response = subject.updateRental(rentalId.toString(), rentalItemRequest)

        then:
        response.getRentalId() == rentalId.toString()

    }

    def 'updateRental should throw exception when update operation fails'() {

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
        subject.rentalEntityRepository.findByRentalId(_) >> Optional.of(rentalEntityLocal)
        subject.rentalEntityRepository.save(_ as RentalEntity) >> {
            throw new HibernateException("Can't update the " +
                    "entity")
        }

        when:
        subject.updateRental(rentalId.toString(), rentalItemRequest)

        then:
        RentalServiceException exception = thrown()

    }
}
