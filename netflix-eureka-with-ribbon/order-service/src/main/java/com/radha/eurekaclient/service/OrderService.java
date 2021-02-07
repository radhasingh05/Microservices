package com.radha.eurekaclient.service;

import com.radha.eurekaclient.core.Orders;
import com.radha.eurekaclient.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Orders save(Orders orders){
        return orderRepository.save(orders);
    }

    public Optional<Orders> findById(Integer integer){
        return orderRepository.findById(integer);
    }

    public void deleteById(Integer integer){
        orderRepository.deleteById(integer);
    }

    public List<Orders> findAll(){
        return orderRepository.findAll();
    }

}
