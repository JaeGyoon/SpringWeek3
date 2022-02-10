package com.sparta.springweek3.Test1_Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{
    Restaurant findRestaurantById(Long restaurantId);

}