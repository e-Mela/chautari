package org.emela.chautari.mapper;

import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.UserAccountDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface UserEntityMapper extends BaseMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "user.person.title", target = "title")
    @Mapping(source = "user.person.firstName", target = "firstName")
    @Mapping(source = "user.person.middleName", target = "middleName")
    @Mapping(source = "user.person.lastName", target = "lastName")
    @Mapping(source = "contact.phoneNumber", target = "phone")
    @Mapping(source = "contact.email", target = "email")
    @Mapping(ignore = true, target = "credential")
    @Mapping(ignore = true, target = "addresses")
    UserEntity toUserEntity(UserAccountDetail userDetail);

    @InheritInverseConfiguration
    UserAccountDetail toUserAccountDetail(UserEntity userEntity);
}
