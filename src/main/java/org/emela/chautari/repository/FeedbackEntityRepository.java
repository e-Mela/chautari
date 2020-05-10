package org.emela.chautari.repository;

import org.emela.chautari.domain.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackEntityRepository extends JpaRepository<FeedbackEntity, Long> {
}
