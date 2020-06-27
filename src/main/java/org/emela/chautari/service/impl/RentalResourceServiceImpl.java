package org.emela.chautari.service.impl;

import org.emela.chautari.repository.ResourceEntityRepository;
import org.emela.chautari.service.RentalResourceService;
import org.springframework.stereotype.Service;

@Service
public class RentalResourceServiceImpl implements RentalResourceService {

    private final ResourceEntityRepository resourceEntityRepository;

    public RentalResourceServiceImpl(final ResourceEntityRepository resourceEntityRepository) {
        this.resourceEntityRepository = resourceEntityRepository;
    }
}
