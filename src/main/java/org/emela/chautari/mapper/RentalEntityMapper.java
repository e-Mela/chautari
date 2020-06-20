package org.emela.chautari.mapper;

import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
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
public interface RentalEntityMapper extends BaseMapper {

    RentalEntityMapper INSTANCE = Mappers.getMapper(RentalEntityMapper.class);

    @Mapping(target = "status", ignore = true)
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
    RentalEntity mapToRentalEntity(RentalItemRequest rentalItemRequest);

    @InheritInverseConfiguration
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "features", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    @Mapping(target = "availability", ignore = true)
    RentalItemRequest mapToRentalItemRequest(RentalEntity rentalEntity);


    @Mapping(target = "availability", ignore = true)
    @Mapping(target = "features", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "imageIds", ignore = true)
    @Mapping(target = "viewedBy", ignore = true)
    @Mapping(target = "postedBy", source = "user")
    @Mapping(target = "price.value", source = "price", numberFormat = "#.00")
    RentalItemDetail mapToRentalItemDetail(RentalEntity rentalEntity);


}
