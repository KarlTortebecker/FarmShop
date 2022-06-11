package org.casjedcem.Farmshop.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@Embeddable
public class Address {


    @Column(name = "USER_COUNTRY", nullable = false)
    private String userCountry;

    @Column(name = "USER_TOWN", nullable = false)
    private String userTown;

    @Column(name = "USER_QUARTER", nullable = false)
    private String userQuarter;

    @Column(name = "USER_STREET", nullable = true)
    private String userStreet;


}
