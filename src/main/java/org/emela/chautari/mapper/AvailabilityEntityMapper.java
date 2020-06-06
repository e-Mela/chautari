package org.emela.chautari.mapper;

import org.emela.chautari.domain.AvailabilityEntity;
import org.emela.chautari.model.Availability;
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
public interface AvailabilityEntityMapper  extends BaseMapper{

    AvailabilityEntityMapper INSTANCE = Mappers.getMapper(AvailabilityEntityMapper.class);

    @Mapping(target = "startDate", source = "duration.startDate")
    @Mapping(target = "endDate", source = "duration.endDate")
    @Mapping(target = "rentalEntity", ignore = true)
    @Mapping(target = "id", ignore = true)
    AvailabilityEntity mapToAvailabilityEntity(Availability availability);

    @InheritInverseConfiguration
    Availability mapToAvailability(AvailabilityEntity entity);

}
