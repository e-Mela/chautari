package org.emela.chautari.mapper

import org.emela.chautari.domain.AvailabilityEntity
import org.emela.chautari.model.Availability
import org.emela.chautari.model.Duration
import spock.lang.Specification

import java.time.OffsetDateTime

class AvailabilityEntityMapperSpec extends Specification {

    def mapper = AvailabilityEntityMapper.INSTANCE

    def 'mapToFeatureEntity should convert feature to featureEntity'() {
        given:
        Availability available = new Availability()
                .duration(
                        new Duration()
                                .startDate(OffsetDateTime.parse("2020-05-03T10:15:30+01:00"))
                                .endDate(OffsetDateTime.parse("2020-05-03T10:15:30+01:00")))
                .available(true)

        when:
        def result = mapper.mapToAvailabilityEntity()

        then:
        result != null
        result.isAvailable()
        result.getStartDate() == available.getDuration().getStartDate()
        result.getEndDate() == available.getDuration().getEndDate()
    }

    def 'mapToAvailability should convert availabilityEntity to availability'() {
        given:
        AvailabilityEntity entity = new AvailabilityEntity()
        entity.setAvailable(true)
        entity.startDate(OffsetDateTime.parse("2020-05-03T10:15:30+01:00"))

        when:
        def result = mapper.mapToFeature(entity)

        then:
        result != null
        result.getAvailable()
        result.getFeature() == "Baby Yoda has power"
    }
}
