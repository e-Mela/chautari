package org.emela.chautari.repository;

import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.domain.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, Long> {

    Optional<List<ReviewEntity>> findByRental(RentalEntity rentalEntity);

    void deleteByReviewId(UUID reviewId);

    Optional<ReviewEntity> findByReviewId(UUID reviewId);
}
