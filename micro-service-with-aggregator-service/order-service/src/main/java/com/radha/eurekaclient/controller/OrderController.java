package com.radha.eurekaclient.controller;

import com.radha.eurekaclient.core.Orders;
import com.radha.eurekaclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public Orders saveOrder(@RequestBody Orders orders){
        return orderService.save(orders);
    }

    @GetMapping("/getById/{orderId}")
    public Optional<Orders> getOrderById(@PathVariable(name = "orderId") Integer orderId){
        return orderService.findById(orderId);
    }

    @GetMapping("/getAll")
    public List<Orders> allOrders(){
        return orderService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteOrderById(@RequestParam Integer orderId){
        orderService.deleteById(orderId);
    }

    @GetMapping("/test")
    public String testRestTemplate(){
        return "hello from order service";
    }


}
