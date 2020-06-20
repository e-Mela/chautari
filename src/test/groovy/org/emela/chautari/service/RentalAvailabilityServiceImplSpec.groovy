package org.emela.chautari.service


import org.emela.chautari.domain.AvailabilityEntity
import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.mapper.AvailabilityEntityMapper
import org.emela.chautari.model.Availability
import org.emela.chautari.model.Duration
import org.emela.chautari.repository.AvailabilityEntityRepository
import org.emela.chautari.service.impl.RentalAvailabilityServiceImpl
import spock.lang.Specification

import java.time.OffsetDateTime

class RentalAvailabilityServiceImplSpec extends Specification {

    def subject

    AvailabilityEntity availabilityEntity;
    List<AvailabilityEntity> availabilityEntities = new ArrayList<>()
    AvailabilityEntityRepository availabilityEntityRepository

    def setup() {
        subject = new RentalAvailabilityServiceImpl(Mock(AvailabilityEntityRepository), AvailabilityEntityMapper.INSTANCE)
    }

    def 'createRentalItemAvailabilityEntity should convert Availability to availabilityEntity and save to database'() {

        given: 'costumer select availability of rental item'
        List<Availability> availabilities = new ArrayList<>()
        Availability availability = new Availability().available(true).duration(
                new Duration().startDate(OffsetDateTime.parse("2020-01-02T10:15:30+01:00"))
                        .endDate(OffsetDateTime.parse("2020-07-02T10:15:30+01:00")))
        Availability availability1 = new Availability().available(false).duration(
                new Duration().startDate(OffsetDateTime.parse("2020-03-02T10:15:30+01:00"))
                        .endDate(OffsetDateTime.parse("2020-04-02T10:15:30+01:00")))
        availabilities.add(availability)
        availabilities.add(availability1)

        RentalEntity rentalEntity = new RentalEntity()

        when: 'save the availability of rental item into database'
        subject.createRentalItemAvailabilityEntity(availabilities, rentalEntity)

        then:
        2 * subject.availabilityEntityRepository.save(_ as AvailabilityEntity) >> { arguments ->
            availabilityEntity = arguments[0] as AvailabilityEntity
            availabilityEntities.add(availabilityEntity as AvailabilityEntity)
            availabilityEntity
        }

        availabilityEntities.size() == 2

        availabilityEntities.get(0).getStartDate().toString() == "2020-01-02T10:15:30+01:00"
        availabilityEntities.get(0).getEndDate().toString() == "2020-07-02T10:15:30+01:00"
        availabilityEntities.get(0).isAvailable()
        availabilityEntities.get(1).getStartDate().toString() == "2020-03-02T10:15:30+01:00"
        availabilityEntities.get(1).getEndDate().toString() == "2020-04-02T10:15:30+01:00"
        !availabilityEntities.get(1).isAvailable()
    }

}
