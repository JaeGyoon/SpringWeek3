package com.sparta.springweek3.Test3_Order.Order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController
{
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderservice)
    {
        this.orderService = orderservice;
    }

    @PostMapping("/order/request")
    public Orders RegisterRestaurant (@RequestBody OrderDTO orderDto)
    {
//        System.out.println(orderDto.getRestaurantId());

        Orders asdf = orderService.registerOrder(orderDto);

//        System.out.println(asdf.getRestaurantName());
//        System.out.println(asdf.getFoods().size());
//        System.out.println(asdf.getDeliveryFee());
//        System.out.println(asdf.getTotalPrice());

        return asdf;

    }


    @GetMapping("/orders")
    public List<OrdersDTO> getOrders()
    {
        return orderService.getOrders();
    }

}
