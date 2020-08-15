package org.emela.chautari.controller;

import io.swagger.annotations.ApiParam;
import org.emela.chautari.api.RentsApi;
import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
import org.emela.chautari.model.RentalItemResponse;
import org.emela.chautari.model.RentalItemSummary;
import org.emela.chautari.model.ResourceResponse;
import org.emela.chautari.model.Review;
import org.emela.chautari.model.ReviewResponse;
import org.emela.chautari.model.Reviews;
import org.emela.chautari.service.RentalService;
import org.emela.chautari.service.ResourceService;
import org.emela.chautari.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-19T21:21:27.227-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.chautariRentalService.base-path:/chautari}")
public class RentsApiController implements RentsApi {

    private RentalService rentalService;
    private ResourceService resourceService;
    private ReviewService reviewService;

    public RentsApiController(final RentalService rentalService, ResourceService resourceService, ReviewService reviewService) {
        this.rentalService = rentalService;
        this.resourceService = resourceService;
        this.reviewService = reviewService;
    }

    @Override
    public ResponseEntity<RentalItemResponse> createRental(
            @ApiParam(value = "") @Valid @RequestBody RentalItemRequest rentalItemRequest) {
        return new ResponseEntity(rentalService.createRental(rentalItemRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RentalItemResponse> deleteRental(String rentalId) {
        return ResponseEntity.ok(rentalService.deleteRental(rentalId));
    }

    @Override
    public ResponseEntity<RentalItemDetail> getRentalItems(String rentalId) {
        return ResponseEntity.ok(rentalService.getRentalItemDetail(rentalId));
    }

    @Override
    public ResponseEntity<List<RentalItemSummary>> getRentals(@Valid String title, @Valid String location,
                                                              @Valid String type, @Valid String availability, @Valid String feature, @Valid String preference) {
        return ResponseEntity.ok(rentalService.getRentalItems(title, location, type, availability, feature,
                preference));
    }


    @Override
    public ResponseEntity<ResourceResponse> deleteResource(String resourceId, String rentalId) {
        return ResponseEntity.ok(resourceService.deleteResource(resourceId, rentalId));
    }

    @Override
    public ResponseEntity<RentalItemResponse> updateRental(String rentalId,
                                                           @Valid RentalItemRequest rentalItemRequest) {
        return ResponseEntity.ok(rentalService.updateRental(rentalId, rentalItemRequest));
    }

    @Override
    public ResponseEntity<Reviews> getReviews(String rentalId) {
        return new ResponseEntity(reviewService.getReviews(rentalId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReviewResponse> addReview(String rentalId, @Valid Review review) {
        return new ResponseEntity(reviewService.addReview(rentalId, review), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteReview(String rentalId, String reviewId) {
        return new ResponseEntity(reviewService.deleteReview(rentalId, reviewId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Review> getReview(String rentalId, String reviewId) {
        return new ResponseEntity(reviewService.getReview(rentalId, reviewId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReviewResponse> updateReview(String rentalId, String reviewId, @Valid Review review) {
        return new ResponseEntity(reviewService.updateReview(rentalId, reviewId, review), HttpStatus.OK);
    }
}
