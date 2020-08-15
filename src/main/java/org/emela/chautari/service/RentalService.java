package org.emela.chautari.service;

import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
import org.emela.chautari.model.RentalItemResponse;
import org.emela.chautari.model.RentalItemSummary;

import java.util.List;

public interface RentalService {

    RentalItemResponse createRental(RentalItemRequest rentalItemRequest);

    RentalItemResponse deleteRental(String rentalId);

    RentalItemDetail getRentalItemDetail(String rentalId);

    List<RentalItemSummary> getRentalItems(String title, String location, String type, String availability, String feature, String preference);

    RentalItemResponse updateRental(String rentalId, RentalItemRequest rentalItemRequest);

    RentalEntity getRentalEntity(String rentalId);
}
