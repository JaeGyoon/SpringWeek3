package com.sparta.springweek3.Test1_Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService
{
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }


    public Restaurant registerRestaurant(RestaurantDTO requestDto)
    {
        int deliveryFee = requestDto.getDeliveryFee();
        int minOrderPrice = requestDto.getMinOrderPrice();


        // 기본 배달비 에러 설정.
        if ( deliveryFee < 0)
        {
            throw new IllegalArgumentException("0원 미만 에러");
        }
        else if ( deliveryFee > 10000)
        {
            throw new IllegalArgumentException("10000원 초과 에러");
        }
        else if ( deliveryFee % 500 != 0)
        {
            throw new IllegalArgumentException("500원 단위로 입력 안됨 에러");
        }


        // 최소주문 가격 에러 설정
        if ( minOrderPrice < 1000)
        {
            throw new IllegalArgumentException("1000원 미만 에러");
        }
        else if ( minOrderPrice > 100000 )
        {
            throw new IllegalArgumentException("100000원 미만 에러");
        }
        else if ( minOrderPrice % 100 != 0)
        {
            throw new IllegalArgumentException("100원 단위로 입력 안됨 에러");
        }



        Restaurant restaurant =new Restaurant(requestDto);



        restaurantRepository.save(restaurant);

        return restaurant;
    }
}
