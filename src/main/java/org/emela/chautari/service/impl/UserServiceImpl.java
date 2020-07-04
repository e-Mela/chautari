package org.emela.chautari.service.impl;

import lombok.extern.log4j.Log4j2;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.exception.RentalServiceException;
import org.emela.chautari.exception.ResourceNotFoundException;
import org.emela.chautari.mapper.UserEntityMapper;
import org.emela.chautari.model.UserDetail;
import org.emela.chautari.repository.UserEntityRepository;
import org.emela.chautari.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;

    public UserServiceImpl(final UserEntityRepository userEntityRepository,
                           final UserEntityMapper userEntityMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserDetail getUserDetail(String userId) {
        UserDetail userDetail = null;
        try {
            userDetail = userEntityMapper.toUserAccountDetail(getUserEntity(userId)).getUser();
        } catch (Exception exception) {
            log.error("Fail to retrieve user detail from database. user-id {}", userId, exception);
            throw new RentalServiceException("Fail to retrieve user detail from database", exception);
        }
        return userDetail;
    }

    @Override
    public UserEntity getUserEntity(String userId) {
        UserEntity userEntity;
        try {
            userEntity =
                    userEntityRepository.findByUserId(UUID.fromString(userId)).orElseThrow(ResourceNotFoundException::new);
        } catch (Exception exception) {
            log.error("User Entity not found for user-id {}", userId, exception);
            throw new RentalServiceException("User Entity not found for user-id" + userId, exception);
        }
        return userEntity;
    }
}
