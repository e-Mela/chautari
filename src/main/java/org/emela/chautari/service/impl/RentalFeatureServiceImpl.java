package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.emela.chautari.domain.FeatureEntity;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.mapper.FeatureEntityMapper;
import org.emela.chautari.model.Feature;
import org.emela.chautari.repository.FeatureEntityRepository;
import org.emela.chautari.service.RentalFeatureService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class RentalFeatureServiceImpl implements RentalFeatureService {

    private final FeatureEntityRepository featureEntityRepository;
    private final FeatureEntityMapper featureEntityMapper;

    public RentalFeatureServiceImpl(final FeatureEntityRepository featureEntityRepository,
                                    final FeatureEntityMapper featureEntityMapper) {
        this.featureEntityRepository = featureEntityRepository;
        this.featureEntityMapper = featureEntityMapper;
    }

    @Override
    public List<FeatureEntity> createRentalItemFeatureEntity(List<Feature> featureList, RentalEntity rentalEntity) {
        List<FeatureEntity> featureEntities = new ArrayList<>();
        featureList.forEach(feature -> {
            FeatureEntity featureEntity = featureEntityMapper.mapToFeatureEntity(feature);
            featureEntity.setRentalEntity(rentalEntity);
            featureEntities.add(featureEntityRepository.save(featureEntity));
        });
        log.debug("Rental item features has saved successfully for rental-id {} ", rentalEntity.getRentalId());
        return featureEntities;
    }
}
