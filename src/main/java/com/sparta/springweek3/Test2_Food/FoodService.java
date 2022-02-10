package com.sparta.springweek3.Test2_Food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodService
{
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository)
    {
        this.foodRepository = foodRepository;
    }

    @Transactional
    public void registerFood(List<FoodDTO> ListDTO, Long restaurantId)
    {
        String foodName;
        int foodPrice;

        for ( FoodDTO DTO : ListDTO)
        {
            foodName =  DTO.getName();
            foodPrice = DTO.getPrice();
            DTO.setRestaurantId(restaurantId);

            // 음식 가격 에러 처리.
            if ( foodPrice < 100)
            {
                throw new IllegalArgumentException("100원 미만 에러");
            }
            else if ( foodPrice > 1000000)
            {
                throw new IllegalArgumentException("1000000원 초과 에러");
            }
            else if ( foodPrice % 100 != 0)
            {
                throw new IllegalArgumentException("100원 단위로 입력 안됨 에러");
            }

           Food df = foodRepository.findFoodByRestaurantIdAndName(restaurantId,foodName);



            if ( df != null)
            {
                throw new IllegalArgumentException("이름 중복");
            }


//        (restaurantId,foodName);

//            Optional<Food> found = foodRepository.findFoodByRestaurantAndName(restaurant, requestDto.getName());
//            if(found.isPresent())
//            {
//                throw new IllegalArgumentException("중복된 이름의 음식이 존재합니다.");
//            }









            Food food = new Food(DTO);

            foodRepository.save(food);

        }

    }

    public List<Food> getFoodList(Long restaurantId)
    {
        List<Food> foodList = foodRepository.findAllByRestaurantIdOrderById(restaurantId);
        return foodList;
    }
}
