//package com.sparta.springweek3.Test3_Order.FoodInfo;
//
//import com.sparta.springweek3.Test2_Food.Food;
//import com.sparta.springweek3.Test3_Order.Order.OrderDTO;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Setter
//@Getter // get 함수를 일괄적으로 만들어줍니다.
//@NoArgsConstructor // 기본 생성자를 만들어줍니다.
//@Entity
//public class FoodInfo {
//
//    // ID가 자동으로 생성 및 증가합니다.
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    private Long id;
//
//    @Column(nullable = false)
//    private String foodName;
//
//
//    @Column(nullable = false)
//    private int Quantity;
//
//
//    @Column(nullable = false)
//    private int price;
//
//    public FoodInfo(String foodName, int Quantity, int price)
//    {
//        this.foodName = foodName;
//        this.Quantity = Quantity;
//        this.price = price;
//
//
//    }
//}
