package org.emela.chautari.mapper


import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.domain.ReviewEntity
import org.emela.chautari.domain.Star
import org.emela.chautari.model.RentalItemPrice
import org.emela.chautari.model.RentalItemRequest
import org.emela.chautari.model.Review
import spock.lang.Specification

class ReviewEntityMapperSpec extends Specification {

    def subject = ReviewEntityMapper.INSTANCE

    def 'mapToReviewEntity should convert review to reviewEntity'() {
        given:
        Review review = new Review().comment("test-comment")
                .star(5)
                .reviewer("7d901a6a-ce7b-11ea-87d0-0242ac130003")

        when:
        def result = subject.mapToReviewEntity(review)

        then:
        result != null
        result.getComment() == review.getComment()
        result.getStar() == review.getStar()
    }

    def 'mapToReview should convert reviewEntity to review'() {

        given:
        ReviewEntity  reviewEntity = new ReviewEntity()
        reviewEntity.setStar(4)
        reviewEntity.setComment("test-comment")

        when:
        def result = subject.mapToReview(reviewEntity)

        then:
        result != null
        result.getComment() == reviewEntity.getComment()
        result.getStar().toString() == reviewEntity.getStar().toString()
    }

}
