package org.emela.chautari.service;

import org.emela.chautari.model.ResourceDetail;
import org.emela.chautari.model.ResourceResponse;
import org.emela.chautari.model.ResourceResponseList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResourceService {
    ResourceResponse uploadResource(String userId, String rentalId, MultipartFile file);

    ResourceResponseList uploadResources(String userId, String rentalId, List<MultipartFile> files);

    ResourceDetail getResource(String resourceId, String rentalId);

    ResourceResponse deleteResource(String resourceId, String rentalId);
}
