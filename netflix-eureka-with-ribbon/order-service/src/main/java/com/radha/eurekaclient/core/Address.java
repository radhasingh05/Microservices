package com.radha.eurekaclient.core;

import lombok.Data;

import javax.persistence.*;

@Data
public class Address {

    private Integer id;
    private String street;
    private String city;
    private String state;
    private Integer pin;


}

