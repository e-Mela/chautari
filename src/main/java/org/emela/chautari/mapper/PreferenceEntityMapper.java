package org.emela.chautari.mapper;

import org.emela.chautari.domain.PreferenceEntity;
import org.emela.chautari.model.RentalItemPreference;
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
public interface PreferenceEntityMapper  extends BaseMapper{

    PreferenceEntityMapper INSTANCE = Mappers.getMapper(PreferenceEntityMapper.class);


    @Mapping(target = "rentalEntity", ignore = true)
    @Mapping(target = "id", ignore = true)
    PreferenceEntity mapToPreferenceEntity(RentalItemPreference rentalItemPreference);

    @InheritInverseConfiguration
    RentalItemPreference mapToRentalItemPreference(PreferenceEntity preferenceEntity);

}
