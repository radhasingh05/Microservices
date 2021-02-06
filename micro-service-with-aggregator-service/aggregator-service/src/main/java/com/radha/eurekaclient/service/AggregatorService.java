package com.radha.eurekaclient.service;

import com.radha.eurekaclient.core.OrderDetails;
import com.radha.eurekaclient.core.Orders;
import com.radha.eurekaclient.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

@Service
public class AggregatorService {

    @Autowired
    private RestTemplate restTemplate;

    private final String orderResourceUrl = "http://localhost:8090/order";
    private final String userResourceUrl = "http://localhost:9090/user";

    // Order-service
    private Orders getOrderById(Integer orderId) {
        return restTemplate.getForEntity(orderResourceUrl + "/getById/{orderId}", Orders.class, orderId).getBody();
    }

    private List<Orders> getAllOrders() {

        ResponseEntity<Orders[]> ordersResponse = restTemplate.getForEntity(orderResourceUrl + "/getAll", Orders[].class);
        if (ordersResponse.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(ordersResponse.getBody());
        }
        return null;
    }

    //user-service
    private User getUserById(Integer userId) {
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(userResourceUrl + "/getById")
                .queryParam("userId", userId).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        return restTemplate.exchange(builder.toString(), HttpMethod.GET, httpEntity, User.class).getBody();
    }

    //    The problem is due to type erasure with Java generics. When the application is running, it has no knowledge of what type of object is in the list.
//    This means the data in the list cannot be de-serialized into the appropriate type.
//    Luckily we have two options to get around this
    private List<User> getAllUsers() {
        ResponseEntity<User[]> userResponse = restTemplate.getForEntity(userResourceUrl + "/getAll", User[].class);
        if (userResponse.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(userResponse.getBody());
        }
        return null;
    }

    public List<OrderDetails> getAllOrderDetails() {

        List<Orders> orders = getAllOrders();
        List<User> users = getAllUsers();

        List<OrderDetails> orderDetails = new ArrayList<>();

        for (Orders order : orders) {
            OrderDetails orderDetail = new OrderDetails();

            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setOrderStatus(order.getOrderStatus());
            orderDetail.setStreet(order.getStreet());
            orderDetail.setCity(order.getCity());
            orderDetail.setState(order.getState());
            orderDetail.setPin(order.getPin());
            orderDetail.setCustomerId(order.getCustomerId());

            for (User user : users) {
                if (orderDetail.getCustomerId() == user.getUserId()) {
                    orderDetail.setFirstName(user.getFirstName());
                    orderDetail.setLastName(user.getLastName());
                    orderDetail.setEmailId(user.getEmailId());
                    orderDetail.setGender(user.getGender());
                }
            }
            orderDetails.add(orderDetail);
        }

        return orderDetails;
    }

    public OrderDetails getOrderDetails(Integer orderId) {
        Orders orders = getOrderById(orderId);
        User user = getUserById(orders.getCustomerId());

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(orders.getOrderId());
        orderDetails.setOrderStatus(orders.getOrderStatus());
        orderDetails.setStreet(orders.getStreet());
        orderDetails.setCity(orders.getCity());
        orderDetails.setState(orders.getState());
        orderDetails.setPin(orders.getPin());
        orderDetails.setCustomerId(orders.getCustomerId());

        orderDetails.setFirstName(user.getFirstName());
        orderDetails.setLastName(user.getLastName());
        orderDetails.setEmailId(user.getEmailId());
        orderDetails.setGender(user.getGender());

        return orderDetails;
    }


    public ResponseEntity<String> test() throws URISyntaxException {

        final String baseUrl = "http://localhost:8090/order/test";
        URI uri = new URI(baseUrl);
        System.out.println(restTemplate);

        return restTemplate.getForEntity(uri, String.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
