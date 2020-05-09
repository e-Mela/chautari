package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
public class AddressEntity {

    private String address1;

    private String address2;

    private String address3;

    private String city;

    private String state;

    private String county;

    private String zipCode;

}
