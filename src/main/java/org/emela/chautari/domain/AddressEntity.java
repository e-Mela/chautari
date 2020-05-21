package org.emela.chautari.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "address")
public class AddressEntity extends BaseEntity {

    @Id
    private long id;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String country;

    private int zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private RentalEntity rentalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

}
