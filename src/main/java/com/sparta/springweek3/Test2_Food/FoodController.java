package com.sparta.springweek3.Test2_Food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController
{
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodservice)
    {
        this.foodService = foodservice;
    }

    // 음식점 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void RegisterRestaurant (@RequestBody List<FoodDTO> ListDTO, @PathVariable Long restaurantId)
    {
        foodService.registerFood(ListDTO,restaurantId);
    }


    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoodList(@PathVariable Long restaurantId)
    {
        List<Food> foodList = foodService.getFoodList(restaurantId);
        return foodList;
    }


}
