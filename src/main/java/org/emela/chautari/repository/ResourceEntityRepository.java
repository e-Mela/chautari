package org.emela.chautari.repository;

import org.emela.chautari.domain.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResourceEntityRepository extends JpaRepository<ResourceEntity, Long> {

    Optional<ResourceEntity> findByResourceId(UUID resourceId);
}
