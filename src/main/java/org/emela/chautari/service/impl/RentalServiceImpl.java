package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.exception.RentalServiceException;
import org.emela.chautari.exception.ResourceNotFoundException;
import org.emela.chautari.mapper.RentalEntityMapper;
import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
import org.emela.chautari.model.RentalItemResponse;
import org.emela.chautari.repository.RentalEntityRepository;
import org.emela.chautari.service.RentalAvailabilityService;
import org.emela.chautari.service.RentalFeatureService;
import org.emela.chautari.service.RentalPreferenceService;
import org.emela.chautari.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class RentalServiceImpl implements RentalService {

    private final RentalEntityRepository rentalEntityRepository;
    private final RentalAvailabilityService rentalAvailabilityService;
    private final RentalFeatureService rentalFeatureService;
    private final RentalPreferenceService rentalPreferenceService;
    private final RentalEntityMapper rentalEntityMapper;


    public RentalServiceImpl(final RentalEntityRepository rentalEntityRepository,
                             final RentalAvailabilityService rentalAvailabilityService,
                             final RentalFeatureService rentalFeatureService,
                             final RentalPreferenceService rentalPreferenceService,
                             final RentalEntityMapper rentalEntityMapper) {
        this.rentalEntityRepository = rentalEntityRepository;
        this.rentalAvailabilityService = rentalAvailabilityService;
        this.rentalFeatureService = rentalFeatureService;
        this.rentalPreferenceService = rentalPreferenceService;
        this.rentalEntityMapper = rentalEntityMapper;
    }

    @Override
    public RentalItemResponse createRental(RentalItemRequest rentalItemRequest) {
        RentalEntity rentalEntity;
        try {
            log.info("Rental creation request has received for user-id {} ", rentalItemRequest.getUserId());
            rentalEntity = rentalEntityRepository.save(rentalEntityMapper.mapToRentalEntity(rentalItemRequest));
            rentalAvailabilityService.createRentalItemAvailabilityEntity(rentalItemRequest.getAvailability(),
                    rentalEntity);
            rentalFeatureService.createRentalItemFeatureEntity(rentalItemRequest.getFeatures(), rentalEntity);
            rentalPreferenceService.createRentalItemPreferenceEntity(rentalItemRequest.getPreferences(), rentalEntity);

        } catch (Exception e) {
            log.error("Rental creation failed", e);
            throw new RentalServiceException(e);
        }
        log.debug("Rental Item has created successfully rental-id {} for user-id {}",
                rentalEntity.getRentalId(), rentalItemRequest.getUserId());
        return new RentalItemResponse().rentalId(rentalEntity.getRentalId().toString());
    }

    @Override
    public RentalItemResponse deleteRental(String rentalId) {
        log.info("Rental delete request has received for rental-id {} ", rentalId);
        try {
            RentalEntity rentalEntity = rentalEntityRepository.findByRentalId(UUID.fromString(rentalId))
                    .orElseThrow(ResourceNotFoundException::new);
            rentalEntityRepository.delete(rentalEntity);
        } catch (Exception e) {
            log.error("Delete rental Item failed", e);
            throw e;
        }
        return new RentalItemResponse().rentalId(rentalId);
    }

    @Override
    public RentalItemDetail getRentalItems(String rentalId) {
        return null;
    }

}
