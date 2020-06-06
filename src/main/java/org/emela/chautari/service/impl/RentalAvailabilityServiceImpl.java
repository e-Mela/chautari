package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.emela.chautari.domain.AvailabilityEntity;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.mapper.AvailabilityEntityMapper;
import org.emela.chautari.model.Availability;
import org.emela.chautari.repository.AvailabilityEntityRepository;
import org.emela.chautari.service.RentalAvailabilityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class RentalAvailabilityServiceImpl implements RentalAvailabilityService {


    private final AvailabilityEntityRepository availabilityEntityRepository;
    private final AvailabilityEntityMapper availabilityEntityMapper;

    public RentalAvailabilityServiceImpl(final AvailabilityEntityRepository availabilityEntityRepository,
                                         final AvailabilityEntityMapper availabilityEntityMapper) {
        this.availabilityEntityRepository = availabilityEntityRepository;
        this.availabilityEntityMapper = availabilityEntityMapper;

    }

    @Override
    public List<AvailabilityEntity> createRentalItemAvailabilityEntity(List<Availability> availabilities,
                                                                       RentalEntity rentalEntity) {
        List<AvailabilityEntity> availabilityEntities = new ArrayList<>();
        availabilities.forEach(availability -> {
            AvailabilityEntity availabilityEntity = availabilityEntityMapper.mapToAvailabilityEntity(availability);
            availabilityEntity.setRentalEntity(rentalEntity);
            availabilityEntities.add(availabilityEntityRepository.save(availabilityEntity));

        });
        log.debug("Rental item availability has saved successfully for rental-id {} ", rentalEntity.getRentalId());
        return availabilityEntities;
    }
}
