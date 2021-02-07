package com.radha.eurekaclient.core;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="orders")
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_Id")
    private Integer orderId;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pin")
    private Integer pin;
}
