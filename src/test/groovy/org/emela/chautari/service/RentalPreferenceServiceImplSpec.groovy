package org.emela.chautari.service

import org.emela.chautari.domain.FeatureEntity
import org.emela.chautari.domain.PreferenceEntity
import org.emela.chautari.domain.Priority
import org.emela.chautari.domain.UserEntity
import org.emela.chautari.mapper.FeatureEntityMapper
import org.emela.chautari.mapper.PreferenceEntityMapper
import org.emela.chautari.model.RentalItemPreference
import org.emela.chautari.repository.FeatureEntityRepository
import org.emela.chautari.repository.PreferenceEntityRepository
import org.emela.chautari.service.impl.RentalFeatureServiceImpl
import org.emela.chautari.service.impl.RentalPreferenceServiceImpl
import spock.lang.Specification

class RentalPreferenceServiceImplSpec extends Specification {

    def subject
    PreferenceEntity preferenceEntity

    def setup() {
        subject = new RentalPreferenceServiceImpl(Mock(PreferenceEntityRepository.class), PreferenceEntityMapper.INSTANCE)
    }

    def 'createRentalItemFeatureEntity should convert preference to preference entity and save to database'() {
        given:
        def user = new UserEntity()
        ArrayList preferences = new ArrayList()
        preferences.add(new RentalItemPreference().preference('Baby Yoda').priority(RentalItemPreference.PriorityEnum.HIGH))

        when:
        subject.createRentalItemPreferenceEntity(preferences as List, user as UserEntity)

        then:
        1 * subject.preferenceEntityRepository.save(_ as PreferenceEntity) >> { arguments -> preferenceEntity = arguments[0] }
        preferenceEntity instanceof FeatureEntity
        preferenceEntity != null
        preferenceEntity.getPreference() == 'Baby Yoda'
        preferenceEntity.getPriority() == Priority.HIGH
    }
}
