package org.emela.chautari.service.impl

import org.emela.chautari.domain.RentalEntity
import org.emela.chautari.domain.ResourceEntity
import org.emela.chautari.domain.UserEntity
import org.emela.chautari.model.ResourceDetail
import org.emela.chautari.repository.ResourceEntityRepository
import org.emela.chautari.service.RentalService
import org.emela.chautari.service.UserService
import org.springframework.mock.web.MockMultipartFile
import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification

class RentalResourceServiceImplSpec extends Specification {

    def subject

    UUID userId = UUID.randomUUID()
    UUID rentalId = UUID.randomUUID()
    UUID resourceId = UUID.randomUUID()
    MockMultipartFile firstFile
    MockMultipartFile secondFile

    def setup() {
        firstFile = new MockMultipartFile("picture_1", "picture_1.jpg", "text/plain", "fake_picture_1".getBytes())
        secondFile = new MockMultipartFile("picture_2", "picture_2.png", "text/plain", "fake_picture_2".getBytes())
        subject = new RentalResourceServiceImpl(Mock(UserService), Mock(RentalService), Mock(ResourceEntityRepository))
    }

    def 'uploadResources should upload resource list to database' () {
        given:
        List<MultipartFile> multipartFileList = [firstFile, secondFile]
        List<ResourceEntity> resourceEntities = null

        1 * subject.userService.getUserEntity(userId.toString()) >> new UserEntity(userId: userId)
        1 * subject.rentalService.getRentalEntity(rentalId.toString()) >> new RentalEntity(rentalId: rentalId)

        when:
        subject.uploadResources(userId.toString(), rentalId.toString(), multipartFileList)

        then:
        1 * subject.resourceEntityRepository.saveAll(_ as List<ResourceEntity>) >> { arguments -> resourceEntities = arguments[0] }
        resourceEntities instanceof List
        resourceEntities != null
        resourceEntities.size() == 2
        resourceEntities.resourceName.sort() == [firstFile.originalFilename, secondFile.originalFilename].sort()
        resourceEntities.resourceFile.sort() == [firstFile.bytes, secondFile.bytes].sort()
    }

    def 'getResource should return resource detail based on given resource id' () {
        given:
        subject.resourceEntityRepository.findByResourceId(_ as UUID) >> Optional.of(new ResourceEntity(resourceId: resourceId, resourceFile: firstFile.getBytes()))

        when:
        ResourceDetail response = subject.getResource(userId.toString(), resourceId.toString())

        then:
        response != null
        response.resourceId == resourceId.toString()
        response.message == "Success"
    }

    def 'deleteResource should delete resource by resource id' () {
        given:
        1 * subject.resourceEntityRepository.findByResourceId(_ as UUID) >> Optional.of(new ResourceEntity(resourceId: resourceId, resourceName: firstFile.originalFilename, resourceFile: firstFile.getBytes()))
        ResourceEntity resourceEntity = null

        when:
        subject.deleteResource(userId.toString(), resourceId.toString())

        then:
        1 *  subject.resourceEntityRepository.delete(_ as ResourceEntity) >> { arguments -> resourceEntity = arguments[0] }
        resourceEntity instanceof ResourceEntity
        resourceEntity.resourceName == firstFile.originalFilename
        resourceEntity.resourceFile == firstFile.bytes
    }
}
