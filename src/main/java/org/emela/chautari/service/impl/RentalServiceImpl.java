package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.domain.ResourceEntity;
import org.emela.chautari.exception.RentalServiceException;
import org.emela.chautari.exception.ResourceNotFoundException;
import org.emela.chautari.mapper.RentalEntityMapper;
import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
import org.emela.chautari.model.RentalItemResponse;
import org.emela.chautari.model.RentalItemSummary;
import org.emela.chautari.repository.RentalEntityRepository;
import org.emela.chautari.service.RentalAvailabilityService;
import org.emela.chautari.service.RentalFeatureService;
import org.emela.chautari.service.RentalPreferenceService;
import org.emela.chautari.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
            mapAndSaveRentalAssociatedEntity(rentalItemRequest, rentalEntity);

        } catch (Exception e) {
            log.error("Rental creation failed", e);
            throw new RentalServiceException(e);
        }
        log.debug("Rental Item has created successfully rental-id {} for user-id {}",
                rentalEntity.getRentalId(), rentalItemRequest.getUserId());
        return new RentalItemResponse().rentalId(rentalEntity.getRentalId().toString());
    }

    private void mapAndSaveRentalAssociatedEntity(RentalItemRequest rentalItemRequest, RentalEntity rentalEntity) {
        rentalAvailabilityService.createRentalItemAvailabilityEntity(rentalItemRequest.getAvailability(),
                rentalEntity);
        rentalFeatureService.createRentalItemFeatureEntity(rentalItemRequest.getFeatures(), rentalEntity);
        rentalPreferenceService.createRentalItemPreferenceEntity(rentalItemRequest.getPreferences(), rentalEntity);
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
            throw new RentalServiceException(e);
        }
        return new RentalItemResponse().rentalId(rentalId);
    }

    @Override
    public RentalItemDetail getRentalItemDetail(String rentalId) {
        log.info("Rental get request has received for rental-id {} ", rentalId);
        RentalItemDetail rentalItemDetail;
        try {
            RentalEntity rentalEntity = rentalEntityRepository.findByRentalId(UUID.fromString(rentalId))
                    .orElseThrow(ResourceNotFoundException::new);
            rentalItemDetail = rentalEntityMapper.mapToRentalItemDetail(rentalEntity);
            rentalItemDetail.setImageIds(retrieveImagesIds(rentalEntity.getResources()));
            rentalItemDetail.setViewedBy(retrieveTotalView());
        } catch (Exception e) {
            log.error("GET rental Item failed", e);
            throw e;
        }
        return rentalItemDetail;
    }

    @Override
    public List<RentalItemSummary> getRentalItems(String title,
                                                  String location, String type, String availability, String feature, String preference) {
        //TODO: implementation
        return null;
    }

    @Override
    public RentalItemResponse updateRental(String rentalId, RentalItemRequest rentalItemRequest) {
        log.info("Rental get request has received for rental-id {} ", rentalId);
        RentalEntity savedRentalEntity;
        try {
            RentalEntity existingRentalEntity = rentalEntityRepository.findByRentalId(UUID.fromString(rentalId))
                    .orElseThrow(ResourceNotFoundException::new);
            RentalEntity newRentalEntity = rentalEntityMapper.mapToRentalEntity(rentalItemRequest);
            newRentalEntity.setId(existingRentalEntity.getId());
            savedRentalEntity = rentalEntityRepository.save(newRentalEntity);
            mapAndSaveRentalAssociatedEntity(rentalItemRequest, savedRentalEntity);
        } catch (Exception exception) {
            log.error("UPDATE rental Item failed", exception);
            throw new RentalServiceException(exception);
        }
        return new RentalItemResponse().rentalId(savedRentalEntity.getRentalId().toString());
    }


    private Integer retrieveTotalView() {
        //TODO: retrieveTotalViewer from a feedback table
        return 12;
    }

    private List<String> retrieveImagesIds(List<ResourceEntity> resourceEntities) {
        return resourceEntities.stream().map(ResourceEntity::getResourceId)
                .map(UUID::toString).collect(Collectors.toList());

    }

}
