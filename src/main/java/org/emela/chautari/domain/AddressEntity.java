package org.emela.chautari.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "address")
public class AddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
