package com.sparta.springweek3.Test1_Restaurant;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Getter
public class RestaurantDTO
{
    private String name;

    private int minOrderPrice;

    private int deliveryFee;
}
