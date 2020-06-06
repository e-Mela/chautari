package org.emela.chautari.mapper;

import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.model.RentalItemRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface RentalEntityMapper extends BaseMapper {

    RentalEntityMapper INSTANCE = Mappers.getMapper(RentalEntityMapper.class);

    @Mapping(target = "lastUpdatedUser", ignore = true)
    @Mapping(target = "lastUpdatedOn", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "availabilityEntity", ignore = true)
    @Mapping(target = "resources", ignore = true)
    @Mapping(target = "rentalId", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdUser", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "features", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    @Mapping(target = "price", source = "price.value")
    @Mapping(target = "negotiable", source = "price.negotiable")
    @Mapping(target = "postedOn", qualifiedByName = "convertZonedDateTime")
    RentalEntity mapToRentalEntity(RentalItemRequest rentalItemRequest);

    @InheritInverseConfiguration
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "features", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    @Mapping(target = "availability", ignore = true)
    RentalItemRequest mapToRentalItemRequest(RentalEntity rentalEntity);


    @Named("convertZonedDateTime")
    default ZonedDateTime convertZonedDateTime(RentalItemRequest rentalItemRequest) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return ZonedDateTime.parse(rentalItemRequest.getPostedOn(), dateTimeFormatter);
    }


}
