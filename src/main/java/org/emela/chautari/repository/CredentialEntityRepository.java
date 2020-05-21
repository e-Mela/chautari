package org.emela.chautari.repository;

import org.emela.chautari.domain.CredentialEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredentialEntityRepository extends CrudRepository<CredentialEntity, Long> {

    Optional<CredentialEntity> findByUserNameAndPassword(String userName, String password);

    Optional<CredentialEntity> findByUserName(String userName);
}
