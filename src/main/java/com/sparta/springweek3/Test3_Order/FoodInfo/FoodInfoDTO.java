package com.sparta.springweek3.Test3_Order.FoodInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본 생성자를 만들어줍니다.
//@Entity
@Getter
public class FoodInfoDTO
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    private int quantity;
}
