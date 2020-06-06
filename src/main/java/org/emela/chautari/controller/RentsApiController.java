package org.emela.chautari.controller;

import io.swagger.annotations.ApiParam;
import org.emela.chautari.api.RentsApi;
import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
import org.emela.chautari.model.RentalItemResponse;
import org.emela.chautari.model.RentalItemSummary;
import org.emela.chautari.model.ResourceResponse;
import org.emela.chautari.service.RentalService;
import org.springframework.core.io.Resource;
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

    public RentsApiController(final RentalService rentalService) {
        this.rentalService = rentalService;
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
        return ResponseEntity.ok(rentalService.getRentalItems(rentalId));
    }

    @Override
    public ResponseEntity<List<RentalItemSummary>> getRentals(@Valid String title, @Valid String location,
            @Valid String type, @Valid String availability, @Valid String feature, @Valid String preference) {
        return null;
    }

    @Override
    public ResponseEntity<Resource> getResource(String resourceId) {
        return null;
    }

    @Override
    public ResponseEntity<List<ResourceResponse>> resourceUpload(String userId, String rentalId,
            @Valid MultipartFile file) {
        return null;
    }

    @Override
    public ResponseEntity<RentalItemResponse> updateRental(String rentalId,
            @Valid RentalItemRequest rentalItemRequest) {
        return null;
    }
}
