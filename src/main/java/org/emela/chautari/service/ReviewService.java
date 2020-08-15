package org.emela.chautari.service;

import org.emela.chautari.model.Review;
import org.emela.chautari.model.ReviewResponse;
import org.emela.chautari.model.Reviews;

public interface ReviewService {

    Reviews getReviews(String rentalId);

    ReviewResponse addReview(String rentalId, Review review);

    Void deleteReview(String rentalId, String reviewId);

    Review getReview(String rentalId, String reviewId);

    ReviewResponse updateReview(String rentalId, String reviewId, Review review);
}
