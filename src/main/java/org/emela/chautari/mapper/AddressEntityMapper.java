package org.emela.chautari.mapper;

import org.emela.chautari.domain.AddressEntity;
import org.emela.chautari.model.Address;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface AddressEntityMapper extends BaseMapper {

    AddressEntityMapper INSTANCE = Mappers.getMapper(AddressEntityMapper.class);

    @Mapping(source = "zip", target = "zipCode")
    AddressEntity toAddressEntity(Address source);

    @InheritInverseConfiguration
    Address toAddress(AddressEntity entity);
}
