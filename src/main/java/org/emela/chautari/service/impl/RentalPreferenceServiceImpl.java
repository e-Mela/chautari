package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.emela.chautari.domain.PreferenceEntity;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.mapper.PreferenceEntityMapper;
import org.emela.chautari.model.RentalItemPreference;
import org.emela.chautari.repository.PreferenceEntityRepository;
import org.emela.chautari.service.RentalPreferenceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class RentalPreferenceServiceImpl implements RentalPreferenceService {

    private final PreferenceEntityRepository preferenceEntityRepository;
    private final PreferenceEntityMapper preferenceEntityMapper;

    public RentalPreferenceServiceImpl(final PreferenceEntityRepository preferenceEntityRepository,
                                       final PreferenceEntityMapper preferenceEntityMapper) {
        this.preferenceEntityRepository = preferenceEntityRepository;
        this.preferenceEntityMapper = preferenceEntityMapper;
    }

    @Override
    public List<PreferenceEntity> createRentalItemPreferenceEntity(List<RentalItemPreference> preferenceList,
                                                                   RentalEntity  rentalEntity){
        List<PreferenceEntity> preferenceEntities = new ArrayList<>();
        preferenceList.forEach(rentalItemPreference -> {
            PreferenceEntity preferenceEntity = preferenceEntityMapper.mapToPreferenceEntity(rentalItemPreference);
            preferenceEntity.setRentalEntity(rentalEntity);
            preferenceEntities.add(preferenceEntityRepository.save(preferenceEntity));
        });
        log.debug("Rental item preference has saved successfully for rental-id {} ", rentalEntity.getRentalId());
        return preferenceEntities;
    }
}
