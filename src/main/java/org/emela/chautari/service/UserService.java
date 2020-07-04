package org.emela.chautari.service;

import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.UserDetail;

public interface UserService {
    UserDetail getUserDetail(String userId);

    UserEntity getUserEntity(String userId);
}
