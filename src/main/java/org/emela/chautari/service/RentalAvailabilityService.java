package org.emela.chautari.service;

import org.emela.chautari.domain.AvailabilityEntity;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.model.Availability;

import java.util.List;

public interface RentalAvailabilityService {

     List<AvailabilityEntity> createRentalItemAvailabilityEntity(List<Availability> availabilities, RentalEntity rentalEntity);
}
