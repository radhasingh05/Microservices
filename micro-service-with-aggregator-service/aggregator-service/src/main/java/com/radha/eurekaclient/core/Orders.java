package com.radha.eurekaclient.core;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Orders {

    private Integer orderId;
    private String orderStatus;
    private Integer customerId;
    private String street;
    private String city;
    private String state;
    private Integer pin;
}
