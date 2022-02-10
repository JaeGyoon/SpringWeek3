package com.sparta.springweek3.Test3_Order.Order;

import com.sparta.springweek3.Test3_Order.FoodInfo.FoodInfoDTO;

import lombok.Getter;

import java.util.List;


@Getter
public class OrderDTO
{
    private Long restaurantId;

    private List<FoodInfoDTO> foods;



}
