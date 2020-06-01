package org.emela.chautari.mapper;

import org.emela.chautari.domain.CredentialEntity;
import org.emela.chautari.model.Credential;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface CredentialEntityMapper extends BaseMapper {

    CredentialEntityMapper INSTANCE = Mappers.getMapper(CredentialEntityMapper.class);

    CredentialEntity toCredentialEntity(Credential credential);

    @InheritInverseConfiguration
    Credential toCredential(CredentialEntity entity);
}
