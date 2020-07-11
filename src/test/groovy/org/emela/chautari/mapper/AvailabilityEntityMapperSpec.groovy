package org.emela.chautari.mapper

import org.emela.chautari.domain.AvailabilityEntity
import org.emela.chautari.model.Availability
import org.emela.chautari.model.Duration
import spock.lang.Specification

import static java.time.OffsetDateTime.parse

class AvailabilityEntityMapperSpec extends Specification {

    def mapper = AvailabilityEntityMapper.INSTANCE

    def 'mapToFeatureEntity should convert feature to featureEntity'() {
        given:
        Availability available = new Availability()
                .duration(
                        new Duration()
                                .startDate(parse("2020-05-03T10:15:30+01:00"))
                                .endDate(parse("2020-05-03T10:15:30+01:00")))
                .available(true)

        when:
        def result = mapper.mapToAvailabilityEntity(available)

        then:
        result != null
        result.isAvailable()
        result.getStartDate() == available.getDuration().getStartDate()
        result.getEndDate() == available.getDuration().getEndDate()
    }

    def 'mapToAvailability should convert availabilityEntity to availability'() {
        given:
        AvailabilityEntity entity = new AvailabilityEntity()
        entity.setAvailable(false)
        entity.setStartDate(parse("2020-05-03T10:15:30+01:00"))
        entity.setEndDate(parse("2020-07-03T10:15:30+01:00"))

        when:
        def result = mapper.mapToAvailability(entity)

        then:
        result != null
        !result.getAvailable()
        result.getDuration().getStartDate() == entity.getStartDate()
        result.getDuration().getEndDate() == entity.getEndDate()
    }
}
