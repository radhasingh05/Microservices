package com.radha.eurekaclient.core;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "address")
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pin")
    private Integer pin;


}

