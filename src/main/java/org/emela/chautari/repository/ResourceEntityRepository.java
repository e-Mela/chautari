package org.emela.chautari.repository;

import org.emela.chautari.domain.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceEntityRepository extends JpaRepository<ResourceEntity, Long> {
}
