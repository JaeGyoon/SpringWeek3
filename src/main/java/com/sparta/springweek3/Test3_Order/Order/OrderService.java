package com.sparta.springweek3.Test3_Order.Order;


import com.sparta.springweek3.Test1_Restaurant.RestaurantRepository;
import com.sparta.springweek3.Test2_Food.FoodRepository;


import com.sparta.springweek3.Test3_Order.FoodInfo.FoodInfo2;
import com.sparta.springweek3.Test3_Order.FoodInfo.FoodInfoDTO;
//import com.sparta.springweek3.Test3_Order.FoodInfo.FoodInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService
{

    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
//    private final FoodInfoRepository foodInfoRepository;

    @Autowired
    public OrderService( OrderRepository orderRepository, FoodRepository foodRepository, RestaurantRepository restaurantRepository)
    {
        this.orderRepository = orderRepository;
        this.foodRepository =  foodRepository;
        this.restaurantRepository = restaurantRepository;
//        this.foodInfoRepository = foodInfoRepository;
    }


    public Orders registerOrder(OrderDTO orderDTO)
    {
//        Restaurant restaurant = restaurantRepository.findById(orderDTO.getRestaurantId())
//                .orElseThrow( () -> new NullPointerException("레스토랑 오류")  );

        int totalPrice = 0;

        List<FoodInfoDTO> foodInfosDTO = orderDTO.getFoods();
        List<FoodInfo2> foodInfos = new ArrayList<>();

        Long restaurantId = orderDTO.getRestaurantId();

        for (FoodInfoDTO DTO : foodInfosDTO )
        {
            System.out.println(DTO.getId());
            System.out.println(DTO.getQuantity());

            if (DTO.getQuantity() < 1  )
            {
                throw new IllegalArgumentException("수량 1 미만 에러");
            }
            else if (DTO.getQuantity() > 100  )
            {
                throw new IllegalArgumentException("수량 100 초과 에러");
            }


            String foodName = foodRepository.findFoodById(DTO.getId()).getName();
            System.out.println(foodName);

            int price = foodRepository.findFoodByRestaurantIdAndName(restaurantId,foodName).getPrice();
            System.out.println(price);

            int quantityPrice = (DTO.getQuantity()) * price;

            FoodInfo2 foodInfo = new FoodInfo2(foodName, DTO.getQuantity(), quantityPrice);
//

            foodInfos.add(foodInfo);
//            foodInfoRepository.save(foodInfo);
//
            totalPrice += (DTO.getQuantity()) * price;

            System.out.println(totalPrice);
//            Food food = foodRepository.findById(DTO.getId())
//                    .orElseThrow( () -> new NullPointerException("푸드 오류"));
//
//            FoodInfo foodInfo = new FoodInfo(food.getName(), quantity, food.getPrice());


        }

        if (totalPrice < restaurantRepository.findRestaurantById(restaurantId).getMinOrderPrice() )
        {
            throw new IllegalArgumentException("최소 주문 가격 미만 에러");
        }


        int deliveryFee = restaurantRepository.getById(restaurantId).getDeliveryFee();

        totalPrice += deliveryFee;

        String storeName = restaurantRepository.getById(restaurantId).getName();



        Orders orders = new Orders(storeName, foodInfos, deliveryFee, totalPrice);

        orderRepository.save(orders);
//
        System.out.println(orders.getRestaurantName());
        System.out.println(orders.getTotalPrice());


        return orders;

//        Orders dd = new Orders();
//        return dd;

//        Long restaurantId = orderDTO.getRestaurantId();
////        System.out.println(restaurantId);
//        List<FoodInfoDTO> foodsDTO = orderDTO.getFoods();
////        System.out.println(foodsDTO);
//
//        List<FoodInfo> foods = new ArrayList<>();
////        System.out.println(foods);
//
//        int totalPrice = 0;
////        System.out.println(totalPrice);
//
////        for ( FoodInfoDTO aa : foodsDTO)
////        {
////            System.out.println(aa.getFoodID());
////            System.out.println(aa.getCount());
////        }
//
////        for ( int i = 0; i< foodsDTO.size(); i++)
////        {
////            System.out.println(foodsDTO.get(i).getFoodId());
////            System.out.println(foodsDTO.get(i).getCount());
////        }
//
//
//        for ( FoodInfoDTO foodDTO : foodsDTO)
//        {
//
////            System.out.println(foodDTO);
//
//
//            Long foodID = foodDTO.getFoodId();
//
//            System.out.println(foodDTO.getFoodId());
//            System.out.println(foodDTO.getCount());
//
//            String foodName = foodRepository.findFoodById(foodID).getName();
//
//            int price = foodRepository.findFoodByRestaurantIdAndName(restaurantId,foodName).getPrice();
//
//            System.out.println(price);
//
//            FoodInfo food = new FoodInfo(foodDTO, price, foodName);
//
//            foods.add(food);
//
//            totalPrice += (foodDTO.getCount()) * price;
//
//        }
//
//        int deliveryFee = restaurantRepository.getById(restaurantId).getDeliveryFee();
//
//        totalPrice += deliveryFee;
//
//        String StoreName = restaurantRepository.getById(restaurantId).getName();
//
//        Order order = new Order (StoreName, foods, deliveryFee, totalPrice);
//
//        orderRepository.save(order);


    }

    public List<OrdersDTO> getOrders()
    {
       List<Orders> OrderDB = orderRepository.findAll();
       List<OrdersDTO> responses = new ArrayList<>();

       for (Orders responseOrder : OrderDB)
       {
           OrdersDTO response = new OrdersDTO(responseOrder);
           responses.add(response);
       }

       return responses;
    }
}
