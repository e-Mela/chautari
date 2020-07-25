package org.emela.chautari.controller;

import io.swagger.annotations.ApiParam;
import org.emela.chautari.api.RentsApi;
import org.emela.chautari.model.*;
import org.emela.chautari.service.RentalService;
import org.emela.chautari.service.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-19T21:21:27.227-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.chautariRentalService.base-path:/chautari}")
public class RentsApiController implements RentsApi {

    private RentalService rentalService;
    private ResourceService resourceService;

    public RentsApiController(final RentalService rentalService, ResourceService resourceService) {
        this.rentalService = rentalService;
        this.resourceService = resourceService;
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
    public ResponseEntity<ResourceDetail> getResource(String resourceId, String rentalId) {
        return ResponseEntity.ok(resourceService.getResource(resourceId, rentalId));
    }

    @Override
    public ResponseEntity<ResourceResponseBean> resourceUpload(String userId, String rentalId,
                                                                 List<MultipartFile> files) {
        return ResponseEntity.ok(resourceService.uploadResources(userId, rentalId, files));
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
}
