package org.emela.chautari.service;

import org.emela.chautari.domain.AddressEntity;
import org.emela.chautari.domain.UserEntity;
import org.emela.chautari.model.Address;
import org.emela.chautari.mapper.AddressEntityMapper;
import org.emela.chautari.repository.AddressEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressEntityMapper addressEntityMapper;
    private AddressEntityRepository addressEntityRepository;

    @Autowired
    public AddressService(AddressEntityMapper addressEntityMapper, AddressEntityRepository addressEntityRepository) {
        this.addressEntityMapper = addressEntityMapper;
        this.addressEntityRepository = addressEntityRepository;
    }

    public void saveAddress(Address address, UserEntity userEntity) {
        AddressEntity entity = addressEntityMapper.toAddressEntity(address);
        entity.setUserEntity(userEntity);
        addressEntityRepository.save(entity);
    }
}