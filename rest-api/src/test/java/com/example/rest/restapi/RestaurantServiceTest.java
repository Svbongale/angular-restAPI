package com.example.rest.restapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        restaurant = Restaurant.builder()
                .id(1)
                .dishName("Dosa")
                .dishCategory("Breakfast")
                .dishPrice(90)
                .userName("Savya")
                .userAddress("Banglore")
                .userPhone("0987654321")
                .isVeg(true)
                .build();

        Mockito.when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
    }

    @Test
    void addNewOrder() {
        restaurant = Restaurant.builder()
                .id(1)
                .dishName("Dosa")
                .dishCategory("Breakfast")
                .dishPrice(90)
                .userName("Savya")
                .userAddress("Banglore")
                .userPhone("0987654321")
                .isVeg(true)
                .build();
        restaurantService.addNewOrder(restaurant);
    }

    @Test
    void getAllOrders() {
        List<Restaurant> fetched = restaurantService.getAllOrders();
        //fetched.get(0) will return the object that is present in the first index of the array in the array that is fetched
        assertEquals(restaurant.getDishName(),fetched.get(0).getDishName());
        System.out.println(fetched);
    }

    @Test
    void getOrdersByDishName() {
        String dishName = "Dosa";
        List<Restaurant> fetched = restaurantService.getOrdersByDishName(dishName);
        assertEquals(restaurant.getDishName(),fetched.get(0).getDishName());
    }

    @Test
    void updateOrderById() {
        int id = 1;
        restaurant.setDishName("Idli");
        Mockito.when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
        restaurantService.updateOrderById(restaurant);
        assertEquals(restaurant.getDishName(),"Idli");
    }

    // Has bug and deletes actual data
    @Test
    void deleteOrderById() {
        Integer id = 70;
        restaurantService.deleteOrder(id);

    }
}