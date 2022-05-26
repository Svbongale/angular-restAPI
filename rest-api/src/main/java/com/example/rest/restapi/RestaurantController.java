package com.example.rest.restapi;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllOrders() {
     return restaurantService.getAllOrders();
    }

    @GetMapping(path = "/order/{dishName}")
    public List<Restaurant> getOrderByDishName(@PathVariable("dishName") String dishName) {
        return restaurantService.getOrdersByDishName(dishName);
    }

    @PostMapping
    public void addNewOrder(@RequestBody Restaurant restaurant) {
        restaurantService.addNewOrder(restaurant);
    }

    @DeleteMapping(path = "/delete/{orderId}")
    public void deleteOrder(@PathVariable("orderId")Integer orderId){
        restaurantService.deleteOrder(orderId);
    }

//    @PutMapping(path = "{orderId}")
//    //@RequestParam(required = false) String dishName, String dishCategory, double dishPrice, boolean isVeg
//    public void updateOrder(@PathVariable("orderId") Integer orderId, @RequestBody Restaurant restaurant) {
//        restaurantService.updateOrderById(orderId,restaurant.getDishName(), restaurant.getDishCategory(),restaurant.getDishPrice(),restaurant.getIsVeg());
//    }


    @PutMapping(path = "/update")
    //@RequestParam(required = false) String dishName, String dishCategory, double dishPrice, boolean isVeg
    public void updateOrder(@RequestBody Restaurant restaurant) {
        restaurantService.updateOrderById(restaurant);
    }

    // @PutMapping(path = "/update")
    // public void updateStudent(@RequestBody Student student) {
    //     studentService.updateStudentById(student);
    // }
}
