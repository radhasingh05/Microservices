package com.radha.eurekaclient.core;

import lombok.Data;

import javax.persistence.*;

@Data
public class User{
    private Integer userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String gender;
    private Address address;
}
