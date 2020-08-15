package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.emela.chautari.domain.ReviewEntity;
import org.emela.chautari.exception.ResourceNotFoundException;
import org.emela.chautari.exception.ReviewServiceException;
import org.emela.chautari.mapper.ReviewEntityMapper;
import org.emela.chautari.model.Review;
import org.emela.chautari.model.ReviewResponse;
import org.emela.chautari.model.Reviews;
import org.emela.chautari.repository.ReviewEntityRepository;
import org.emela.chautari.service.RentalService;
import org.emela.chautari.service.ReviewService;
import org.emela.chautari.service.UserService;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Log4j2
@Controller
public class ReviewServiceImpl implements ReviewService {

    private final ReviewEntityRepository reviewEntityRepository;
    private final ReviewEntityMapper reviewEntityMapper;
    private final RentalService rentalService;
    private final UserService userService;

    public ReviewServiceImpl(final ReviewEntityRepository reviewEntityRepository,
                             final ReviewEntityMapper reviewEntityMapper,
                             final RentalService rentalService,
                             final UserService userService) {
        this.reviewEntityRepository = reviewEntityRepository;
        this.reviewEntityMapper = reviewEntityMapper;
        this.rentalService = rentalService;
        this.userService = userService;

    }

    @Override
    public ReviewResponse addReview(String rentalId, Review review) {

        String userId = review.getReviewer();
        log.info("Add review request is received for rentalId {} by userId {}", rentalId, userId);

        ReviewEntity savedReviewEntity;
        try {
            ReviewEntity reviewEntity = reviewEntityMapper.mapToReviewEntity(review);
            reviewEntity.setRental(rentalService.getRentalEntity(rentalId));
            reviewEntity.setUser(userService.getUserEntity(userId));
            savedReviewEntity = reviewEntityRepository.save(reviewEntity);
        } catch (Exception exception) {
            log.error("Add review operation failed for rental id {} by user id {}", rentalId, userId);
            throw new ReviewServiceException("Add review operation failed for rental id " + rentalId + " by user id " + userId, exception);
        }
        return new ReviewResponse().reviewId(savedReviewEntity.getReviewId().toString());
    }

    @Override
    public Reviews getReviews(String rentalId) {
        log.info("Get review details request is received for rentalId {}", rentalId);
        List<Review> reviewList = new ArrayList<>();
        try {
            List<ReviewEntity> reviewEntities =
                    reviewEntityRepository.findByRental(rentalService.getRentalEntity(rentalId))
                            .orElseThrow(ResourceNotFoundException::new);

            reviewEntities.forEach(reviewEntity -> {
                Review review = reviewEntityMapper.mapToReview(reviewEntity);
                review.setReviewer(reviewEntity.getUser().getUserId().toString());
                reviewList.add(review);
            });
            Set<String> a = new HashSet<>();

        } catch (Exception exception) {
            log.error("Get reviews failed for rentalId {}", rentalId);
            throw new ReviewServiceException("Get reviews failed for rentalId {}" + rentalId, exception);
        }
        return new Reviews().reviews(reviewList).averageLike(getAverageLike(reviewList));
    }

    private BigDecimal getAverageLike(List<Review> reviewList) {
        int totalLike =
                reviewList.stream().map(review -> review.getStar().toString()).mapToInt(Integer::valueOf).sum();
        return new BigDecimal(totalLike / reviewList.size()).setScale(1, RoundingMode.CEILING);
    }

    @Override
    public Void deleteReview(String rentalId, String reviewId) {
        log.info("Delete review request is received for rentalId {}  reviewId {}", rentalId, reviewId);
        try {
            reviewEntityRepository.deleteByReviewId(UUID.fromString(reviewId));
        } catch (Exception exception) {
            log.error("Delete review failed for rentalId {}  reviewId {}", rentalId, reviewId);
            throw new ReviewServiceException("Delete review failed for rentalId " + rentalId + "  reviewId {}" + reviewId,
                    exception);
        }
        return null;
    }

    @Override
    public Review getReview(String rentalId, String reviewId) {
        log.info("Get review request is received for rentalId {} reviewId {}", rentalId, reviewId);
        Review review = null;
        try {
            ReviewEntity reviewEntity =
                    reviewEntityRepository.findByReviewId(UUID.fromString(reviewId)).orElseThrow(ResourceNotFoundException::new);
            review = reviewEntityMapper.mapToReview(reviewEntity);
        } catch (Exception exception) {
            log.error("Get review failed  for rentalId {} reviewId {}", rentalId, reviewId);
            throw new ReviewServiceException("Get review failed  for rentalId " + rentalId + " reviewId " + reviewId);
        }
        return review;
    }

    @Override
    public ReviewResponse updateReview(String rentalId, String reviewId, Review review) {
        String userId = review.getReviewer();
        log.info("Add review request is received for rentalId {} reviewId {} by userId {}", rentalId, reviewId,
                userId);
        ReviewEntity newReviewEntity = null;
        try {
            newReviewEntity = reviewEntityMapper.mapToReviewEntity(review);
            ReviewEntity existingReviewEntity =
                    reviewEntityRepository.findByReviewId(UUID.fromString(reviewId)).orElseThrow(ResourceNotFoundException::new);
            newReviewEntity.setId(existingReviewEntity.getId());
            newReviewEntity.setUser(existingReviewEntity.getUser());
            newReviewEntity.setRental(existingReviewEntity.getRental());
            newReviewEntity = reviewEntityRepository.save(newReviewEntity);
        } catch (Exception exception) {
            log.error("Update review failed for rental Id {} review Id {}", rentalId, reviewId);
        }
        assert newReviewEntity != null;
        return new ReviewResponse().reviewId(newReviewEntity.getReviewId().toString());
    }
}
