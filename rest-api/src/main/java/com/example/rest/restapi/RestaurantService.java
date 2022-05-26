package com.example.rest.restapi;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

//    Fetch all the restaurant orders
    public List<Restaurant> getAllOrders() {
        System.out.println(restaurantRepository.findAll());
        return restaurantRepository.findAll();
    }

//    Fetch a single order by its ID
    public List<Restaurant> getOrdersByDishName(String dishName) throws IllegalStateException{
        List<Restaurant> orderList = restaurantRepository.findAllByDishName(dishName);
        if (orderList.isEmpty()){
         throw new IllegalStateException("There are no orders for the dish " + dishName);
        }
        return orderList;
    }

//    Add/Post a new order to the table
    public void addNewOrder(Restaurant restaurant) {
        System.out.println(restaurant);
        if(restaurant==null) {
            throw new IllegalStateException("Cannot add the order since it is null");
        }

        restaurantRepository.save(restaurant);
    }

//    Delete an existing order form the table
    public void deleteOrder(Integer orderId) {
        boolean exists = restaurantRepository.existsById(orderId);
        if(!exists) {
            throw new IllegalStateException("The order with the order id: "+ orderId+ " does not exists and cannot be deleted");
        }
        restaurantRepository.deleteById(orderId);
    }

//    Update the order details in the table by order Id
//    @Transactional
//    public void updateOrderById(Integer orderId,String dishName, String dishCategory, double dishPrice, boolean isVeg) {
//        Restaurant restaurant = restaurantRepository.findById(orderId).orElseThrow(()->new IllegalStateException("Order with order id: "+ orderId+"does not exists and cannot be updated"));
//        if (dishName!=null && dishName.length()>0) {
//            restaurant.setDishName(dishName);
//        }if (dishCategory!=null && dishCategory.length()>0) {
//            restaurant.setDishCategory(dishCategory);
//        }if (dishPrice>0) {
//            restaurant.setDishPrice(dishPrice);
//        }
//        restaurant.setVeg(isVeg);
//    }
        @Transactional
        public void updateOrderById(Restaurant restaurant) {
            restaurantRepository.save(restaurant);
        }

        // @Transactional
        // public void updateOrderById(Student student) {
        //     studentRepository.save(student);
        // }


}

