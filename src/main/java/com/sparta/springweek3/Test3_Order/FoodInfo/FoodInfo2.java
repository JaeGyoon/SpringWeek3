package com.sparta.springweek3.Test3_Order.FoodInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity
@NoArgsConstructor // 기본 생성자를 만들어줍니다.

public class FoodInfo2 {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // ID가 자동으로 생성 및 증가합니다.

    private String name;

    private int Quantity;

    private int price;

    public FoodInfo2(String name, int Quantity, int price)
    {
        this.name = name;
        this.Quantity = Quantity;
        this.price = price;


    }
}
