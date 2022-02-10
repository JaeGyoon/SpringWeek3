package com.sparta.springweek3.Test1_Restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class RestaurantController
{
    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantService restaurantService, RestaurantRepository restaurantRepository)    // @Service가 설정되어야 함.
    {
        this.restaurantService = restaurantService;
        this.restaurantRepository = restaurantRepository;
    }

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant RegisterRestaurant (@RequestBody RestaurantDTO requestDto)
    {
        return restaurantService.registerRestaurant(requestDto);
    }


    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant()
    {
        return restaurantRepository.findAll();
    }



}
