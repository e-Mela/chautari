package org.emela.chautari.service;

import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.Address;

public interface AddressService {
    void saveAddress(Address address, UserEntity userEntity);
}
