package org.emela.chautari.mapper

import org.emela.chautari.domain.FeatureEntity
import org.emela.chautari.model.Feature
import spock.lang.Specification

class FeatureEntityMapperSpec extends Specification {

    def mapper = FeatureEntityMapper.INSTANCE

    def 'mapToFeatureEntity should convert feature to featureEntity'() {
        given:
        Feature feature = new Feature().feature("Baby Yoda has power").available(true)

        when:
        def result = mapper.mapToFeatureEntity(feature)

        then:
        result != null
        result.isAvailable()
        result.getFeature() == "Baby Yoda has power"
    }

    def 'mapToFeature should convert featureEntity to feature'() {
        given:
        FeatureEntity entity = new FeatureEntity()
        entity.setAvailable(true)
        entity.setFeature("Baby Yoda has power")

        when:
        def result = mapper.mapToFeature(entity)

        then:
        result != null
        result.getAvailable()
        result.getFeature() == "Baby Yoda has power"
    }
}
