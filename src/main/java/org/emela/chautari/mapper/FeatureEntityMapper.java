package org.emela.chautari.mapper;

import org.emela.chautari.domain.FeatureEntity;
import org.emela.chautari.model.Feature;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface FeatureEntityMapper extends BaseMapper {

    FeatureEntityMapper INSTANCE = Mappers.getMapper(FeatureEntityMapper.class);

    @Mapping(target = "rentalEntity", ignore = true)
    @Mapping(target = "id", ignore = true)
    FeatureEntity mapToFeatureEntity(Feature feature);

    @InheritInverseConfiguration
    Feature mapToFeature(FeatureEntity entity);
}
