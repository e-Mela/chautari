package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "address")
@NoArgsConstructor
public class AddressEntity {

    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private RentalEntity rentalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    private String address1;

    private String address2;

    private String address3;

    private String city;

    private String state;

    private String county;

    private String zipCode;

}
