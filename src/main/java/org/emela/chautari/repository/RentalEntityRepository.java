package org.emela.chautari.repository;

import org.emela.chautari.domain.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalEntityRepository extends JpaRepository<RentalEntity, Long> {
}
