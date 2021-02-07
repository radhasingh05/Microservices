package com.radha.eurekaclient.controller;

import com.radha.eurekaclient.core.Orders;
import com.radha.eurekaclient.core.User;
import com.radha.eurekaclient.service.OrderService;
import com.radha.eurekaclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Orders saveOrder(@RequestBody Orders orders){
        return orderService.save(orders);
    }

    @GetMapping("/getById/{orderId}")
    public Orders getOrderById(@PathVariable(name = "orderId") Integer orderId){
        return orderService.findById(orderId).get();
    }

    @GetMapping("/getAll")
    public List<Orders> allOrders(){
        return orderService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteOrderById(@RequestParam Integer orderId){
        orderService.deleteById(orderId);
    }

    @GetMapping("/getUser")
    public User getUserById(@RequestParam("userId") Integer userId){
        return userService.getUser(userId);
    }


}
