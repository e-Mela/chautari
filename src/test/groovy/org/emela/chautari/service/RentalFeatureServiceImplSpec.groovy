package org.emela.chautari.service


import org.emela.chautari.domain.FeatureEntity
import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.mapper.FeatureEntityMapper
import org.emela.chautari.model.Feature
import org.emela.chautari.repository.FeatureEntityRepository
import org.emela.chautari.service.impl.RentalFeatureServiceImpl
import spock.lang.Specification

class RentalFeatureServiceImplSpec extends Specification {

    def subject
    FeatureEntity featureEntity

    def setup() {
        subject = new RentalFeatureServiceImpl(Mock(FeatureEntityRepository), FeatureEntityMapper.INSTANCE)
    }

    def 'createRentalItemFeatureEntity should convert Feature to Feature entity and save to database'() {
        given:
        def rentalEntity = new RentalEntity()
        List<Feature> features = new ArrayList()
        features.add(new Feature().feature('hot shower').available(true))

        when:
        subject.createRentalItemFeatureEntity(features, rentalEntity)

        then:
        1 * subject.featureEntityRepository.save(_ as FeatureEntity) >> { arguments -> featureEntity = arguments[0] }
        featureEntity instanceof FeatureEntity
        featureEntity != null
        featureEntity.getFeature() == 'hot shower'
        featureEntity.isAvailable()
    }
}
