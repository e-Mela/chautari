package org.emela.chautari.mapper


import org.emela.chautari.domain.PreferenceEntity
import org.emela.chautari.domain.Priority
import org.emela.chautari.model.RentalItemPreference
import spock.lang.Specification

class PreferenceEntityMapperSpec extends Specification {


    def mapper = PreferenceEntityMapper.INSTANCE

    def 'mapToPreferenceEntity should convert RentalItemPreference to preferenceEntity'() {
        given:
        RentalItemPreference rentalItemPreference = new RentalItemPreference()
                .preference("only for sexy hot girl")
                .priority(RentalItemPreference.PriorityEnum.HIGH)

        when:
        def result = mapper.mapToPreferenceEntity(rentalItemPreference)

        then:
        result != null
        result.getPreference() == "only for sexy hot girl"
        result.getPriority() == Priority.HIGH
    }

    def 'mapToRentalItemPreference should convert preferenceEntity to rentalItemPreference'() {
        given:
        PreferenceEntity entity = new PreferenceEntity()
        entity.setPreference("only for sexy hot girl")
        entity.setPriority(Priority.HIGH)

        when:
        def result = mapper.mapToRentalItemPreference(entity)

        then:
        result != null
        result.getPriority() == RentalItemPreference.PriorityEnum.HIGH
        result.getPreference() == "only for sexy hot girl"
    }
}
