package com.sparta.springweek3.Test2_Food;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long>
{
    List<Food> findAllByRestaurantIdOrderById(Long postId);

    Food findFoodByRestaurantIdAndName(Long restaurantId , String name);
    Food findFoodById(Long ID);




}
