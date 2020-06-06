package org.emela.chautari.service;

import org.emela.chautari.domain.FeatureEntity;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.model.Feature;

import java.util.List;

public interface RentalFeatureService {

    List<FeatureEntity> createRentalItemFeatureEntity(List<Feature> featureList, RentalEntity rentalEntity);
}
