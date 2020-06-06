package org.emela.chautari.service;

import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
import org.emela.chautari.model.RentalItemResponse;

public interface RentalService {

    RentalItemResponse createRental(RentalItemRequest rentalItemRequest);

    RentalItemResponse deleteRental(String rentalId);

    RentalItemDetail getRentalItems(String rentalId);
}
