package org.emela.chautari.mapper;

import org.emela.chautari.domain.SecurityQuestionEntity;
import org.emela.chautari.model.SecurityQuestion;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface SecurityQuestionEntityMapper extends BaseMapper {
    SecurityQuestionEntityMapper INSTANCE = Mappers.getMapper(SecurityQuestionEntityMapper.class);

    @Mapping(ignore = true, target = "credentialEntity")
    SecurityQuestionEntity toSecurityQuestionEntity(SecurityQuestion securityQuestion);

    @InheritInverseConfiguration
    SecurityQuestion toSecurityQuestion(SecurityQuestionEntity entity);
}
