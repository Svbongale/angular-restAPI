package com.example.rest.restapi;

import lombok.Builder;

import javax.persistence.*;

@Builder
@Entity
@Table
public class Restaurant {
    @Id
    @SequenceGenerator(
            name = "dish_sequence",
            sequenceName = "dish_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dish_sequence"
    )
    private Integer id;
    private String dishName;
    private String dishCategory;
    private String userName;
    private String userPhone;
    private String userAddress;
    private Integer dishPrice;
    private boolean isVeg;

    public Restaurant() {

    }

    public Restaurant(String dishName, String dishCategory, String userName, String userPhone, String userAddress, Integer dishPrice, boolean isVeg) {
        this.dishName = dishName;
        this.dishCategory = dishCategory;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.dishPrice = dishPrice;
        this.isVeg = isVeg;
    }

    public Restaurant(Integer id, String dishName, String dishCategory, String userName, String userPhone, String userAddress, Integer dishPrice, boolean isVeg) {
        this.id = id;
        this.dishName = dishName;
        this.dishCategory = dishCategory;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.dishPrice = dishPrice;
        this.isVeg = isVeg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public double getDishPrice(double v) {
        return dishPrice;
    }

    public void setDishPrice(Integer dishPrice) {
        this.dishPrice = dishPrice;
    }

    public boolean getIsVeg() {
        return isVeg;
    }

    public void setVeg(boolean veg) {
        this.isVeg = veg;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", dishCategory='" + dishCategory + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", dishPrice=" + dishPrice +
                ", isVeg=" + isVeg +
                '}';
    }
}
