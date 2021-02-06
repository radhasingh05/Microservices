package com.radha.eurekaclient.controller;

import com.radha.eurekaclient.core.OrderDetails;
import com.radha.eurekaclient.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/aggregator")
public class AggregatorController {

    @Autowired
    private AggregatorService aggregatorService;

    @GetMapping("/getOrderDetails")
    public OrderDetails getOrderDetails(@RequestParam(name = "orderId") Integer orderId){
        return aggregatorService.getOrderDetails(orderId);
    }

    @GetMapping("/getAllOrderDetails")
    public List<OrderDetails> getAllOrderDetails(){
        return aggregatorService. getAllOrderDetails();
    }



    @GetMapping("/test")
    public String test() throws URISyntaxException {
        return aggregatorService.test().toString();
    }



}
