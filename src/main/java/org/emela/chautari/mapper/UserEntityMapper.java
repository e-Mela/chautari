package org.emela.chautari.mapper;

import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.UserAccountDetail;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface UserEntityMapper extends BaseMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

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
