package com.example.rest.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void findAllByDishName() {
        List<Restaurant> dishesByDishNAme = restaurantRepository.findAllByDishName("Dosa");
        System.out.println(dishesByDishNAme);
    }

    @Test
    void findById() {
        Optional<Restaurant> id = restaurantRepository.findById(1);
        System.out.println(id);
    }
}