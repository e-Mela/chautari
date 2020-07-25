package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.emela.chautari.domain.RentalEntity;
import org.emela.chautari.domain.ResourceEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.exception.RentalServiceException;
import org.emela.chautari.exception.ResourceNotFoundException;
import org.emela.chautari.model.ResourceDetail;
import org.emela.chautari.model.ResourceResponse;
import org.emela.chautari.model.ResourceResponseBean;
import org.emela.chautari.repository.ResourceEntityRepository;
import org.emela.chautari.service.RentalService;
import org.emela.chautari.service.ResourceService;
import org.emela.chautari.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
public class RentalResourceServiceImpl implements ResourceService {
    private UserService userService;
    private RentalService rentalService;
    private ResourceEntityRepository resourceEntityRepository;

    public RentalResourceServiceImpl(UserService userService, RentalService rentalService,
                                     ResourceEntityRepository resourceEntityRepository) {
        this.userService = userService;
        this.rentalService = rentalService;
        this.resourceEntityRepository = resourceEntityRepository;
    }


    @Override
    public ResourceResponse uploadResource(String userId, String rentalId, MultipartFile file) {
        UserEntity user = userService.getUserEntity(userId);
        RentalEntity rentalEntity = rentalService.getRentalEntity(rentalId);

        ResourceEntity resourceEntity = BuildResourceEntity(file, user, rentalEntity);

        return buildResourceResponse(resourceEntityRepository.save(resourceEntity).getResourceId());
    }

    @Override
    public ResourceResponseBean uploadResources(String userId, String rentalId, List<MultipartFile> files) {
        UserEntity user = userService.getUserEntity(userId);
        RentalEntity rentalEntity = rentalService.getRentalEntity(rentalId);

        List<ResourceEntity> resourceEntities = files.stream()
                .map(it -> BuildResourceEntity(it, user, rentalEntity)).collect(Collectors.toList());

        List<ResourceEntity> savedEntities = resourceEntityRepository.saveAll(resourceEntities);

        List<ResourceResponse> resourceResponses = CollectionUtils.emptyIfNull(savedEntities).stream()
                .map(it -> buildResourceResponse(it.getResourceId())).collect(Collectors.toList());

        return new ResourceResponseBean().message("success").resourceResponse(resourceResponses).status("success");
    }

    @Override
    public ResourceDetail getResource(String resourceId, String rentalId) {
        ResourceEntity resourceDetail;
        try {
            resourceDetail = resourceEntityRepository.findByResourceId(UUID.fromString(resourceId))
                    .orElseThrow(ResourceNotFoundException::new);
            return new ResourceDetail().resourceId(resourceDetail.getResourceId().toString())
                    .file(resourceDetail.getResourceFile()).message("Success");
        } catch (Exception e) {
            log.error("resource not found", e);
            throw new RentalServiceException(e);
        }
    }

    @Override
    public ResourceResponse deleteResource(String resourceId, String rentalId) {
        log.info("resource delete request has received for resource-id {} ", resourceId);
        try {
            ResourceEntity resourceEntity = resourceEntityRepository.findByResourceId(UUID.fromString(resourceId))
                    .orElseThrow(ResourceNotFoundException::new);
            resourceEntityRepository.delete(resourceEntity);
        } catch (Exception e) {
            log.error("Delete resource Item failed", e);
            throw new RentalServiceException(e);
        }
        return new ResourceResponse().resourceId(rentalId).message("success");
    }


    private ResourceEntity BuildResourceEntity(MultipartFile file, UserEntity user, RentalEntity rentalEntity) {
        ResourceEntity resourceEntity = new ResourceEntity();
        resourceEntity.setUser(user);
        resourceEntity.setRental(rentalEntity);
        try {
            resourceEntity.setResourceFile(file.getBytes());
            resourceEntity.setResourceName(file.getOriginalFilename());
        } catch (Exception e) {
            log.error("invalid file");
            throw new RentalServiceException(e);
        }
        return resourceEntity;
    }

    private ResourceResponse buildResourceResponse(UUID resourceId) {
        return new ResourceResponse().resourceId(resourceId.toString()).message("success").status("success");
    }
}
