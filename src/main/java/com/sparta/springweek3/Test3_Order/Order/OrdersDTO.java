package com.sparta.springweek3.Test3_Order.Order;

import com.sparta.springweek3.Test3_Order.FoodInfo.FoodInfo2;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.


public class OrdersDTO
{

    private String restaurantName;

    private List<FoodInfo2> foods;

    private int deliveryFee;

    private int totalPrice;

    public OrdersDTO(String restaurantName, List<FoodInfo2> foods, int deliveryFee, int totalPrice)
    {
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }

    public OrdersDTO(Orders Orders)
    {
        this.restaurantName = Orders.getRestaurantName();
        this.foods = Orders.getFoods();
        this.deliveryFee = Orders.getDeliveryFee();
        this.totalPrice = Orders.getTotalPrice();
    }

}