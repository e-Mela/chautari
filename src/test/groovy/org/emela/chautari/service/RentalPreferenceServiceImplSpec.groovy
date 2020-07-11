package org.emela.chautari.service


import org.emela.chautari.domain.PreferenceEntity
import org.emela.chautari.domain.Priority
import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.mapper.PreferenceEntityMapper
import org.emela.chautari.model.RentalItemPreference
import org.emela.chautari.repository.PreferenceEntityRepository
import org.emela.chautari.service.impl.RentalPreferenceServiceImpl
import spock.lang.Specification

class RentalPreferenceServiceImplSpec extends Specification {

    def subject
    PreferenceEntity preferenceEntity

    def setup() {
        subject = new RentalPreferenceServiceImpl(Mock(PreferenceEntityRepository.class), PreferenceEntityMapper.INSTANCE)
    }

    def 'createRentalItemPreferenceEntity should convert preference to preference entity and save to database'() {
        given:
        def rental = new RentalEntity()
        ArrayList preferences = new ArrayList()
        preferences.add(new RentalItemPreference().preference('Baby Yoda').priority(RentalItemPreference.PriorityEnum.HIGH))

        when:
        subject.createRentalItemPreferenceEntity(preferences as List, rental as RentalEntity)

        then:
        1 * subject.preferenceEntityRepository.save(_ as PreferenceEntity) >> { arguments -> preferenceEntity = arguments[0] }
        preferenceEntity instanceof PreferenceEntity
        preferenceEntity != null
        preferenceEntity.getPreference() == 'Baby Yoda'
        preferenceEntity.getPriority() == Priority.HIGH
    }
}
