package com.sparta.springweek3.Test2_Food;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Getter
public class FoodDTO
{
    private Long restaurantId;

    private String name;

    private int price;
}
