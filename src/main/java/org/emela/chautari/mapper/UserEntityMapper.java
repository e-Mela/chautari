package org.emela.chautari.mapper;


import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.UserDetail;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface UserEntityMapper extends BaseMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(source = "person.title", target = "title")
    @Mapping(source = "person.firstName", target = "firstName")
    @Mapping(source = "person.middleName", target = "middleName")
    @Mapping(source = "person.lastName", target = "lastName")
    @Mapping(source = "contact.phoneNumber", target = "phone")
    @Mapping(source = "contact.email", target = "email")
    @Mapping(ignore = true, target = "credential")
    @Mapping(ignore = true, target = "addresses")
    UserEntity toUserEntity(UserDetail userDetail);

    @InheritInverseConfiguration
    UserDetail toUserDetail(UserEntity userEntity);
}
