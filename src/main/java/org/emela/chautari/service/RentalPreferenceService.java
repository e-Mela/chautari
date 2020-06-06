package org.emela.chautari.service;

import org.emela.chautari.domain.PreferenceEntity;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.model.RentalItemPreference;

import java.util.List;

public interface RentalPreferenceService {

    List<PreferenceEntity> createRentalItemPreferenceEntity(List<RentalItemPreference> preferenceList,
                                                            RentalEntity rentalEntity);

}
